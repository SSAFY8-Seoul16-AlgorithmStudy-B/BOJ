package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_9465_함철훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}				
			}
			int answer[][] = new int[3][n];
			answer[0][0] = 0;
			answer[1][0] = sticker[0][0];
			answer[2][0] = sticker[1][0];
			for(int i=1; i<n;i++) {
				answer[0][i] = Math.max(answer[1][i-1], answer[2][i-1]);
				answer[1][i] = Math.max(answer[2][i-1], answer[0][i-1])+sticker[0][i];
				answer[2][i] = Math.max(answer[0][i-1], answer[1][i-1])+sticker[1][i];
				
			}
			System.out.println(Math.max(Math.max(answer[0][n-1], answer[1][n-1]), answer[2][n-1]));
			
			
			
			
		}
	}

}
