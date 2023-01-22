import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		solution(str);
	}

	public static void solution(String str) {
		int N = str.length();
		StringBuilder answer = new StringBuilder();
		List<String> deque = new ArrayList<>();

		boolean isBracket = false;

		for (int i = 0; i < N; i++) {
			String cur = str.charAt(i) + "";
			if (cur.equals("<")) {
				if (!isBracket) {
					while (!deque.isEmpty()) {
						answer.append(deque.remove(deque.size() - 1));
					}
				}

				isBracket = true;
				answer.append(cur);
				continue;
			}

			if (isBracket) {
				if (cur.equals(">")) {
					while (!deque.isEmpty()) {
						answer.append(deque.remove(0));
					}
					isBracket = false;
				}
				answer.append(cur);
			} else {
				if (cur.equals(" ")) {

					while (!deque.isEmpty()) {
						answer.append(deque.remove(deque.size() - 1));
					}
					answer.append(cur);
				} else {
					deque.add(cur);
				}
			}

		}

		while (!deque.isEmpty()) {
			answer.append(deque.remove(deque.size() - 1));
		}

		System.out.print(answer);
	}
}
