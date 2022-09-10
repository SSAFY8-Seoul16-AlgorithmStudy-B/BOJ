import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4485 {

	static int N, V;
	static int[][] map;
	static ArrayList<Edge>[] adjList;
	
	static class Edge{
		int to;
		int weight;
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int problem = 0;
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			V = N*N;
			map = new int[N][N];
			adjList = new ArrayList[V];
			problem++;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			saveAdj();
			
			sb.append(String.format("Problem %d: %d\n", problem, dijkstra()));
		}
		
		System.out.println(sb.toString());
	}
	
	private static void saveAdj(){
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int verNum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//인접한 곳을 간선으로 저장
				for (int dir = 0; dir < 4; dir++) {
					int nr = i + dr[dir];
					int nc = j + dc[dir];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if (adjList[verNum] == null) adjList[verNum] = new ArrayList<>();
					adjList[verNum].add(new Edge((nr*N)+nc, map[nr][nc]));
				}
				verNum++;
			}
		}
	}

	private static int dijkstra() {
		boolean[] visited = new boolean[V];
		int[] cost = new int[V];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[0] = map[0][0];
		
		while (true) {
			int minValue = Integer.MAX_VALUE;
			int minIdx = -1;
			for (int i = 0; i < V; i++) {
				if (cost[i] < minValue && !visited[i]) {
					minValue = cost[i];
					minIdx = i;
				}
			}
			
			visited[minIdx] = true;
			if (minIdx == V-1) break;
			
			for (Edge edge : adjList[minIdx]) {
				if (!visited[edge.to] && cost[edge.to] > cost[minIdx] + edge.weight) {
					cost[edge.to] = cost[minIdx] + edge.weight;
				}
			}
		}
		
		return cost[V-1];
	}
}
