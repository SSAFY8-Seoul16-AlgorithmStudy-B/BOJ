package com.ssafy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G2_17136_이윤진 {
	static int[][] maps;
	static int min = Integer.MAX_VALUE;
	
	static int[] papers = {0,5,5,5,5,5}; // 색종이 개수 저장. 사이즈별 각각 5장씩이랬지
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maps = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 10; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken()); // 정보 받아ㅗ기
			}
		}
		dfs(0,0,0); // 탐색 시작 위치 r, c, 색종이 사용수
		if (min==Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		//System.out.println(min);
		
		
		
	}
	private static void dfs(int r, int c, int cnt) {
		// 탐색 마지막에 도달했다면, 종료하기
		if (r>=9 && c>9) {
			min = Math.min(min,cnt);
			return;
		}
		if (min<= cnt) {
			return;
		}
		// 마지막 열에 도달했다면, 다음 행(r+1)으로 넘어가서 탐색진행하기
		if(c>9) {
			dfs(r+1,0,cnt);
			return;
		}
		// 1인부분만을 색종이는 가릴수있지
		if(maps[r][c] == 1) {
			// 색종이 사이즈 큰거부터 접근하기
			for (int i = 5; i >= 1; i--) {
				if(papers[i]>0 && canCover(r,c,i)) {
					
					papers[i] -= 1; // 색종이 사용 완
					covering(r,c,i,true); // 덮은 부분은 색종이가 가려져있다고 처리해야하니까
					
					dfs(r,c+1,cnt+1); // 옆칸으로 넘어가서 탐색 진행, 전체 색종이 사용 수  1증가
					
					papers[i] += 1; // 색종이를 사용하지 않은 경우
					covering(r,c,i,false); // 다시 되돌려놓기
				}
			}
		} else { // 0이라서 색종이가 못 가린다? 옆칸으로 넘어가서 탐색하기
			dfs(r,c+1,cnt);
		}

		
		
	}
	private static void covering(int r, int c, int size, boolean covered) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(covered) { // 가려진 부분은 원래의 1값에서 0으로 변경해서 다른 탐색 진행시 접근 못하도록
					maps[i][j] = 0;
				} else {
					maps[i][j] = 1;
				}
			}
		}
		
	}
	

	private static boolean canCover(int r, int c, int size) {
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(i<0 || i>=10 || j<0 || j>=10) {
					return false;
				}
				
				if(maps[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}

}
