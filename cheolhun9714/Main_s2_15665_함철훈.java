package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_s2_15665_함철훈 {
	static int[] input;
	static int N,M;
	static int[] answer;
	static StringBuilder str = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		answer = new int[M];
		perm(0);
		System.out.println(str);
		
	}

	static void perm(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
			str.append(answer[i]).append(" ");
			}
			str.append("\n");
			return;
		}
		
		for(int i=0; i<N;i++) {
			if(i>0 && input[i]==input[i-1])	continue;
			answer[cnt] = input[i];
			perm(cnt+1);
		}
		
	}
}
