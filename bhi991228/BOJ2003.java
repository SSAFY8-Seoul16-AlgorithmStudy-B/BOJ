import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); 
		int[] numbers = new int[n]; 
		int answer = 0, sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = i; j < n; j++) {
				sum += numbers[j];
				if (sum > m) {
					break;
				}else if (sum == m) {
					answer += 1;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

}
