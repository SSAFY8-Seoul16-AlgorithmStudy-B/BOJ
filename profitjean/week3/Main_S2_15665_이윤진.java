package com.ssafy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_S2_15665_이윤진 {

	// 중복순열을 구하는 문제
		static int N;
		static int M;
		static int[] nums; // n개
		static int[] perms; // m개 선택한거 들어갈 배열
		static boolean[] isSelected;
		static StringBuilder sb = new StringBuilder();

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			nums = new int[N];
			isSelected = new boolean[N];
			perms = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			perm(0);
			System.out.println(sb);
		}

		private static void perm(int number) {
			if (number == M) {
				// System.out.println(Arrays.toString(perms));
				for (int i = 0; i < perms.length; i++) {
					sb.append(perms[i]).append(" ");
				}
				sb.append("\n");
				return;
			}
			int temp = 0;
			for (int i = 0; i < isSelected.length; i++) {
	            // 15663 코드에서 중복방지하는 코드만 빼주기
				// 이전의 값과 같다면  순열 계산안하도록
				if (temp != nums[i]) {
					isSelected[i] = true;
					perms[number] = nums[i];
					temp = nums[i];
					perm(number + 1);
					isSelected[i] = false;	
				}
			}

		}
}
