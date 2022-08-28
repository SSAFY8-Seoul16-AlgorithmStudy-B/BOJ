import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17136 {

	static int[][] board = new int[10][10];			//10*10 종이
	static int[] paperNum = {0, 5, 5, 5, 5, 5};		//사이즈 별 남은 색종이 개수
	static int area = 0;							//덮어야 하는 구역 크기
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) area++;
			}
		}
		
		if (area == 0) System.out.println(0);
		else {
			SearchBoard(0, 0, 0);
			System.out.println(answer < Integer.MAX_VALUE ? answer : -1);
		}
	}
	
	private static void SearchBoard(int i, int j, int cnt) {
		if (cnt > answer) return;

		if (i == 9 && j == 10) {
			answer = Math.min(answer, cnt);
			return;
		}

		if (j == 10) {
			SearchBoard(i + 1, 0, cnt);
			return;
		}

		if (board[i][j] == 1) { // 1이 적힌 칸이면
			for (int size = 5; size >= 1; size--) {
				// 사이즈 1~5 색종이 붙여보기
				if (TryAttach(i, j, size)) { // 해당 색종이 붙이는 데에 성공하면
					if (area == 0) {
						// 만약 1이 전부 덮여졌으면 정답 갱신
						answer = Math.min(answer, cnt + 1);
						Detach(i, j, size);
						return;
					} else {
						// 덮어야 할 곳이 남았으면 붙인 상태로 보드 탐색 재개
						SearchBoard(i, j + 1, cnt + 1);
						Detach(i, j, size);
					}
				}
			}
		} else {
			SearchBoard(i, j + 1, cnt);
		}
	}
	
	private static boolean TryAttach(int r, int c, int size) {
		//해당 위치에 size크기의 색종이 붙이기 (불가능하면 false 리턴)
		//해당 사이즈 종이가 없으면 불가능
		if (paperNum[size] <= 0) return false;
		
		//가능 여부 체크
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				//경계와 일치하게 붙일 수 없거나, 0인 곳을 덮게 되면 불가능
				if (i >= 10 || j >= 10) return false;
				if (board[i][j] == 0) return false;
			}
		}
		
		//색종이 붙이기
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				board[i][j] = 0;
			}
		}
		area -= size*size;
		paperNum[size]--;
		
		return true;
	}
	
	private static void Detach(int r, int c, int size) {
		//붙인 색종이 떼기
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				board[i][j] = 1;
			}
		}
		
		area += size*size;
		paperNum[size]++;
	}
}
