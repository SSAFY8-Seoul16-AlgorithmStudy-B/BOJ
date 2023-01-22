import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_9465 스티커
public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[3][n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= n; i++) {   // 위쪽 스티커
                dp[1][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {   // 아래쪽 스티커
                dp[2][i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 2; i <= n; i++) {
                // 왼쪽 스티커를 떼지 않았을 때
                dp[0][i] += Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]), dp[2][i - 1]);
                // 왼쪽 위 스티커를 뗐을 때
                dp[1][i] += Math.max(dp[0][i - 1], dp[2][i - 1]);
                // 왼쪽 아래 스티커를 뗐을 때
                dp[2][i] += Math.max(dp[0][i - 1], dp[1][i - 1]);
            }

            System.out.println(Math.max(Math.max(dp[0][n], dp[1][n]), dp[2][n]));
        }
    }
}
