import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2583 {
	static int[][] board;
	static int m, n;
	static int[] dirX = {-1, 1, 0, 0};
	static int[] dirY = {0, 0, -1, 1};

	public static int dfs(int x, int y, int area) {
		int nx = 0, ny = 0;
		
		for (int i = 0; i < 4; i++) {
			nx = x + dirX[i];
			ny = y + dirY[i];
			
			if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
				continue;
			}
			
			if (board[nx][ny] == 0) {
				board[nx][ny] = 1;
				area = dfs(nx, ny, area+1);
			}
		}
		return area;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		int k = scan.nextInt();
		ArrayList<Integer> answers = new ArrayList<Integer>();
		board = new int[m][n];
		
		for (int i = 0; i < k; i++) {
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					board[y][x] = 1;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					board[i][j] = 1;
					answers.add(dfs(i, j, 1));
				}
			}
		}
		
		Collections.sort(answers);
		
		System.out.println(answers.size());
		for (int i = 0; i < answers.size(); i++) {
			System.out.printf("%d ", answers.get(i));
		}
	}

}
