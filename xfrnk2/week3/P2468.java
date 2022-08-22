package boj.p2k.p2400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2468 {
	static int N, top;
	static int[][] di = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] area;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		//area = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				top = Math.max(top, cur);
				area[i][j] = cur;
			}
		}
		solution(N, area, top);
	}

	public static void search(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + di[i][0], ny = y + di[i][1];
			if (nx < 0 || ny < 0 || N <= nx || N <= ny || visited[nx][ny] || area[nx][ny] <= 0)
				continue;
			search(nx, ny);
		}
	}

	public static void solution(int n, int[][] _area, int _top)  {
		N = n;
		area = _area;
		top = _top;
		visited = new boolean[n][n];
		int ans = 1;

		for (int r = 0; r < top; r++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					area[i][j]--;
				}

			}

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && area[i][j] > 0) {
						search(i, j);
						cnt += 1;
					}
				}
			}
			visited = new boolean[N][N];
			ans = Math.max(ans, cnt);
		}
		System.out.print(ans);
	}

}
