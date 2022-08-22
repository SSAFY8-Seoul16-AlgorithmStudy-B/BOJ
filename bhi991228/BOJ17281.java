import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17281 {

	static int N;
	static int[][] inningResult;
	static int[] order = new int[9];
	static int answer;
	static int t;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		inningResult = new int[N][9];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				inningResult[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeOrder(0, 0);	//선수 순서 결정
		System.out.println(answer);
	}

	private static void makeOrder(int cnt, int flag) {
		if (cnt == 9) {
			answer = Math.max(answer, playGame());
			return;
		}
		
		for (int i = 1; i < 9; i++) {
			if ((flag & 1 << i) != 0) continue;
			
			if (cnt == 3) cnt++; 
			order[cnt] = i;
			makeOrder(cnt+1, flag | 1 << i);
		}
	}

	private static int playGame() {
		int score = 0;		//최종 득점
		int outTime = 0;	//아웃 횟수
		int nowInning = 0;	//현재 이닝
		int nowOrder = 0;	//현재 타순
		int nowHitter = 0;	//현재 타자
		int nowResult = 0;	//현재 타자가 낼 결과
		boolean[] nowGround = new boolean[4];	//현재 그라운드 상태 (타석, 1루, 2루, 3루)
		
		while(true) {
			nowHitter = order[nowOrder];
			nowResult = inningResult[nowInning][nowHitter];
			nowGround[0] = true; //타석에 사람 채움
			
			if (nowResult == 0) outTime++;	//아웃이면 아웃 횟수 증가
			else {
				for (int i = 0; i < nowResult; i++) {
					//그라운드의 선수 한 칸씩 땡기기
					if(nowGround[3]) score++;
					nowGround[3] = nowGround[2];
					nowGround[2] = nowGround[1];
					nowGround[1] = nowGround[0];
					nowGround[0] = false;
				}
			}
			
			nowOrder = (nowOrder + 1) % 9;	//타순 변경
			
			if(outTime >= 3) {	//아웃 3번일 때
				if(nowInning == N-1) break;	//다음 이닝 없으면 종료
				nowInning++;	//다음 이닝
				Arrays.fill(nowGround, false);
				outTime = 0;
			}
		}
		
		return score;
	}

}
