import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, N, M;
	static byte[][] map;
	static int[][] di1 = new int[][] { { -1, -2 }, { 1, -2 }, { -1, 2 }, { 1, 2 }, { -2, -1 }, { -2, 1 }, { 2, -1 },
			{ 2, 1 } };
	static int[][] di2 = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static boolean[][][] visited;

	static class Pos {
		int x, y, k;

		public Pos(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", k=" + k + "]";
		}

	}

	public static boolean isOut(int x, int y) {
		return x < 0 || y < 0 || N <= x || M <= y;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		;
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new byte[N][M];
		visited = new boolean[N][M][K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Byte.parseByte(st.nextToken());
			}
		}

		int tick = 0;
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(0, 0, 0));
		int ans = Integer.MAX_VALUE;

		loop: while (!queue.isEmpty()) {
			tick++;
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Pos p = queue.poll();
	;

				if (p.x == N - 1 && p.y == M - 1) {
					ans = Math.min(ans, tick - 1);
					break loop;

				}

				if (p.k < K) {
					for (int j = 0; j < 8; j++) {
						int nx = p.x + di1[j][0], ny = p.y + di1[j][1];
						if (isOut(nx, ny) || visited[nx][ny][p.k + 1] || map[nx][ny] == 1)
							continue;

						visited[nx][ny][p.k + 1] = true;
						queue.offer(new Pos(nx, ny, p.k + 1));
					}
				}

				for (int j = 0; j < 4; j++) {
					int nx = p.x + di2[j][0], ny = p.y + di2[j][1];
					if (isOut(nx, ny) || visited[nx][ny][p.k] || map[nx][ny] == 1)
						continue;
					visited[nx][ny][p.k] = true;
					queue.offer(new Pos(nx, ny, p.k));
				}
			}

		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

}
