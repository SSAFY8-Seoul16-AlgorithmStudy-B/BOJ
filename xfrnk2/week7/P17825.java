package boj;

import java.util.Arrays;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17825 {

	static int[] choices;
	static Node[] players;
	static int ans;

	static Node startNode = null;

	static class Node {

		int point;
		Node nextNode;
		Node shortCutNode;

		public Node(int point, Node nextNode, Node shortCutNode) {
			super();

			this.point = point;
			this.nextNode = nextNode;
			this.shortCutNode = shortCutNode;
		}

		public Node next(int start) {
			if (this.shortCutNode != null && (start == 10 || start == 20 || start == 30)) {
				return this.shortCutNode;
			}
			return this.nextNode;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((nextNode == null) ? 0 : nextNode.hashCode());
			result = prime * result + point;
			result = prime * result + ((shortCutNode == null) ? 0 : shortCutNode.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (nextNode == null) {
				if (other.nextNode != null)
					return false;
			} else if (!nextNode.equals(other.nextNode))
				return false;
			if (point != other.point)
				return false;
			if (shortCutNode == null) {
				if (other.shortCutNode != null)
					return false;
			} else if (!shortCutNode.equals(other.shortCutNode))
				return false;
			return true;
		}

	}

	public static void makeBoard() {

		Node fourty = new Node(40, null, null);
		Node[] from25To40 = new Node[4];
		Node[] from30To40 = new Node[6];

		from25To40[0] = fourty;
		for (int i = 1; i <= 3; i++) {
			from25To40[i] = new Node(40 - 5 * i, from25To40[i - 1], null);
		} // i = 3 is 25

		from30To40[0] = fourty;
		for (int i = 1; i <= 5; i++) {
			from30To40[i] = new Node(40 - 2 * i, from30To40[i - 1], null);
		} // i = 5 is 30

		Node thirty = from30To40[5];

		Node[] from20To30 = new Node[6];
		from20To30[0] = thirty;
		for (int i = 1; i <= 5; i++) {
			from20To30[i] = new Node(30 - 2 * i, from20To30[i - 1], null);
		} // i = 5 is 20

		Node twenty = from20To30[5];
		Node[] from10To20 = new Node[6];
		from10To20[0] = twenty;
		for (int i = 1; i <= 5; i++) {
			from10To20[i] = new Node(20 - 2 * i, from10To20[i - 1], null);
		} // i = 5 is 10

		Node ten = from10To20[5];
		Node[] from0To10 = new Node[6];
		from0To10[0] = ten;
		for (int i = 1; i <= 5; i++) {
			from0To10[i] = new Node(10 - 2 * i, from0To10[i - 1], null);
		} // i = 5 is 0
		startNode = from0To10[5]; // 0번 노드

		// 중앙 잇기
		// 1. 10, 20, 30에서의 출발을 제외하고 13, 28, 22부터 잇기
		Node twentyFive = from25To40[3];
		Node[] from10To25 = new Node[4];
		from10To25[0] = twentyFive;
		for (int i = 1; i <= 3; i++) {
			from10To25[i] = new Node(19 - (i - 1) * 3, from10To25[i - 1], null);
		} // i = 3 is 13

		Node[] from30To25 = new Node[4];
		from30To25[0] = twentyFive;
		for (int i = 1; i <= 3; i++) {
			from30To25[i] = new Node(25 + i, from30To25[i - 1], null);
		} // i = 3 is 28

		Node[] from20To25 = new Node[3];
		from20To25[0] = twentyFive;
		for (int i = 1; i <= 2; i++) {
			from20To25[i] = new Node(24 - (i - 1) * 2, from20To25[i - 1], null);
		} // i = 2 is 22

		// 10, 20, 30의 지름길 연결하기
		Node thirteen = from10To25[3];
		Node twentyEight = from30To25[3];
		Node twentyTwo = from20To25[2];

		ten.shortCutNode = thirteen;
		twenty.shortCutNode = twentyTwo;
		thirty.shortCutNode = twentyEight;
	}

	public static void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		choices = new int[11];
		players = new Node[4];
		for (int i = 1; i <= 10; i++) {
			choices[i] = Integer.parseInt(st.nextToken());
		}
		makeBoard();
		Arrays.fill(players, startNode);
	}

	public static void main(String[] args) throws IOException {
		init();
		play(1, 0);
		System.out.print(ans);
	}

	public static Node getNextPosition(Node cur, int curChoice) {
		int cnt = curChoice;
		int start = cur.point;
		while (cnt-- > 0) {
			Node next = cur.next(start);
			if (next == null)
				return null;
			cur = next;
		}
		return cur;
	}

	public static boolean isMovable(Node nextNode) {
		for (Node player : players) {
			if (player != null && player.equals(nextNode))
				return false;
		}
		return true;
	}

	public static void play(int tick, int score) {
		if (tick > 10) {
			ans = Math.max(ans, score);
			return;
		}

		int curChoice = choices[tick];
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			if (players[i] == null)
				continue;
			Node nextNode = getNextPosition(players[i], curChoice);
			if (isMovable(nextNode)) {
				flag = true;

				Node prevTemp = players[i]; // 원상태 백업
				players[i] = nextNode; // 도달할 위치로 이동
				int nextScore = score; // 도달한 위치가 null이면 점수를 더할수 없음
				if (nextNode != null) {
					nextScore += players[i].point;
				}
				play(tick + 1, nextScore); // 다음 tick 진행
				players[i] = prevTemp; // 원상복귀

			} else {
				continue;
			}
		}
		if (!flag) {
			play(tick + 1, score);
		}
	}

}
