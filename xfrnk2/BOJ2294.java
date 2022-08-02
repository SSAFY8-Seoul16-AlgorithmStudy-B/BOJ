import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		solution(n, m, arr);
	}

	static void solution(int n, int m, int[] coins) {
		int[] arr = new int[n + 1];
		int[] dp = new int[m + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;

		if (n >= 0)
			System.arraycopy(coins, 0, arr, 1, n);

		for (int i = 1; i <= n; i++) {

			for (int j = arr[i]; j <= m; j++) {
				dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
			}
		}

		if (dp[m] == Integer.MAX_VALUE - 1)
			System.out.print(-1);
		else
			System.out.print(dp[m]);
	}
}