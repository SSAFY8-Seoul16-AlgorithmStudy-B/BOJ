package cheolhun9714;

import java.util.Scanner;

public class Main_b2_2979_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int car = 0;
		int[][] time = new int[3][2];
		int answer = 0;
		for(int i=0; i<3;i++){
			for(int j =0; j<2;j++) {
				time[i][j]=sc.nextInt();
			}
		}
			
		for (int t=0; t<=100;t++) {
			for(int i=0; i<3; i++) {
				if(t==time[i][0]) {
					car++;
				}
				if(t==time[i][1]) {
					car--;
				}	
			}
			if (car==1) {
				answer += A;
			}
			if (car==2) {
				answer += 2*B;
			}
			if (car==3) {
				answer += 3*C;
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
