import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1437 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long sum = 1;
		
		while (true) {
			if (N < 5) break;
			
			sum = (sum % 10007) * 3;
			N -= 3;
		}
		
		System.out.println((sum*N)%10007);
	}

}
