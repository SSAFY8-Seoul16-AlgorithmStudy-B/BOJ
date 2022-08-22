package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_S1_1697_이윤진 {
	static int N;
	static int K;
	static int[] maps;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		maps = new int[100001];
		
		if (N==K) {
			System.out.println(0);
		} else {
			bfs(N);
		}
		
		
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		maps[start] = 1;
		
		while(!queue.isEmpty()) {
			int top = queue.poll();
			
			for (int i = 0; i < 3; i++) {
				int temp;
				if (i==0) {
					temp = top*2;
				} else if (i==1) {
					temp = top +1;
				} else {
					temp = top-1;
				}
				
				if(temp == K) {
					System.out.println(maps[top]);
					return;
				}
				
				// 방문한적 없음? 큐에 넣기
				if(temp >= 0 && temp<maps.length && maps[temp] == 0) {
					queue.add(temp);
					maps[temp] = maps[top] + 1; //직전 위치에서 시간 +1 해주기
				}
				
			}
			
			
			
		}
		
	} 
}
