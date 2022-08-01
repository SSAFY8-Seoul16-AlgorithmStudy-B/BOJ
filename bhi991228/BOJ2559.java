import java.util.Scanner;

public class BOJ2559 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] temps = new int[n];
		int answer = 0, sum = 0;
		
		for (int i = 0; i < n; i++) {
			temps[i] = scan.nextInt();
		}
		
		for (int i = 0; i < n - k + 1; i++) {
			sum = 0;
			for (int j = 0; j < k; j++) {
				sum += temps[i+j];
			}
			
			if (i == 0) answer = sum;
			else answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}

}
