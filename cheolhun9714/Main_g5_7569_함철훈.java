package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_g5_7569_함철훈 {
	static Queue<int[]> queue= new LinkedList<>();
	static int[] dr = {-1,1,0,0,0,0};
	static int[] dc = {0,0,-1,1,0,0};
	static int[] dh = {0,0,0,0,-1,1};
	static int M,N,H;
	static int[][][] map;
	static int days=-1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		int non=0;
		for (int height=0; height<H;height++) {
			for (int r=0; r<N;r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<M;c++) {
					map[height][r][c] = Integer.parseInt(st.nextToken());
					if(map[height][r][c]==0)	non++;
					else if(map[height][r][c]==1) queue.add(new int[] {height,r,c});
				}
			}
		}
		
		if(non == bfs()) {
			System.out.println(days);
		}else	System.out.println(-1);
		
	}
	static int bfs() {
		int count=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int[] temp = queue.poll();
				for(int j=0; j<6;j++) {
					int nh = temp[0]+dh[j];
					int nr = temp[1]+dr[j];
					int nc = temp[2]+dc[j];
					if(nr>=0 && nr<N && nc>=0 && nc<M &&nh>=0 && nh<H && map[nh][nr][nc]==0) {
						map[nh][nr][nc] = 1;
						queue.add(new int[] {nh,nr,nc});
						count++;
					}
				}
			}
			days++;
		}
		return count;
	}
}
