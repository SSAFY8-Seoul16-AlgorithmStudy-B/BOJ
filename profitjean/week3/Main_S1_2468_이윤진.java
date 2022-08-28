package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2468_이윤진 {
	static int[][] map;
	static int N;
	static boolean[][] isVisited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int max_height = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > max_height) {
					max_height = map[i][j]; // 최대높이 구하기
				}
			}
		}
		
		// 높이보다 큰 부분은 안전영역이 된다.
		// 우리가 구해야하는건 최대 안전영역의 개수
		int area = 0;
		// 최대높이 기준으로 for문 돌려서 최대 안전영역의 개수를 갱신해나가기
		for (int h = 0; h <= max_height; h++) {
			isVisited = new boolean[N][N];
			int temp= 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 아직 방문안하고 높이보다 큰 부분이라면?
                    // dfs 탐색시작
					if (!isVisited[i][j] && map[i][j] > h) {
						temp += dfs(i,j,h);
					}
				}
			}
			area = Math.max(area, temp); // 높이별 영역개수 구하기
		}
		System.out.println(area);
		
	}
	private static int dfs(int i, int j, int h) {
		isVisited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			if (nx<0 || nx>=N || ny<0 || ny>=N || isVisited[nx][ny]) {
				continue;
			}
			// 4방향 돌리면서 기준높이부분보다 높은 부분이라면 새로 탐색진행
            
			if (map[nx][ny] > h) {
				dfs(nx,ny,h);
			}
		}
		return 1; 
	}
}
