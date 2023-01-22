package cheolhun9714;

import java.util.Scanner;

public class Main_s5_1789_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long sum=0;
		for(long i=1; i<N+1;i++) {
			sum+=i;
			if (sum==N)	{
				System.out.println(i);
				break;
			}else if (sum>=N) {
				System.out.println(i-1);
				break;
			}
		}
		
	}

}
