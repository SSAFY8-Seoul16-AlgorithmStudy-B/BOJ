package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {
	// () -> 바로 열고 닫히면 레이저
	// ( -> 쇠막대기 시작점
	// ) -> 쇠막대기 끝점
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		String input = br.readLine();
		
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				stack.push(i);
			} else { // 닫힌괄호 만날때. 직전인덱스 스택에 들어가있는걸로 괄호 순서쌍 파악
				if (stack.peek() == i-1) {
					stack.pop();
					count+=stack.size();
				} else {
					stack.pop();
					count ++;
				}
			}
		}
		System.out.println(count);
	}
}
