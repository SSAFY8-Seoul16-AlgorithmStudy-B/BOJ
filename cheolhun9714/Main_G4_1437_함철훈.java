package boj;

import java.util.Scanner;

public class Main_G4_1437_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int mod = N%3;
		int power;
		int answer;
		answer=(N==0?0:1);
		if(N!=1) {	
			if(mod == 1) {
				power = N/3 -1;
				for(int i=0; i<power; i++) {
					answer*=3;
					answer%=10007;
				}
				answer*=4;
				answer%=10007;
			}else {
				power=N/3;
				for(int i=0; i<power; i++) {
					answer*=3;
					answer%=10007;
				}
				if(mod==2) {
					answer*=2;
					answer%=10007;
				}
			}
		}
		System.out.println(answer);
	}

}
