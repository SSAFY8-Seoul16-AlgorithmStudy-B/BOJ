import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_11049 행렬 곱셈 순서
public class BOJ_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input, dp;
        input = new int[N + 1][2];
        dp = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++) {    // 괄호안에 들어갈 행렬 개수
            for(int j = 1; i + j <= N; j++) {   // 시작점
                dp[j][i + j] = Integer.MAX_VALUE;
                for(int k = j; k < i + j; k++) {    // 중간지점
                    dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + input[j][0] * input[k + 1][0] * input[i + j][1]);
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}
