package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_S2_6603_이윤진 {
	static int N;
	static int[] nums;
	static boolean[] visited;
	static int[] combis; //6개 choice
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			
			if (N==0) {
				break;
			}
			
			nums = new int[N];
			visited = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);

			combinations(0,0);
			System.out.println();
		}
	}

	private static void combinations(int start, int end) {
		if (end==6) {
			for (int i = 0; i < N ; i++) {
				if (visited[i]) {
					System.out.print(nums[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			visited[i] = true;
			combinations(i+1,end+1);
			visited[i] = false;
		}
	}
}
