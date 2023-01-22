import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int idx = 0;
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0, end = s.length(); i < end; i++) {
			if (s.charAt(i) == 'P') {
				stack.add(s.charAt(i));
				continue;
				}

			
			if (stack.size()>= 2 && i < end - 1 && s.charAt(i) == 'A' && s.charAt(i + 1) == 'P') {
				stack.pop();
				stack.pop();
				continue;
			} 
			
			
			else {
				System.out.println("NP");
				return;
			}
		}
		System.out.println(stack.size() == 1? "PPAP" : "NP");
		
		
	}

}