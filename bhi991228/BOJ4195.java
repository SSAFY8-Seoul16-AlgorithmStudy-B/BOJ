import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ4195 {

	static int size = 100000*2;
	static int parent[] = new int[size];
	static int relNum[] = new int[size];
	
	private static void make() {
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			relNum[i] = 1;
		}
	}
	
	private static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	private static int union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA != rootB) {
			parent[rootB] = rootA;
			relNum[rootA] += relNum[rootB];
		}
		
		return relNum[rootA];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			map.clear();
			make();
			int F = Integer.parseInt(br.readLine());
			int idx = 0;
			
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				
				if(!map.containsKey(f1)) map.put(f1, idx++);
				if(!map.containsKey(f2)) map.put(f2, idx++);
				
				int idx1 = map.get(f1);
				int idx2 = map.get(f2);
				sb.append(union(idx1, idx2)+"\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
