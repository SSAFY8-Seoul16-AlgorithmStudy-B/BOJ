package July;

import java.util.Scanner;

public class BOJ_2798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 5
		int M = sc.nextInt(); // 21
		int sum = 0;
		int max = 0;
		int [] card = new int[N];
		for (int i = 0; i < card.length; i++) {
			card[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					sum = card[i] + card[j] + card[k];
					if (sum>=max && sum<=M) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
		
	}

}
