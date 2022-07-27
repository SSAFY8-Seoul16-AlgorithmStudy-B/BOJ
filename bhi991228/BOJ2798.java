import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2798 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); //카드 개수
		int m = scan.nextInt(); //총합 한계
		int[] cards = new int[n];
		int max = 0, sum = 0;
		
		for (int i = 0; i < n; i++) {
			cards[i] = scan.nextInt();
		}
		
		for (int i = 0; i < n-2; i++) {
			if (i > m) continue;
			
			for (int j = i+1; j < n-1; j++) {
				if (j > m) continue;
				
				for (int k = j+1; k < n; k++) {
					if (k > m) continue;
					
					sum = cards[i]+cards[j]+cards[k];
					if (sum <= m && sum > max) max = sum;
				}
			}
		}
		
		System.out.println(max);
	}

}
