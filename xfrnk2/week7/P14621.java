import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static String[] sex;
	static ArrayList<Edge> edges;
	static int[] parents;

	static class Edge implements Comparable<Edge> {
		int s, e, w;

		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}

	public static void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sex = new String[N + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			sex[i] = st.nextToken();
		}

		edges = new ArrayList<>(M);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		Collections.sort(edges, null);
	}

	public static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aR, bR;
		aR = find(a);
		bR = find(b);
		if (aR == bR)
			return false;
		parents[bR] = aR;
		return true;
	}

	public static void main(String[] args) throws IOException {
		init();
		make();
		int ans = 0;
		int cnt = 0;

		for (Edge edge : edges) {

			if (sex[edge.s].equals(sex[edge.e]))
				continue;
			if (union(edge.s, edge.e)) {
				ans += edge.w;
				if (++cnt == N - 1) {
					System.out.print(ans);
					System.exit(0);
				}

//				
//				

			}
		}
		System.out.println(-1);
	}

}
