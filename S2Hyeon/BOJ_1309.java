import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ_1309 동물원
public class BOJ_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];
        dp[1][0] = 1;   // N이 1일 때 배치 하지 않는 경우
        dp[1][1] = 1;   // N이 1일 때 왼쪽에 배치하는 경우
        dp[1][2] = 1;   // N이 2일 때 오른쪽에 배치하는 경우

        for(int i = 2; i <= N; i++) {
            // n - 1이 비었을 때
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            // n - 1의 왼쪽에 있을 때
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            // n - 1의 오른쪽에 있을 때
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }
        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
    }
}
