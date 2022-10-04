import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ16120 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0, end = inputStr.length(); i < end; i++) {
			char c = inputStr.charAt(i);
			
			if (c == 'P') {
				//P인 경우 일단 삽입
				stack.push(c);
			} else if (i == end-1 || stack.size() < 2 || inputStr.charAt(i+1) != 'P') {
				//맨 끝 문자가 A인 경우 || A가 들어온 시점에서 앞에 P가 2개 이상이 아닌 경우 || A뒤가 또 A인 경우는 치환 불가
				System.out.println("NP");
				return;
			} else {
				stack.pop();
				stack.pop();
			}
		}
		
		if (stack.size() == 1) System.out.println("PPAP");
		else System.out.println("NP");
	}

}
