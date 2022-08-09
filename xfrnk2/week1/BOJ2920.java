import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer[] arr = new Integer[8];
		for (int i = 0; i < 8; i ++) {
			arr[i] = (Integer) sc.nextInt();
		}

		Integer[] copy = Arrays.copyOf(arr, arr.length);

		if (arr[0] == 1) {
			Arrays.sort(copy);
			if (Arrays.equals(arr, copy)) {
				System.out.print("ascending");
			} else {
				System.out.print("mixed");
			}
		} else if (arr[0] == 8) {
			Arrays.sort(copy, (a, b) -> b - a);
			if (Arrays.equals(arr, copy)) {
				System.out.print("descending");
			} else {
				System.out.print("mixed");
			}
		} else {
			System.out.print("mixed");
		}
	}
}
