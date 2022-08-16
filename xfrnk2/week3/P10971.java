package boj.p10k.p10900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10971 {
	static int ans = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		solution(n, matrix);
	}

	public static void solution(int n, int[][] matrix) {
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			visited[i] = true;
			cycle(n, i, 0, matrix, i);
		}
		System.out.print(ans);
	}

	private static boolean checkIsAllVisited(int n) {
		for (boolean flag : visited) {
			if (!flag)
				return false;
		}
		return true;
	}

	public static void cycle(final int n, int start, int cost, int[][] matrix, int pos) {
		if (checkIsAllVisited(n)) {
			if (matrix[pos][start] == 0)
				return;
			ans = Math.min(ans, cost + matrix[pos][0]);
			return;
		}
		for (int i = 1; i < n; i++) {
			if (matrix[pos][i] != 0 && !visited[i]) {
				visited[i] = true;
				cycle(n, start, cost + matrix[pos][i], matrix, i);
				visited[i] = false;
			}
		}
	}
}
