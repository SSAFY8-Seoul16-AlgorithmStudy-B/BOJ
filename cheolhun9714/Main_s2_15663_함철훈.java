package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_s2_15663_함철훈 {
	public static int num,N,M=0;
	static int[] input;
	static int[] answer;
	static boolean[] used;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		answer = new int[M];
		
		used = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		perm(0);
	}
	static void perm(int count) {
		if(count == M) {
			for(int i=0; i<M; i++) {
				System.out.print(answer[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!used[i]) {
				if(i>0) {
					if(input[i]==input[i-1]&& !used[i-1])	continue;
					else {
						answer[count] = input[i];
						used[i] = true;
						perm(count+1);	
						used[i] = false;
					}
				}else {
					answer[count] = input[i];
					used[i] = true;
					perm(count+1);	
					used[i] = false;
				}
			}
		}
	}
}
