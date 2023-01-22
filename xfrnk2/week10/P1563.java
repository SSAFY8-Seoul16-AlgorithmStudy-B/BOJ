import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][][] dp = new int[N + 1][2][3];
		dp[1][0][0] = 1;
		dp[1][0][1] = 1;
		dp[1][1][0] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % 1000000;
			dp[i][0][1] = (dp[i - 1][0][0]) % 1000000;
			dp[i][0][2] = dp[i - 1][0][1] % 1000000;
			dp[i][1][0] = (dp[i][0][0] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % 1000000;
			dp[i][1][1] = dp[i - 1][1][0] % 1000000;
			dp[i][1][2] = dp[i - 1][1][1] % 1000000;

		}
		int res = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				res += dp[N][i][j];
			}
		}
		System.out.println(res % 1000000);

	}

}
