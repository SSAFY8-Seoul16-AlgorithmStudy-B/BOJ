import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int change1 = 0, change2 = 0;
		boolean isChange1 = true;
		char[] input = br.readLine().toCharArray();
		
		for (int i = 1; i < input.length; i++) {
			if (i == input.length-1 && input[i] != input[0]) {
				change2++;
			}
			
			if (input[i] != input[i - 1]) {
				if (isChange1) {
					change1++;
					isChange1 = false;
				} else {
					change2++;
					isChange1 = true;
				}
			}
		}
		
		System.out.println(Math.min(change1, change2));	
	}
}
