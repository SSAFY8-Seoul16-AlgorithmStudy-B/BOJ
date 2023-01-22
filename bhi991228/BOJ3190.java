import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ3190 {

	static class Pos{
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Change{
		int cSec;
		char cDir;
		public Change(int cSec, char cDir) {
			this.cSec = cSec;
			this.cDir = cDir;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int board[][] = new int[N][N];
		Deque<Pos> snake = new ArrayDeque<>();
		ArrayList<Change> changeList = new ArrayList<>();
		
		int[] dr = {0, 1, 0, -1};	//우하좌상
		int[] dc = {1, 0, -1, 0};
		int dir = 0;
		int sec = 0;
		int changeIdx = 0;
		Change change = null;
		
		
		//사과 위치 반영
		int apple = Integer.parseInt(br.readLine());
		for (int i = 0; i < apple; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			board[r][c] = 2;
		}
		
		//방향 전환 저장
		int changeNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < changeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			char cDir = st.nextToken().charAt(0);
			changeList.add(new Change(s, cDir));
		}
		
		change = changeList.get(0);
		snake.add(new Pos(0, 0));
		
		while (true) {
			sec++;
			
			//다음 위치 계산
			int nr = snake.peekLast().r + dr[dir];
			int nc = snake.peekLast().c + dc[dir];
			
			//벽에 부딪히거나 자기 자신과 부딪히면 종료
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 1) {
				break;
			}
			
			//사과를 먹은 경우가 아니면 뱀 사이즈 줄이기
			if (board[nr][nc] != 2) {
				Pos endPos = snake.pollFirst();
				board[endPos.r][endPos.c] = 0;
			}
			snake.add(new Pos(nr, nc));
			board[nr][nc] = 1;
			
			//방향 전환해야 할 경우
			if (change.cSec == sec) {
				if (change.cDir == 'D') dir = (dir+1) % 4;
				else dir = (4+(dir-1)) % 4;

				changeIdx++;
				if (changeIdx < changeNum) {
					change = changeList.get(changeIdx);
				}
			}
		}
		
		System.out.println(sec);
	}

}
