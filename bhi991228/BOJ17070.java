import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 {
	
	static int N;
	static int[][] house;
	static int answer;
	static int[][] dr = { {0, 1}, {1, 1}, {0, 1, 1} };
	static int[][] dc = { {1, 1}, {0, 1}, {1, 0, 1} };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		house = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		/*
		 * bfs로 풀었을 때 시간초과 난 이유 ... 
		 * 원래 bfs는 한 번 갔던 곳은 안 가도록 해야 시간단축의 의미가 있는 건데
		 * 이 문제는 목표까지 오는 전체 방법의 개수를 세야 해서 각 위치에 중복 체크를 할 수 없는 문제였기 때문임
		 * 마치 bfs처럼 푼 것일 뿐 정말 bfs는 아니다 !
		 * => 교수님 답변 : 이 문제는 전형적인 dfs 문제 (가능한 가짓수를 전부 카운트)
		 *              이걸 큐를 써서 풀었든 재귀로 풀었든 가보는 루트?의 개수는 결국 동일했을 것임
		 *              하지만 큐로 했을 때 시간초과가 났던 이유는 1.큐에 넣으려고 객체 생성할 때 약간 시간 소요 / 2.계속 힙 메모리에 접근해야 함
		 *              재귀로 하면 바로 콜스택에만 접근하면 돼서 조금 단축되었을 것이다 !
		 */
		dfs(0, 1, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int r, int c, int dir) {
		int nr, nc, newDir;
		
		for (int i = 0, end = dr[dir].length; i < end; i++) {
			nr = r + dr[dir][i];
			nc = c + dc[dir][i];
			
			if (nr >= N || nc >= N || house[nr][nc] == 1) continue;	//파이프 새 위치의 끝이 배열을 벗어날 땐 무시
			if ((i == end-1) && (house[nr-1][nc] == 1 || house[nr][nc-1] == 1)) continue;	//파이프 새 방향이 대각선일 때 빈 칸이어야 하는 곳 추가 체크
			
			if (nr == N-1 && nc == N-1) {
				answer++;
				break;	//새 위치가 목표점에 도달할 수 있다면 현재 위치에서 다른 방향으로 가봐도 불가능한 경우 뿐임
			} else {
				if (dir == 2) newDir = i;	//현재 방향이 대각선이었다면 i를 그대로 새 방향으로 사용 가능
				else {
					if (i == 0) newDir = dir;	//현재 방향이 가로 or 세로인 상황에서 i가 0인 경우는 현재 방향과 동일하게 민 경우임
					else newDir = 2;				//i가 1이면 대각선으로 민 경우
				}
				dfs(nr, nc, newDir);
			}
		}
	}
}
