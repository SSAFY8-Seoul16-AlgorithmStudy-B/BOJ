
import java.util.Scanner;

public class Main {
	static int total = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		solution(sc.nextInt());
	}

	public static void solution(int n) {
		hanoi(n, 1, 3, 2);
		System.out.println(total);
		System.out.println(sb);
	}

	private static void hanoi(int count, int start, int end, int temp) {

		if (count == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			total++;
			return;
		}

		hanoi(count - 1, start, temp, end);
		sb.append(start).append(" ").append(end).append("\n");
		total++;
		hanoi(count - 1, temp, end, start);
	}
}
