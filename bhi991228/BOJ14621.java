import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ14621 {

	static int v;
	static int[] parent;
	
	static void make() {
		parent = new int[v+1];
		for (int i = 1; i < v+1; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int a){
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB) return false;
		
		parent[rootB] = rootA;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		int weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		ArrayList<Edge> edgeList = new ArrayList<>(edgeNum);
		
		char[] flag = new char[v+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < v+1; i++) {
			flag[i] = st.nextToken().charAt(0);
		}
		
		make();
		
		for (int i = 0; i < edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if (flag[from] != flag[to]) {
				edgeList.add(new Edge(from, to, weight));
			}
		}
		
		Collections.sort(edgeList);
		
		int num = v-1;
		int answer = 0;
		for (int i = 0, end = edgeList.size(); i < end; i++) {
			if (num == 0) break;
			
			if (union(edgeList.get(i).from, edgeList.get(i).to)) {
				answer += edgeList.get(i).weight;
				num--;
			}
		}
		
		if (num > 0) System.out.println(-1);
		else System.out.println(answer);
	}
}
