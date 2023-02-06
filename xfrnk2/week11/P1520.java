import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map, di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }, ansVisit;
	static int ans = 0;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ansVisit = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(ansVisit[0][0]);

	}

	public static int dfs(int x, int y) {

		if (x == N - 1 && y == M - 1) {
			return 1;
		}
		if (visit[x][y]) return ansVisit[x][y];

		visit[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + di[i][0], ny = y + di[i][1];
			if (nx < 0 || ny < 0 || N <= nx || M <= ny)
				continue;
			if (map[x][y] <= map[nx][ny])
				continue;
			ansVisit[x][y] += dfs(nx, ny);		
	

		
 
		
		
			
		}

		return ansVisit[x][y];
	}

}