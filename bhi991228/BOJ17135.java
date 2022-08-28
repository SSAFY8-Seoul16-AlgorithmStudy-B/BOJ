import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17135 {

	static int N, M;						//행,열 길이
	static int arrowLimit;					//궁수 공격거리 제한
	static int[] archerPos = new int[3];	//궁수 위치
	static int[][] boardOri;				//게임판 원본
	static int[][] board;					//게임판
	static int[][] delete = new int[3][2];	//죽일 적 위치
	static int enemyCntOri = 0;				//적 숫자
	static int[] dr = {0, -1, 0};
	static int[] dc = {-1, 0, 1};
	static int answer;
	
	static class Pos{
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arrowLimit = Integer.parseInt(st.nextToken());
		boardOri = new int[N][M];
		board = new int[N][];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				boardOri[i][j] = Integer.parseInt(st.nextToken());
				if (boardOri[i][j] == 1) {	//적군 위치 저장
					enemyCntOri++;
				}
			}
		}
		
		setArcher(0, 0);	//궁수 위치 조합 생성
		System.out.println(answer);
	}

	private static void setArcher(int cnt, int start) {
		if (answer == enemyCntOri) return;	//이미 적 전부를 죽인 경우가 나온 경우
		
		if (cnt == 3) {	//궁수 자리 세팅 완료
			answer = Math.max(answer, playGame());
			return;
		}
		
		for (int i = start; i < M; i++) {
			archerPos[cnt] = i;
			setArcher(cnt+1, i+1);
		}
	}
	
	private static int playGame() {
		int kill = 0;					//이 궁수조합으로 돌렸을 때 죽일 수 있는 적 숫자
		int enemyCnt = enemyCntOri;		//전체 적 숫자
		
		//게임판 초기 상태 복사
		for (int i = 0; i < N; i++) {
			board[i] = Arrays.copyOf(boardOri[i], M);
		}
		
		while (enemyCnt > 0) {	//남은 적이 없어질 때까지 반복
			for (int i = 0; i < 3; i++) {
				//죽일 적 위치 초기화
				Arrays.fill(delete[i], -1);
			}
			
			//각 궁수의 위치에서 가까운 적 찾기(bfs)
			for (int i = 0; i < 3; i++) {	//궁수 수만큼 반복
				findKillEnemy(i);
			}
			
			//적 없애기
			for (int[] del : delete) {
				if (del[0] == -1 || del[1] == -1) continue;	//저장된 위치 없으면 무시
				if (board[del[0]][del[1]] == 0)	continue;	//이미 다른 궁수가 죽인 경우 무시
				
				board[del[0]][del[1]] = 0;	//게임판에서 적 삭제 처리
				kill++;
				enemyCnt--;
			}
			
			//적 한 칸 땡기기
			int lastLineEnemy = 0;
			for (int n : board[N-1]) {
				lastLineEnemy += n;	//제일 아래 줄은 없어지니까 그 줄의 적 개수 세두기
			}
			
			for (int i = N-2; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					board[i+1][j] = board[i][j];	//윗줄을 아래줄로 엎어치기
				}
			}
			Arrays.fill(board[0], 0);	//제일 윗 줄은 땡겨지니까 다 0으로 채우기
			enemyCnt -= lastLineEnemy;	//원래 제일 아래 줄에 있던 적 개수 빼주기
		}
		
		return kill;
	}
	
	private static void findKillEnemy(int i) {
		int nr, nc;
		Queue<Pos> queue = new LinkedList<Pos>();
		int firstR = N-1;
		int firstC = archerPos[i];
		int dis = 1;
		
		if (board[firstR][firstC] == 1) {	//궁수 바로 앞이 적일 때
			delete[i][0] = N-1;
			delete[i][1] = archerPos[i];
			return;
		}
		
		queue.add(new Pos(firstR, firstC));	//궁수 바로 앞 위치를 초기값으로 삽입
		
		while (!queue.isEmpty()) {
			if (dis >= arrowLimit) return;	//궁수 공격거리를 넘게되면 중지
			
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				Pos now = queue.poll();
				
				for (int dir = 0; dir < 3; dir++) {
					//dr, dc 순서를 [좌->상->우] 순으로 저장해놨기 때문에 같은 거리에 있는 적이 여러 개일 경우 좌측부터 발견하게 됨
					nr = now.r + dr[dir];
					nc = now.c + dc[dir];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if (board[nr][nc] == 1) { //쏴야 할 적 발견
						delete[i][0] = nr;
						delete[i][1] = nc;
						return;
					}
					queue.add(new Pos(nr, nc));
				}
			}
			dis++;
		}
	}
}
