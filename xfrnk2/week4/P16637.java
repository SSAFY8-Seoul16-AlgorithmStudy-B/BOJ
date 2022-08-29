import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class Main {
	static int N, opNum, digitNum, answer = Integer.MIN_VALUE;
	static char[] opArray;
	static int[] numArray;
	static Map<Character, IntBinaryOperator> commands;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		solution(sc.next(), sc.next());
	}

	public static void solution(String n, String expression) {
		int len = Integer.parseInt(n);
		N = len;
		opNum = len / 2;
		digitNum = opNum + 1;
		opArray = new char[opNum];
		numArray = new int[digitNum];
		commands = new HashMap<>();

		commands.put('+', Integer::sum);
		commands.put('-', (a, b) -> a - b);
		commands.put('*', (a, b) -> a * b);

		int opIdx = 0, numIdx = 0;
		for (int i = 0; i < len; i++) {
			char cur = expression.charAt(i);
			if (cur < '0' || '9' < cur) { // 정수가 아닐 경우
				opArray[opIdx] = cur;
				opIdx++;
				continue;
			}
			numArray[numIdx++] = Integer.parseInt("" + cur);
		}
		dfs(0, 0);
		System.out.println(answer);
	}

	public static void dfs(int idx, int cur) {
		if (digitNum <= idx) {
			answer = Math.max(answer, cur);
			return;
		}

		char op = idx == 0 ? '+' : opArray[idx - 1];
		if (idx + 1 < digitNum) {
			dfs(idx + 2, commands.get(op).applyAsInt(
				cur, commands.get(opArray[idx]).applyAsInt(numArray[idx],
					numArray[idx + 1])));
		}
		dfs(idx + 1, commands.get(op).applyAsInt(cur, numArray[idx]));
	}

}
