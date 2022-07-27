import java.util.Scanner;

public class BOJ2747 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		if (n != 0) {
			int[] fibonacci = new int[n+1];
			fibonacci[0] = 0; fibonacci[1] = 1;
			
			for (int i = 2; i <= n; i++) {
				fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
			}
			
			System.out.println(fibonacci[n]);
		} else {
			System.out.println(0);
		}
		
	}

}
