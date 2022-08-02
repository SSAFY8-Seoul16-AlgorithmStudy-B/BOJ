import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		solution(n, m, arr);
	}

	public static void solution(int n, int m, int[] numbers) {
		Arrays.sort(numbers);
		int lo = 1, hi = numbers[n - 1] - numbers[0] + 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			int cnt = 1;
			int prev = numbers[0];
			for (int i = 1; i < n; i++) {
				if ((numbers[i] - prev) >= mid) {
					cnt++;
					prev = numbers[i];
				}
			}

			if (cnt < m) {
				hi = mid;
			} else {
				lo = mid + 1;
			}

		}
		System.out.print(lo - 1);
	}
}
