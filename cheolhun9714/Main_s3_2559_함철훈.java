package cheolhun9714;

import java.util.Arrays;
import java.util.Scanner;

public class Main_s3_2559_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] temp = new int[N];
		int[] sum = new int[N-K+1];
		for(int i=0; i<N; i++) {
			temp[i] = sc.nextInt();
		}
		for(int i=0; i<N-K+1; i++) {
			for(int j =i; j<i+K ; j++) {
				sum[i] +=temp[j];
			}
		}
		Arrays.sort(sum);
		System.out.println(sum[N-K]);
	}

}
