import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M, ans;
	static char[][] map;
	static int sX, sY;
	static boolean[] selected;
	static int[] dirties, numbers;
	static int[][] matrix;
	
	static Point[] dirty;
	static Map<Point, Integer> idxMap;
	static int dirtyIdx;
	
	static class Pos {
		int x, y, bit;

		public Pos(int x, int y, int bit) {
			super();
			this.x = x;
			this.y = y;
			this.bit = bit;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		loop: while (true) {
			st = new StringTokenizer(in.readLine());
			M = Integer.valueOf(st.nextToken());
			N = Integer.valueOf(st.nextToken());
			ans = Integer.MAX_VALUE;
			
			if (M == 0 && N == 0)
				break;

			map = new char[N][M];

			for (int i = 0; i < N; i++) {
				map[i] = in.readLine().toCharArray();
			}

			sX = 0;
			sY = 0;

			dirty = new Point[11];
			idxMap = new HashMap<>();
			dirtyIdx = 1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '*') {
						Point p = new Point(i, j);
						idxMap.put(p, dirtyIdx);
						dirty[dirtyIdx++] = p;
						continue;
					}

					if (map[i][j] == 'o') {
						sX = i;
						sY = j;
						map[i][j] = '.';
					}

				}
			}
			if (!isReachable(sX, sY, N, M, map, dirtyIdx)) { // 도달 불가시 -1 리턴
				System.out.println(-1);
				continue loop;
			}
			
			int end = 1 << dirtyIdx;
			dirty[0] = new Point(sX, sY);
		
			matrix = new int[dirtyIdx][dirtyIdx];
			for (int k = 0; k < dirtyIdx; k++) {
				
				boolean[][] visit = new boolean[N][M];
				Queue<Point> q = new LinkedList<>();
				Point now = dirty[k];
				visit[now.x][now.y] = true;
				q.offer(new Point(now.x, now.y));
				int cnt = 0;
				while (!q.isEmpty()) {
					for (int j = 0, size = q.size(); j < size; j++) {
						
					
					Point cur = q.poll();
		
						
					for (int i = 0; i < 4; i++) {
						int nx = cur.x + di[i][0], ny = cur.y + di[i][1];
						if (isOut(nx, ny, N, M) || visit[nx][ny] || map[nx][ny] == 'x')
							continue;
						
						if (map[nx][ny] == '*') {
							int idx = idxMap.get(new Point(nx, ny));
							matrix[k][idx] = cnt + 1;
						}
						
						
						visit[nx][ny] = true;
						q.offer(new Point(nx, ny));
						}
					}
					cnt ++;
				}
				
			}
			
			numbers = new int[dirtyIdx];
			selected = new boolean[dirtyIdx];
			dirties = new int[dirtyIdx];
			
			permutation(dirtyIdx, 1);
			System.out.println(ans);

		}

	}

	public static boolean isOut(int x, int y, int N, int M) {
		return x < 0 || y < 0 || N <= x || M <= y;
	}

	public static boolean isReachable(int sX, int sY, int N, int M, char[][] map, int total) {
		boolean[][] visit = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		visit[sX][sY] = true;
		q.offer(new Point(sX, sY));
		int cnt = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (map[cur.x][cur.y] == '*')
				cnt++;
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + di[i][0], ny = cur.y + di[i][1];
				if (isOut(nx, ny, N, M) || visit[nx][ny] || map[nx][ny] == 'x')
					continue;
				visit[nx][ny] = true;
				q.offer(new Point(nx, ny));
			}
		}
		

		return cnt + 1 == total;

	}
	
	public static void permutation(int size, int cnt) {
		if (cnt == size) {
			int sum = matrix[0][dirties[1]];
			
			for (int i = 1; i < dirtyIdx - 1; i++) {
				sum += matrix[dirties[i]][dirties[i+1]];
			}
			
			ans = Math.min(ans, sum);
			return;
		}
		for (int i = 1; i < size; i++) {
			if (selected[i]) continue;
			dirties[i] = cnt;
			selected[i] = true;
			permutation(size, cnt + 1);
			selected[i] = false;
		}
	}

}
