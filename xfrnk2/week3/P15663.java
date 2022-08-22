package boj.p15k.p15600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P15663 {
	static int N, M, size;
	static String[] numbers;
	static boolean[] selected;
	static String prev = "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new String[N];
		List<Integer> inputs = new ArrayList<Integer>(N);
		for (int i = 0; i < N; i++) {
			inputs.add(sc.nextInt());
		}
		Collections.sort(inputs);
		Integer[] temp = inputs.toArray(new Integer[N]);

		solution(N, M, temp);
	}

	private static void search(int cnt, String output) {
		if (cnt == M) {
			if (prev.contains(output))
				return;
			System.out.println(output.trim());
			prev += output + ", ";
			return;
		}
		for (int i = 0; i < size; i++) {
			if (selected[i])
				continue;
			selected[i] = true;
			search(cnt + 1, output + " " + numbers[i]);
			selected[i] = false;
		}
	}

	static void solution(int n, int m, Integer[] temp) {
		size = N;
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.toString(temp[i]);
		}
		search(0, "");
	}

}
