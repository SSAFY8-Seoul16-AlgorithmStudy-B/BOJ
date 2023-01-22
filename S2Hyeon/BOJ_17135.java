import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// BOJ_17135 캐슬 디펜스
public class BOJ_17135 {

	static int N, M, D;
	static boolean[][] map;
	static int[] archers;
	static int[] dx = {0, -1, 0};	// 좌, 상, 우
	static int[] dy = {-1, 0, 1};
	static int maxDeath;
	
	public static class Position {	// 행, 열을 저장할 클래스
		int row, col;
		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public int hashCode() {	// 정수형인 행, 열 정보를 문자열로 바꾸어 해시코드를 반환한다.
			return (this.row + "" +this.col).hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {	// set에서 객체간 비교를 위해 해시코드를 비교한다.
			if(obj instanceof Position) {
				Position pos = (Position)obj;
				return this.hashCode() == pos.hashCode();
			}
			return false;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		archers = new int[3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			}
		}
		
		comb(0, 0);
		System.out.println(maxDeath);
	}

	private static void comb(int cnt, int start) {
		if(cnt == 3) {
			simulate();
			return;
		}
		
		for(int i = start; i < M; i++) {
			archers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static void simulate() {
		
		// 입력받은 맵을 직접 쓰면 이전에 처리해 준 값이 그대로 반영되므로 매 시뮬레이션마다 딥카피를 해서 써야한다.
		boolean[][] copyMap = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		int result = 0;
		
		// 적의 위치를 담을 Set => 여러 궁수가 같은 적을 쏴도 Set의 특성으로 중복된 값이 들어가지 않는다. 
		Set<Position> set = new HashSet<>();	 
		for(int cur = N - 1; cur >= 0; cur--) {	// 행의 끝(N)에 성이 있기때문에 그 앞부터 처리한다.
			for(int a = 0; a < archers.length; a++) {	// 조합으로 완성된 궁수조합에서 궁수 한명씩 적을 탐지한다.
				int size = set.size();	// 현재 set의 크기를 저장
				for(int i = 1; i <= D; i++) {	// 궁수의 사거리별로 bfs를 진행한다. => 가까운적 부터 죽이게 돼있으므로 가까운 적을 먼저 탐색하는 것
					bfs(copyMap, cur, archers[a], i, set);
					
					// 이전에 저장했던 set의 크기와 bfs를 진행한 뒤 set의 크기가 다르다면 set에 죽일 수 있는 적이 추가됐다는 의미이다.
					if(size != set.size())	
						break;	// 한 턴에 한명씩 죽일 수 있으므로 탐지된 적이 있다면 break를 하여 다음 궁수로 넘어간다.
				}
			}
			
			// 죽인 적의 자리에 표시를 해주기 위해 set을 list에 담는다.
			ArrayList<Position> list = new ArrayList<>(set);
			result += set.size();	// set의 크기는 죽일 수 있는 적의 수를 의미하므로 결과값에 더해준다.
			set.clear();	// 다음 탐색을 위해 셋을 초기화
			for(Position pos : list) {	// 죽인 적의 자리에 false로 표시한다.
				copyMap[pos.row][pos.col] = false;
			}
		}
		maxDeath = Math.max(maxDeath, result);	// 한 개의 궁수 조합으로 시뮬레이션을 완료 하였으므로 최대값비교 후 갱신한다.
	}

	/**
	 * 
	 * @param copyMap	map을 복사한 이차원 배열 
	 * @param turn		현재 처리중인 행. N-1이 1턴이다.
	 * @param a			현재 처리중인 조합에서 배정된 궁수의 위치(열)
	 * @param maxDist	현재 사거리
	 * @param set		죽인 적의 위치정보를 저장할 set
	 */
	private static void bfs(boolean[][] copyMap, int turn, int a, int maxDist, Set<Position> set) {
		Queue<Position> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];	// 방문 표시배열
		queue.offer(new Position(turn, a));		// 현재 좌표를 큐에 넣는다.
		visited[turn][a] = true;	// 방문 표시
		if(copyMap[turn][a]) {	// 만약 처음 좌표에 적이 있다면	
			set.add(new Position(turn, a));	// set에 추가하고 바로 리턴한다.
			return;
		}
		int dist = 1;	// 현재 사거리
		while(!queue.isEmpty()) {
			int size = queue.size();	
			while(--size >= 0) {	// 큐에서 같은 레벨을 한번에 처리
				Position curPos = queue.poll();
				int row = curPos.row;
				int col = curPos.col;
				for(int dir = 0; dir < dx.length; dir++) {
					int nextRow = row + dx[dir];
					int nextCol = col + dy[dir];
					if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
						if(!visited[nextRow][nextCol] && dist < maxDist) {	// 다음 위치에 방문을 하지 않았고, 현재 거리가 궁수의 사정거리 안쪽일 때
							// 방문을 안했어도 사거리 밖이면 큐에 넣지도 않는다.
							Position nextPos = new Position(nextRow, nextCol);
							if(copyMap[nextRow][nextCol]) {	// 다음 위치에 적이 있다면
								set.add(nextPos);	// 셋에 추가 후 리턴
								return;
							}
							queue.offer(nextPos);	// 다음위치가 적이 아니라면 큐에 넣는다.
							visited[nextRow][nextCol] = true;	// 방문 표시
						}
					}
				}
			}
			dist++; // 사거리 추가
		}
		
	}

}
