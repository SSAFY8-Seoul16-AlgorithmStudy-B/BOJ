import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] costs = new int[N+1];
		int[] dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int num = 1; num <= N; num++) {
			int cost = costs[num];
			
			for (int i = num; i <= N; i++) {
				dp[i] = Math.max(dp[i], dp[i-num]+cost);
			}
		}
		
		System.out.println(dp[N]);
	}

}
