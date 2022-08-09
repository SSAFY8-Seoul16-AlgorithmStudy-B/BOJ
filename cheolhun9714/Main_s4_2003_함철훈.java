package cheolhun9714;

import java.util.Scanner;

public class Main_s4_2003_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int sum=0,count=0;
		int[] num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
			sum=0;
			for(int j=i; j>=0;j--) {
				sum+=num[j];
				if (sum> M)	{
					sum=0;
					break;
				}
				else if(sum == M) {
					count++;
					sum=0;
					break;
				}
			}
		}
		System.out.println(count);
		sc.close();
	}

}
