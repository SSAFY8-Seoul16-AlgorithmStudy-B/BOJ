package July;

import java.util.Scanner;

public class BOJ_2747 {

//	public static int Fibb(int n) {
//		if (n<=1) {
//			return 1;
//		} else {
//			return Fibb(n-1) + Fibb(n-2);
//		}
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] Fibo = new int[N+2];
		Fibo[0] = 0;
		Fibo[1] = 1;
		if(N>=2) {
			for(int i = 2; i<N+1; i++) {
				Fibo[i] = Fibo[i-1] + Fibo[i-2];
			}
		}
		System.out.print(Fibo[N]);
	}

}
