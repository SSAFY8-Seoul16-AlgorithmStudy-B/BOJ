import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16724 {

	static int size;
	static int parent[];
	
	private static void make() {
		parent = new int[size];
		
		for (int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB) return false;
		
		parent[rootB] = rootA;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][];
		size = R*C;

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		make();
		
		for (int i = 0; i < size; i++) {
			int next = 0;
			
			switch (map[i/C][i%C]) {
			case 'U': next = i-C; break;
			case 'D': next = i+C; break;
			case 'L': next = i-1; break;
			case 'R': next = i+1; break;
			default: break;
			}
			
			union(i, next);
		}
		
		int answer = 0;
		for (int i = 0; i < size; i++) {
			if (i == parent[i]) answer++;
		}
		
		System.out.println(answer);
	}

}
