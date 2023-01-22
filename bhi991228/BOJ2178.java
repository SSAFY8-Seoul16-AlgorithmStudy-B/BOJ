import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BOJ2178 {
	static int[][] map;
	static int n, m;
	static int[] dirX = {-1, 1, 0, 0};
	static int[] dirY = {0, 0, -1, 1};
	
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.offer(new Pos(0, 0));
		Pos pos;
		int nx = 0, ny = 0;
		
		while (!queue.isEmpty()) {
			pos = queue.poll(); //제거하면서 추출
			
			for (int i = 0; i < 4; i++) {
				nx = pos.x+dirX[i];
				ny = pos.y+dirY[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}
				
				if (map[nx][ny] == 1) {
					//첫 방문
					map[nx][ny] += map[pos.x][pos.y]; //거리 저장
					queue.offer(new Pos(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		map = new int[n][m];
		String temp;
		
		
		for (int i = 0; i < n; i++) {
			temp = scan.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		bfs();
		System.out.println(map[n-1][m-1]);
	}

}
