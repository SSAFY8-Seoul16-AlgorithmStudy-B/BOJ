import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] result = new int[N];

		// 선택 정렬
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			result[i] = arr[min];
			arr[min] = arr[i];
			// swap

		}

		for (int num : result) {
			System.out.println(num);
		}
	}

}