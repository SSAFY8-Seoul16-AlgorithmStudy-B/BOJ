package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_1309_함철훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer[][] = new int[N][3];
		answer[0][0] = 1;
		answer[0][1] = 1;
		answer[0][2] = 1;
		for(int i=1; i<N;i++) {
			answer[i][0] = (answer[i-1][0]+answer[i-1][1]+answer[i-1][2])%9901;
			answer[i][1] = (answer[i-1][0]+answer[i-1][2])%9901;
			answer[i][2] = (answer[i-1][0]+answer[i-1][1])%9901;
		}
		System.out.println((answer[N-1][0]+answer[N-1][1]+answer[N-1][2])%9901);
	}

}
