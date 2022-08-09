import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String baseStr = br.readLine();
		String findStr = br.readLine();
		int answer = 0;
		int index = 0, n = 0;
		int len = findStr.length();
		
		while(true) {
			n = baseStr.indexOf(findStr, index);
			if (n == -1) break;
			answer += 1;
			index = n+len;
		}
		System.out.println(answer);
	}
}
