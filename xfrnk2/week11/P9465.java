import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {

			int N = Integer.parseInt(in.readLine());
			int[][] sticker = new int[2][N];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[N][3]; // N열에서 스티커를 선택했는지, 0, 1, 2

			dp[0][0] = 0;
			dp[0][1] = sticker[0][0];
			dp[0][2] = sticker[1][0];

			for (int i = 1; i < N; i++) {
				dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + sticker[0][i];
				dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + sticker[1][i];

				dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]);

			}
			System.out.println(Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));

		}

	}

}