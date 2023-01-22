import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();
		String target = sc.nextLine().trim();
		solution(str, target);
	}

	public static void solution(String str, String target) {
		int idx = 0, answer = 0;
		int N = str.length();
		int targetLen = target.length();

		while (idx <= N - targetLen) {

			String temp = str.substring(idx, idx + targetLen);
			if (target.equals(temp)) {
				answer++;
				idx += targetLen;
			} else {
				idx++;
			}
		}
		System.out.print(answer);
	}
}

