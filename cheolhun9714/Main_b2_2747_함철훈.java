package cheolhun9714;

import java.util.Scanner;

public class Main_b2_2747_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] fib = new int[n];
		if(n == 1 || n==2) {
			System.out.println("1");
		}
		else {
			fib[0] = 0;
			fib[1] = 1;
			for (int i=2;i<n;i++) {
				fib[i] = fib[i-1]+fib[i-2];
			}
			System.out.println(fib[n-1]+fib[n-2]);
		}
		sc.close();
	}

}
