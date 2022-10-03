package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_2579_함철훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] max = new int[N][2]; // [0]: 한칸 올라가기 0회 [1]:한칸 올라가기 1회
		for(int i=0; i<N; i++) {
			int score = Integer.parseInt(br.readLine());
			if(i>1) {
				max[i][0] = Math.max(max[i-2][0], max[i-2][1])+score;
				max[i][1] = max[i-1][0]+score;
			}else if(i==0) {
				max[0][0] = score;
				max[0][1] = 0;
			}else if(i==1) {
				max[1][0] = score;
				max[1][1] = score+max[0][0];
			}
		}
		System.out.println(Math.max(max[N-1][0], max[N-1][1]));
	}

}
