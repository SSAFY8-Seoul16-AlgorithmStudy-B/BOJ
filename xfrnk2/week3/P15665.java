package boj.p15k.p15600;

import java.util.Arrays;
import java.util.Scanner;

public class P15665 {
	static int N, M;
	static int[] numbers;
	static int[] res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[N];
		res = new int[M];

		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		Arrays.sort(numbers);
		search(0, sb);
		System.out.print(sb);
	}

	private static void search(int cnt, StringBuilder sb) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}
		int num = 0;
		for (int i = 0; i < N; i++) {
			if (num == numbers[i])
				continue;
			res[cnt] = numbers[i];

			search(cnt + 1, sb);
			num = numbers[i];
		}
	}

}
