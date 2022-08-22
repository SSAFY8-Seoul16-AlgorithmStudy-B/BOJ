package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_s2_6603_함철훈 {
	static int[] input;
	static int N;
	static int[] answer = new int[6];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0)	break;
			input = new int[N];
			for(int i=0; i< N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			combi(0,0);
			System.out.println();
		}
	}

	static void combi(int cnt, int start) {
		if(cnt ==6) {
			for(int i=0;i<6; i++) {
				System.out.print(answer[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<N;i++) {
			answer[cnt]=input[i];
			combi(cnt+1,i+1);
		}
		
		
	}
}
