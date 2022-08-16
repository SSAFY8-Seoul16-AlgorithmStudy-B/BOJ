package boj.p7k.p7500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class P7569 {
	static int N, M, H;
	static int[][] di = new int[][] {{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};
	
	private static boolean checkIsInvalidRange(int h, int n, int m) {
		return h < 0 || n < 0 || m < 0 || H <= h || N <= n || M <= m;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		
		N = Integer.parseInt(input[1]);
		M = Integer.parseInt(input[0]);
		H = Integer.parseInt(input[2]);
		int[][][] box = new int[H][N][M];
		int notRipe = 0;
		int ripe = 0;
		int days = 0;
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				input = br.readLine().split(" ");
				for (int k = 0; k < M; k++) {
					int cur = Integer.parseInt(input[k]);
					if (cur == 0) notRipe ++;
					if (cur == 1) q.offer(new int[] {i, j, k});
					box[i][j][k] = Integer.parseInt(input[k]);
				}
			}
		}
		
		while (!q.isEmpty()) {
			
			for (int k = 0, end = q.size(); k < end; k++) {
				int[] cur = q.poll();
				
				for (int i = 0; i < 6; i++) {
					int nh = cur[0] + di[i][0], nx = cur[1] + di[i][1], ny = cur[2] + di[i][2];
					if (checkIsInvalidRange(nh, nx, ny)) continue;
					if (box[nh][nx][ny] == 0) {
						box[nh][nx][ny] = 1;	
						ripe ++;
						q.offer(new int[] {nh, nx, ny});
					}
				}	
			}
			days ++;
			
		}
		
		System.out.println(ripe == notRipe ? days - 1 : -1);
		
		

	}

}
