import java.util.Scanner;

public class Main {
	static String[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		solution(n);
	}

	public static void solution(int n) {
		arr = new String[n][n];
		star(0, 0, n);
		StringBuilder sb = new StringBuilder();
		for (String[] row : arr) {
			for (String s : row) {
				if (s == null) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void star(int x, int y, int n) {
		if (n == 1) {
			arr[x][y] = "*";
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(i == 1 && j == 1)) {
					star(x + i * (n / 3), y + j * (n / 3), n / 3);
				}
			}
		}

	}
}
