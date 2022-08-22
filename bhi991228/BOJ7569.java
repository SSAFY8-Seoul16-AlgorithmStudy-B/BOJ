import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int h, r, c;
	Pos(int h, int r, int c){
		this.h = h;
		this.r = r;
		this.c = c;
	}
}

public class BOJ7569 {

	static int M, N, H;
	static int[][][] boxes;
	static int answer = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		boxes = new int[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					boxes[h][n][m] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		bfs();
		
		//bfs 후 안 익은 토마토가 있는 경우엔 -1 출력
		for (int[][] box : boxes) {
			for (int[] line : box) {
				for (int tomato : line) {
					if (tomato == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static void bfs(){
		//상,하,좌,우,앞,뒤
		int[] dh = {0, 0, 0, 0, 1, -1};
		int[] dr = {-1, 1, 0, 0, 0, 0};
		int[] dc = {0, 0, -1, 1, 0, 0};
		
		Queue<Pos> queue = new LinkedList<Pos>();
		Pos tomato;
		int size, nh, nr, nc;
		
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (boxes[h][n][m] == 1) {	//익은 토마토는 queue에 추가
						queue.offer(new Pos(h, n, m));
					}
				}
			}
		}
		
		while (!queue.isEmpty()) {
			answer++;
			size = queue.size();
			
			for (; size > 0; size--) {
				tomato = queue.poll();
				for (int i = 0; i < 6; i++) {
					nh = tomato.h + dh[i];
					nr = tomato.r + dr[i];
					nc = tomato.c + dc[i];
					
					//배열 벗어난 위치
					if (nh < 0 || nh >= H 
					 || nr < 0 || nr >= N 
					 || nc < 0 || nc >= M) continue;
					
					//인접 위치에 안 익은 토마토가 있을 때
					if (boxes[nh][nr][nc] == 0) {
						queue.offer(new Pos(nh, nr, nc));
						boxes[nh][nr][nc] = 1;
					}
				}
			}
		}
	}
}
