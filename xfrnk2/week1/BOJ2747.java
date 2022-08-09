import java.util.*;
import java.io.*;

public class Main {


	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
		int answer = fibonacci(sc.nextInt());
		System.out.print(answer);
	}

	private static int fibonacci (int n) {

		if (n < 2) return 1;

		int[] arr = new int[n+1];
		arr[1] = 1;

		for (int i = 2; i <= n; i ++) {
			arr[i] = arr[i-1] + arr[i-2];
		}

		return arr[n];
	}
}
