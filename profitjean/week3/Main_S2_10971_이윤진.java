package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_10971_이윤진 {
	static int N;
	static int[][] map;
	static boolean[] isVisited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			isVisited[i] = true;
			dfs(i,i,0,0);
		}
		System.out.println(min);

	}
	private static void dfs(int s, int n, int depth, int sum) {
		if (depth == N-1) {
			if (map[n][s] != 0) {
				sum += map[n][s];
				min = Math.min(sum, min);
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isVisited[i]==false && map[n][i] > 0) {
				isVisited[i] = true;
				dfs(s,i,depth+1,sum+map[n][i]);
				isVisited[i] = false;
			}
		}
		
	}
	
}
