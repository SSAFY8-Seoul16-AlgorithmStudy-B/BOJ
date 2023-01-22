import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int stick = 0, answer = 0;

		for (int i = 0; i < input.length; i++) {
			if (input[i] == ')') {
				if (input[i-1] == '(') {
					stick -= 1;
					answer += stick;
				}else {
					stick -= 1;
					answer += 1;
				}
			}else {
				stick += 1;
			}
		}
		
		System.out.println(answer);
	}
}
