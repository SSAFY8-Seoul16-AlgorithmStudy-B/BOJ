import java.util.Scanner;

public class Main {
	static int zero = 0, one = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		solution(str);
	}

	private static void addCnt(char cur) {
		if (cur == '0')
			zero++;
		else
			one++;
	}

	public static void solution(String str) {

		char prev = str.charAt(0);
		addCnt(prev);

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == prev) {
				continue;
			}
			prev = str.charAt(i);
			addCnt(prev);
		}
		System.out.println(Math.min(one, zero));
	}
}

