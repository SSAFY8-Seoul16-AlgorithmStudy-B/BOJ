package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G4_1563_함철훈{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][][] answer = new int[N+1][3][2];  // [�� ��][������ �Ἦ�� ��][���� ��]
		answer[1][0][0] =1;
		answer[1][1][0] =1;
		answer[1][0][1] =1;
		for(int i=2; i<=N; i++) {
			answer[i][0][0] = (answer[i-1][0][0]+answer[i-1][1][0]+answer[i-1][2][0])%1000000;
			answer[i][0][1] = (answer[i-1][0][0] + answer[i-1][0][1] + answer[i-1][1][0]+ answer[i-1][1][1]+ answer[i-1][2][0] + answer[i-1][2][1])%1000000;
			answer[i][1][0] = answer[i-1][0][0];
			answer[i][1][1] = answer[i-1][0][1];
			answer[i][2][0] = answer[i-1][1][0];
			answer[i][2][1] = answer[i-1][1][1];
		}
		System.out.println((answer[N][0][0]+answer[N][0][1]+answer[N][1][0]+answer[N][1][1]+answer[N][2][0]+answer[N][2][1])%1000000);
	
	
	
	}
}
