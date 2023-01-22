import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int map[][];
	static int weight[][];
	static PriorityQueue<int[]> pq;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static boolean isOut(int x, int y) {
		return x < 0 || y < 0 || N <= x || N <= y;
	}

	public static void bfs(int cost, int x, int y) {
		pq.offer(new int[] { cost, x, y });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (weight[cur[1]][cur[2]] < cur[0])
				continue;
			for (int i = 0; i < 4; i++) {
				int nx = cur[1] + di[i][0];
				int ny = cur[2] + di[i][1];
				if (isOut(nx, ny))
					continue;
				if (weight[nx][ny] > cur[0] + map[nx][ny]) {
					weight[nx][ny] = cur[0] + map[nx][ny];
					pq.offer(new int[] { weight[nx][ny], nx, ny });
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 1;
		while (true) {
			N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			ans = 0;
			map = new int[N][N];
			weight = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				Arrays.fill(weight[i], Integer.MAX_VALUE);
			}

			pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
			bfs(map[0][0], 0, 0);

			ans = weight[N - 1][N - 1];
			System.out.printf("Problem %d: %d\n", tc, ans);
			tc++;

		}

	}

}
