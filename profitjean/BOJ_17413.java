package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17413 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		String words = br.readLine();
		StringBuilder sb = new StringBuilder();
		// stack 사용
		Stack<Character> stack = new Stack<>();
		boolean flag = false;
		
		for (int i = 0; i < words.length(); i++) {
			if (words.charAt(i) == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				flag = true;
			} else if (words.charAt(i) == '>') {
				flag = false;
				sb.append(words.charAt(i));
				continue;
			} 
			
			if (flag == true) {
				sb.append(words.charAt(i));
			} else if (flag == false) {
				if (words.charAt(i) == ' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(' ');
				} else {
					stack.push(words.charAt(i));
				}
			}
			// 마지막은 공백이 없으니까
			if (i==words.length()-1) {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}
			
		}
		System.out.println(sb);
	}
}
