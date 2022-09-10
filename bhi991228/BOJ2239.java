import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ2239 {

	static int N = 9;
	static int[][] board = new int[N][N];
	static ArrayList<Pos> posList = new ArrayList<>();
	static int posNum = 0;
	static boolean getAnswer;
	static StringBuilder sb = new StringBuilder();
	
	static class Pos{
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j)-'0';
				if (board[i][j] == 0) {
					posList.add(new Pos(i, j));
				}
			}
		}
		
		posNum = posList.size();
		selectNum(0);
		System.out.println(sb.toString());
	}

	private static void selectNum(int idx) {
		if (getAnswer) return;
			
		if (idx == posNum) {
			//완성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(board[i][j]+"");
				}
				sb.append("\n");
			}
			getAnswer = true;
			return;
		}
		
		Pos now = posList.get(idx);
		boolean[] isAvailNum = getAvailNum(now);
		
		for (int i = 1; i < 10; i++) {
			if (isAvailNum[i]) {
				board[now.r][now.c] = i;
				selectNum(idx+1);
				board[now.r][now.c] = 0;
			}
		}
	}
	
	private static boolean[] getAvailNum(Pos now) {
		boolean[] isAvailNum = new boolean[10];
		Arrays.fill(isAvailNum, true);
		
		//가로줄 체크
		for (int i = 0; i < 9; i++) {
			if (board[now.r][i] > 0) isAvailNum[board[now.r][i]] = false;
		}
		
		//세로줄 체크
		for (int i = 0; i < 9; i++) {
			if (board[i][now.c] > 0) isAvailNum[board[i][now.c]] = false;
		}
		
		//3*3 상자 체크
		for (int i = (now.r/3)*3, end = i+3; i < end; i++) {
			for (int j = (now.c/3)*3, end2 = j+3; j < end2; j++) {
				if (board[i][j] > 0) isAvailNum[board[i][j]] = false;
			}
		}
		
		return isAvailNum;
	}
}
