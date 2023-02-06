import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, L, R;
	static int ll, rr;
	static int[] dWeight = new int[] { -1, 1 };
	static boolean[][] visit;
	static char[][] map;

	static class Pos {
		int x, y, lc, rc;

		public Pos(int x, int y, int lc, int rc) {
			super();
			this.x = x;
			this.y = y;
			this.lc = lc;
			this.rc = rc;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());

		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		Queue<Pos> q = new LinkedList<>();

		map = new char[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] == '2') {

					ll = j - L;
					rr = j + R;

					q.offer(new Pos(i, j, L, R));
					System.out.println(go(q));
				}
			}
		}
	}

	public static int go(Queue<Pos> q) {
		int cn = 0;
		while (!q.isEmpty()) {
			Pos p = q.poll();
			// 상하 먼저 탐색
			
			int x = p.x, y = p.y, lc = p.lc, rc = p.rc;
			
			// up
			int up = checkMaxupDown(p.x, p.y, 0);
			if (!visit[x + up][y]) {
				cn++;
				visit[x + up][y] = true;
				q.offer(new Pos(x + up, y, lc, rc));
			}
			// down
			int down = checkMaxupDown(p.x, p.y, 1);
			if (!visit[x + down][p.y]) {
				cn++;
				visit[x + down][p.y] = true;
				q.offer(new Pos(x + down, y, lc, rc));

			}

			// 상하탐색 후 L, R의 이동 가능 길이만큼 좌우 탐색

			for (int i = 0; i < 2; i++) {

				int ny = y + dWeight[i];
				if (ny < 0 || M <= ny || ny < ll || rr < ny || visit[x][ny] || map[x][ny] == '1')
					continue;
				if (i == 0 && lc == 0)
					continue;
				if (i == 1 && rc == 0)
					continue;
				visit[x][ny] = true;
				cn++;
				q.offer(new Pos(x, ny, i == 0 ? lc - 1 : lc, i == 1 ? rc - 1 : rc));
			}
		}
		return cn;
	}

	public static int checkMaxupDown(int x, int y, int d) {
		int cnt = 0;
		int op = d == 1 ? 1 : -1;

		for (int i = x; d == 0 ? i >= 1 : i < N - 1; i += op) {
			int nx = i + dWeight[d];
			if (map[nx][y] == '1' || visit[nx][y])
				break;
			cnt++;
		}
		return d == 0 ? -cnt : cnt;
	}

}