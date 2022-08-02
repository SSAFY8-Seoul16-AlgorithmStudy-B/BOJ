import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[k][4];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
		}
		solution(m, n, k, arr);
	}

	static void solution(int m, int n, int k, int[][] arr) {

		int cnt = 0;
		List<Integer> results = new ArrayList<>();
		int[][] map = new int[m][n];
		int[][] visit = new int[m][n];
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};


		for (int[] c : arr) {
			for (int i = c[1]; i < c[3]; i++) {
				for (int j = c[0]; j < c[2]; j++) {
					map[i][j] = 1;
				}
			}
		}


		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == 0 && map[i][j] == 0) {
					cnt++;

					List<Pos> stack = new ArrayList<>();
					int res = 1;
					stack.add(new Pos(i, j));
					visit[i][j] = 1;
					while (!stack.isEmpty()) {
						Pos cur = stack.remove(stack.size() - 1);
						int x = cur.x, y = cur.y;
						for (int dc = 0; dc < 4; dc++) {
							int nx = x + dx[dc], ny = y + dy[dc];
							if (nx < 0 || m <= nx || ny < 0 || n <= ny || visit[nx][ny] == 1 || map[nx][ny] == 1)
								continue;
							visit[nx][ny] = 1;
							res++;
							stack.add(new Pos(nx, ny));
						}
					}

					results.add(res);

				}
			}
		}
		Collections.sort(results);


		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for (int res : results) {
			sb.append(res).append(" ");
		}
		System.out.print(sb.toString().trim());

	}
}