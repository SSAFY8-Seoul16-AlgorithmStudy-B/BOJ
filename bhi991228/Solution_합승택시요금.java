import java.util.ArrayList;
import java.util.Arrays;

public class Solution_합승택시요금 {

	static ArrayList<Edge>[] edgeList;

	class Edge {
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

		// 간선 리스트 생성 및 초기화
		edgeList = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			edgeList[i] = new ArrayList<>();
		}

		int from, to, weight;
		for (int i = 0, end = fares.length; i < end; i++) {
			from = fares[i][0];
			to = fares[i][1];
			weight = fares[i][2];

			edgeList[from].add(new Edge(to, weight));
			edgeList[to].add(new Edge(from, weight));
		}
		
		int[] costS = dijkstra(s, n);
		int[] costA = dijkstra(a, n);
		int[] costB = dijkstra(b, n);
		
		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, costS[i] + costA[i] + costB[i]);
		}
		
		return answer;
    }
	
	private static int[] dijkstra(int start, int n) {
		boolean[] visited = new boolean[n+1];
		int[] cost = new int[n+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;
		
		while (true) {
			int minValue = Integer.MAX_VALUE;
			int minIdx = -1;
			for (int i = 1; i <= n; i++) {
				if (cost[i] < minValue && !visited[i]) {
					minValue = cost[i];
					minIdx = i;
				}
			}
			
			if (minIdx == -1) break;
			visited[minIdx] = true;
			
			for (Edge edge : edgeList[minIdx]) {
				if (!visited[edge.to] && cost[edge.to] > cost[minIdx] + edge.weight) {
					cost[edge.to] = cost[minIdx] + edge.weight;
				}
			}
		}
		
		return cost;
    }
}
