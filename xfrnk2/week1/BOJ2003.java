import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i ++) {
			arr[i] = sc.nextInt();
		}
		solution(n, m, arr);
	}

	public static void solution(int n, int m, int[] numbers) {
		int cnt = 0;

		for (int i = 0; i < n ; i ++) {
			int sum = 0;
			for (int j = i; j < n; j ++) {
				sum += numbers[j];
				if (sum == m) {
					cnt ++;
					break;
				}
			}

		}

		System.out.print(cnt);
	}
}
