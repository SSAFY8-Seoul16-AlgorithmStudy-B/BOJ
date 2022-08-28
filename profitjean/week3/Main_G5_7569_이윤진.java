package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_7569_이윤진 {
	static int M;
	static int N;
	static int H;
	static int[][][] tomato;
	static int[][][] isVisited;
	static int[] dz = {0,0,0,0,1,-1};
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][N][M];
		isVisited = new int[H][N][M];
		

		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					tomato[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		bfs();
		
		
		

		
		for (int k = 0; k<H;k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (isVisited[k][i][j] == 0 && tomato[k][i][j] == 0) {
						max = -1;
					}
				}
			}
		}
		
		if (max == 0 ) {
			System.out.println(max);
		} else if (max==-1) {
			System.out.println(max);
		} else {
			System.out.println(max-1);
		}
		
	}
	private static void bfs() {
		Queue<farm> queue = new LinkedList<>();

		for (int k = 0; k< H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tomato[k][i][j] == 1) {
						queue.add(new farm(i,j,k));
						isVisited[k][i][j] = 1;
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			farm f = queue.poll();
			
			int r = f.r;
			int c = f.c;
			int floor = f.floor;
			
			for (int i = 0; i < 6; i++) {
				int cx = r + dx[i];
				int cy = c + dy[i];
				int cz = floor + dz[i];
				
				if (cx>=N || cx<0 || cy >=M || cy <0 || cz>=H || cz<0 || isVisited[cz][cx][cy] != 0 || tomato[cz][cx][cy] == -1) {
					continue;
				}
				if (tomato[cz][cx][cy] == 0) {
					isVisited[cz][cx][cy] = isVisited[floor][r][c] + 1;
					max = Math.max(isVisited[cz][cx][cy], max);
					queue.add(new farm(cx,cy,cz));
				}
			}
			
		}
	}
}


class farm {
	
	int r;
	int c;
	int floor;
	
	farm(int r, int c, int floor) {
		this.r = r;
		this.c = c;
		this.floor = floor;
	}
	
	
}
