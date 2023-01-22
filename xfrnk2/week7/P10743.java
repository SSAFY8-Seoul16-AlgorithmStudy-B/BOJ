import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static float startX, startY, endX, endY;
	static int N, startIdx, endIdx, entireSize;
	static Cannon[] vertex;
	static float[] D;
	static boolean[] visited;
	static ArrayList<Edge> adjList[];

	static class Edge implements Comparable<Edge> {
		int to;
		float weight; // time

		Edge(int to, float weight) {
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Edge e) {
			return Float.compare(this.weight, e.weight);
		}
	}

	static class Cannon {
		float x, y;

		Cannon(float x, float y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void init () throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		startX = Float.parseFloat(st.nextToken());
		startY = Float.parseFloat(st.nextToken());

		st = new StringTokenizer(in.readLine());
		endX = Float.parseFloat(st.nextToken());
		endY = Float.parseFloat(st.nextToken());

		N = Integer.parseInt(in.readLine());
		
		startIdx = 0;
		endIdx = N + 1;
		entireSize = N + 2;
		
		vertex = new Cannon[entireSize];
		D = new float[entireSize]; // 시간
		Arrays.fill(D, Integer.MAX_VALUE);
		D[startIdx] = 0;
		
		visited = new boolean[entireSize];
		adjList = new ArrayList[entireSize];
		for (int i = 0; i < entireSize; i++) {
			adjList[i] = new ArrayList<Edge>();
		}

		

		vertex[startIdx] = new Cannon(startX, startY);
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			float x = Float.parseFloat(st.nextToken());
			float y = Float.parseFloat(st.nextToken());
			vertex[i] = new Cannon(x, y);
		}
		vertex[endIdx] = new Cannon(endX, endY);

	}

	public static void main(String[] args) throws IOException {

		init();

		for (int i = 1; i < entireSize; i++) {
			float dis = (float) Math
					.sqrt(Math.pow(vertex[0].x - vertex[i].x, 2) + Math.pow(vertex[0].y - vertex[i].y, 2));
			adjList[0].add(new Edge(i, (float) dis / 5)); // 목적 대포, 달려가는 시간
		}

		for (int i = 1; i < entireSize; i++) {
			for (int j = 0; j < entireSize; j++) {
				float dis = (float) Math
						.sqrt(Math.pow(vertex[i].x - vertex[j].x, 2) + Math.pow(vertex[i].y - vertex[j].y, 2));
				adjList[i].add(new Edge(j, Math.min((float) dis / 5, (float) Math.abs(dis - 50) / 5 + 2))); 
			} // 그냥 달려갔을 때와 목적 대포로 이동후 달려가는 시간의 최솟값을 weight로 가지도록 Edge를 생성
		}

		dijkstra(0);
		System.out.print(D[endIdx]);

	}

	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
	

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.to])
				continue;
			visited[cur.to] = true;
			if (cur.to ==endIdx) {
				break;
			}
			
			for (Edge edge : adjList[cur.to]) {
				if (visited[edge.to])
					continue;
				if (D[edge.to] > D[cur.to] + edge.weight) {
					D[edge.to] = D[cur.to] + edge.weight;
					pq.offer(new Edge(edge.to, D[edge.to]));
				}
			}
		}

	}

}
