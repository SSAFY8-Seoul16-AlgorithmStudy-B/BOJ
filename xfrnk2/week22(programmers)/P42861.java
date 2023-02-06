package programmers;

import java.util.PriorityQueue;

public class P42861 {

	static int N;
	static int[] parents;

	public static void make() {
		parents = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		if (aR == bR)
			return true;
		parents[bR] = aR;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(solution(4, new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 }

		}));
	}

	public static int solution(int n, int[][] costs) {

		N = n;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < costs.length; i++) {
			pq.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
		}

		make();
		int cnt = 0;
		int sum = 0;

		while (!pq.isEmpty()) {

			Node cur = pq.poll();
			
			if (!union(cur.from, cur.to)) {
				cnt++;
				sum += cur.cost;
				if (cnt == n - 1) {
					break;
				}
			}
		}
		return sum;

	}

	static class Node implements Comparable<Node> {
		int from, to, cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return String.format("Node [from=%s, to=%s, cost=%s]", from, to, cost);
		}

	}

}
