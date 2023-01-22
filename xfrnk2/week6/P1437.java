import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(search(N));
	}
	
	public static int search (int n) {
		if (n < 5) {
			return n;
		}


		int[] D = new int[1000001];
		for (int i = 1; i < 5; i++) {
			D[i] = i; 
		}
		
		
		for (int i = 5; i <= n; i++) {
			D[i] = (D[i-3] * 3) % 10007;
		}
		
		return D[n];
		
	}
	

}
