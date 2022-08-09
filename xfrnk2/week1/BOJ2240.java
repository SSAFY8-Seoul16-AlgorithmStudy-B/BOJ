import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	public static void solution(int n, int m, int[] arr) {
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			int tree = arr[i - 1];
			for (int j = 0; j <= m; j++) {
				if (j == 0) {
					if (tree == 1) {
						dp[i][j] = dp[i - 1][j] + 1;
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				} else if (j % 2 == 1) {
					if (tree == 1) {
						dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
					} else {
						dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
					}
				} else {
					if (tree == 1) {
						dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1);
					} else {
						dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
					}
				}
			}
		}

		int answer = 0;
		for (int i = 0; i <= m; i++) {
			answer = Math.max(answer, dp[n][i]);
		}

		System.out.print(answer);

	}
}
