package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_2644_이윤진 {
	static int N;
	static int f1;
	static int f2;
	static int M;
	static int[][] family;
	static int[] visited;
	static int start;
	static int end;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		f1 = Integer.parseInt(st.nextToken());
		f2 = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		family = new int[N+1][N+1];
		visited = new int[N+1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			family[start][end] = 1;
			family[end][start] = 1;
		}

		BFS(f1,f2);
		if (visited[f2] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(visited[f2]);
		}
		
	}
	private static void BFS(int s, int e) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int top = queue.poll();
			if (top==e) {
				break;
			}
			
			for (int i = 1; i <=N; i++) {
				if (family[top][i] == 1 && visited[i] == 0) {
					visited[i] = visited[top] + 1;
					queue.add(i);
				}
			}
		}
	}
}
