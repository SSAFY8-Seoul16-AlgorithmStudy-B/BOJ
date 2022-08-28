package com.ssafy.week4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_17281_이윤진 {
		// 안타 2루타 3루타 홈런
		// 아웃
		
		// 1 2 3 4 5 6 7 8 9
		// [0,0,0,1,0,0,0,0,0] 1번선수는 4번째타자
		// 이러니까..8위하지..
		// 가장 많은 득점을 할 수 있는 타순을 찾고 그때의 득점(출력)?
		
		// 안타 1
		// 2루타 2
		// 3루타 3
		// 홈런 4
		// 아웃 0
		
		// 0 3개 더해지면 다음 이닝, 다음 타순으로 넘어가야함
		
		static int[][] players;
		static int innings;
		static int[] lineups;
		static boolean[] visited;
		static int ans = Integer.MIN_VALUE;
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			//System.setIn(new FileInputStream(""));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			innings = Integer.parseInt(br.readLine());
			lineups = new int[10];
			visited = new boolean[10];
			
			players = new int[innings+1][10]; // 0~9니까 1부터 9까지만 
			for (int i = 1; i <= innings; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= 9; j++) {
					players[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			lineups[4] = 1; // 1번선수는 무조건 4번째타석
			permutations(1);
			System.out.println(ans);
			

		}

		private static void permutations(int cnt) {
			
			if (cnt>9) {
				bf();
				return;
			}
			if (cnt==4) {
				permutations(cnt+1);
				return;
			}
			for (int i = 2; i <= 9; i++) {
				if(visited[i] == true) {
					continue;
				}
				visited[i]= true;
				lineups[cnt] = i;
				permutations(cnt+1);
				visited[i] = false;
			}
			
		}

		private static void bf() {
			// 라인업에는 선수 이름이 놓여있지
			int score = 0;
			
			int outcount = 0;
			int inn = 1;
			int cur = 1;
			int [] base = new int[3];
			
			while(inn <= innings) {
				
				if (outcount == 3) {
					inn += 1;
					outcount = 0;
					Arrays.fill(base, 0);
					continue;
				}
				
				int player = lineups[cur]; // 선수 누구인지 
				int result = players[inn][player]; // 이닝별 선수 예측값
				
				if(result == 1) { // 안타 한칸씩 이동 3루주자 홈으로 컴백
					score += base[2];
					base[2] = base[1];
					base[1] = base[0];
					base[0] = 1;
				} else if (result==2) { // 2루타
					score += base[2] + base[1];
					base[2] = base[0]; // 1루주자 무조건 3루
					base[1] = 1; // 타석은 2루로
					base[0] = 0;
				} else if (result==3) { //3루타
					score += base[2] + base[1] + base[0]; // 만루면 다 홈으로 들어옴
					base[2] = 1; // 주자는 3루로
					base[1] = 0;
					base[0] = 0;
				} else if (result==4) { // 홈런
					score += base[2] + base[1] + base[0] + 1; // 다 홈 들어오고 점수추가
					Arrays.fill(base, 0);
				} else {
					outcount += 1;
				}
				
				ans = Math.max(ans, score);
				if(cur == 9) {
					cur =1 ;
				} else {
					cur += 1;
				}
			}
		}
		
		
}
