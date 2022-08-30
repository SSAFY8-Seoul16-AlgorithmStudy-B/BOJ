import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17472 {

	static int N, M;
	static int[][] map;
	static int[][] adjList;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int islandCnt;
	static Queue<Pos> queue = new ArrayDeque<>();
	
	static class Pos{
		int r, c;
		int start;
		int dir;
		public Pos(int r, int c, int start, int dir) {
			this.r = r;
			this.c = c;
			this.start = start;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//섬 찾아서 번호 부여 후 인접행렬 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					map[i][j] = 1000+islandCnt;
					saveIslandNum(i, j);
					islandCnt++;
				}
			}
		}
	
		adjList = new int[islandCnt][islandCnt];
		for (int i = 0; i < islandCnt; i++) {
			Arrays.fill(adjList[i], Integer.MAX_VALUE);
		}
		
		//섬의 땅 부분을 전부 큐에 삽입
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] >= 1000) {
					for (int dir = 0; dir < 4; dir++) {
						//4방으로 가봐야 하니 큐에 4개씩 넣어주기
						queue.offer(new Pos(i, j, map[i][j], dir));
					}
				}
			}
		}
		
		//정해진 방향대로 가면서 섬 만나면 시작된 섬-> 도착한 섬 최소거리 비교 후 갱신
		findIsland();

		
		//프림 알고리즘으로 모든 섬을 연결하는 최소 다리거리 계산
		ArrayList<Integer> selected = new ArrayList<>(islandCnt);
		boolean[] visited = new boolean[islandCnt];
		int min, index;
		int answer = 0;
		
		selected.add(0);
		visited[0] = true;
		
		for (int i = 0; i < islandCnt-1; i++) {
			min = Integer.MAX_VALUE;
			index = -1;
			
			for (Integer v : selected) {
				for (int j = 0; j < islandCnt; j++) {
					if (!visited[j] && adjList[v][j] != Integer.MAX_VALUE && min > adjList[v][j]) {
						min = adjList[v][j];
						index = j;
					}
				}
			}
			
			if (index == -1) {
				answer = 0;
				break;	//섬을 모두 잇는 것이 불가능
			}
				
			selected.add(index);
			visited[index] = true;
			answer += min;
		}
		
		//정답 출력
		System.out.println((answer == 0) ? -1 : answer);
	}

	private static void saveIslandNum(int r, int c) {
		int nr, nc;
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if (map[nr][nc] == 1) {
				map[nr][nc] = 1000+islandCnt;
				saveIslandNum(nr, nc);
			}
		}
	}
	
	private static void findIsland() {
		int dist = 0;
		int nr, nc;
		
		while (!queue.isEmpty()) {
			for (int i = 0, end = queue.size(); i < end; i++) {
				Pos now = queue.poll();
				nr = now.r + dr[now.dir];
				nc = now.c + dc[now.dir];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] == now.start) continue;	//시작한 섬과 같은 섬에 닿으면 continue (시작위치가 섬의 경계가 아니었던 경우)
				
				if (map[nr][nc] == 0) {
					queue.offer(new Pos(nr, nc, now.start, now.dir));	//같은 방향으로만 쭉 탐색해야 함
				} else {
					//다른 섬에 닿은 경우
					if (dist < 2) continue;	//다리 길이 2 이상이어야 함
					
					int startIdx = now.start-1000;
					int endIdx = map[nr][nc]-1000;
					adjList[startIdx][endIdx] = Math.min(adjList[startIdx][endIdx], dist);
				}
			}
			
			dist++;
		}
	}
}
