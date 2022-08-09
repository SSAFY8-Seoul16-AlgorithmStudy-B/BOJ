import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		solution(str);
	}

	public static void solution(String str) {
		LinkedList<Character> stack = new LinkedList<>();
		int answer = 0;
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (cur == '(') {
				stack.offer(cur);
				continue;
			}
			if (cur == ')') {
				stack.pop();
				if (str.charAt(i - 1) == '(') {
					answer += stack.size();
					continue;
				}
				answer++;
			}
		}
		System.out.println(answer);
	}
}
