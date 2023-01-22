package boj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P16724 {
	static int N, M;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static int[][] map, check;
	static int cnt = 0;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				char cur = line.charAt(j);
				map[i][j] = cur == 'L' ? 2 : cur == 'R' ? 3 : cur == 'U' ? 0 : 1;
			}
			Arrays.fill(check[i], -1);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					continue;
				search(i, j);
			}
		}
		System.out.print(cnt);

	}

	public static int search(int x, int y) {
		if (check[x][y] != -1)
			return check[x][y];
		if (x < 0 || y < 0 || N <= x || M <= y || visited[x][y])
			return cnt++;
		visited[x][y] = true;
		return check[x][y] = search(x + di[map[x][y]][0], x + di[map[x][y]][1]);
	}

}