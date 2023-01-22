import java.util.Arrays;
import java.util.Scanner;

public class BOJ2468 {
	static int map[][];
	static int n;
	static int min = 101, max = 0;
	static int[] dirX = {-1, 1, 0, 0};
	static int[] dirY = {0, 0, -1, 1};
	static int[][] visited;
	
	public static void dfs(int x, int y, int rain) {
		int nx = 0, ny = 0;
		
		for (int i = 0; i < 4; i++) {
			nx = x + dirX[i];
			ny = y + dirY[i];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
				continue;
			}
			
			if ((map[nx][ny] - rain > 0) && (visited[nx][ny] == 0)) {
				visited[nx][ny] = 1;
				dfs(nx, ny, rain);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int height = 0;
		int answer = 0;
		
		map = new int[n][n];
		visited = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				height = scan.nextInt();
				map[i][j] = height;
				min = Math.min(min, height);
				max = Math.max(max, height);
			}
		}
		
		for (int rain = min-1; rain < max; rain++) {
			int answerTemp = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if ((map[i][j] - rain > 0) && (visited[i][j] == 0)) {
						//잠기지 않았고 방문하지 않은 영역
						visited[i][j] = 1;
						dfs(i, j, rain);
						answerTemp += 1;
					}
				}
			}
			
			answer = Math.max(answer, answerTemp);
			for (int i = 0; i < n; i++) {
				Arrays.fill(visited[i], 0);
			}
		}
		
		System.out.println(answer);
	}

}
