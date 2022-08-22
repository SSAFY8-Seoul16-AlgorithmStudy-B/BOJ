package com.ssafy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main_G4_16637_이윤진 {
	static int N;
	static int max = Integer.MIN_VALUE;
	static ArrayList<Integer> nums = new ArrayList<>();
	static ArrayList<Character> cals = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String st = br.readLine();
		for (int i = 0; i < N; i++) {
			if (i%2==0) {
				nums.add(st.charAt(i)-'0');
			} else {
				cals.add(st.charAt(i));
			}
		}
		
		
		dfs(0,nums.get(0));
		System.out.println(max);
	}

	private static void dfs(int cur, int sum) {
		if (cur >= cals.size()) {
			max = Math.max(max, sum);
			return;
		}
		
		// 괄호없음
		int val = calculate(cur, sum, nums.get(cur+1));
		dfs(cur+1, val);
		
		// 괄호치기
		if (cur+1 < cals.size()) {
			int temp = calculate(cur+1, nums.get(cur+1), nums.get(cur+2));
			int div = calculate(cur, sum,temp);
			dfs(cur+2, div);
		}
		
	}

	private static int calculate(int idx, int sum, int num) {
		switch (cals.get(idx)) {
		case '+':
			return sum + num;
		case '-':
			return sum-num;
		case '*':
			return sum*num;
		}
		return 1;
	}

}
