package com.ssafy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17070_이윤진 {
	static int N;
	static int[] dx = {0,1,1}; // 우 대각선 하
	static int[] dy = {1,1,0};
	static int[][] house;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		house = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 가로로 놓여있을때는 우, 대각선
		// 세로로 놓여있을때는 하, 대각선
		// 대각선으로 놓여있을때는 우 대각선 하 모두 가넝
		// 놓여있는 모양별로 탐색을 돌려서 N-1,N-1에 도착가능하면 경우의 수를 더하면 되려나
		
		
		dfs(0,1,1);
		System.out.println(ans);
		
	}

	private static void dfs(int r, int c, int pos) {
		if (r==N-1 && c==N-1) {
			ans += 1;
			return;
		}
		
		if(pos==1) {
			for (int i = 0; i < 2; i++) {
				int nx = r + dx[i];
				int ny = c + dy[i];
				if (nx<0 || nx>=N || ny<0 || ny>=N || house[nx][ny] == 1) {
					continue;
				}
				if (i==0) { // 우
					dfs(nx,ny,1);
				} else { // 대각선
					if (house[nx-1][ny] == 0 && house[nx][ny-1] == 0) {
						dfs(nx,ny,3);
					}
				}
			}
		} else if (pos==2) {
			for (int i = 0; i<2;i++) {
				int nx = r + dx[i+1];
				int ny = c + dy[i+1];
				if (nx<0 || nx>=N || ny<0 || ny>=N || house[nx][ny] == 1) {
					continue;
				}
				if (i==0) { // 대각선
					if (house[nx-1][ny] == 0 && house[nx][ny-1] == 0) {
						dfs(nx,ny,3);	
					}
				} else { // 하
					dfs(nx,ny,2);
				}
			}
		} else {
			for (int i = 0; i<3;i++) {
				int nx = r + dx[i];
				int ny = c + dy[i];
				if (nx<0 || nx>=N || ny<0 || ny>=N || house[nx][ny] == 1) {
					continue;
				}
				if (i==0) { // 상
					dfs(nx,ny,1);
				} else if (i==1){ // 대각선
					if (house[nx-1][ny] == 0 && house[nx][ny-1] == 0) {
						dfs(nx,ny,3);
					}
				} else {
					dfs(nx,ny,2); // 하
				}
			}
			
		}
	}
}
