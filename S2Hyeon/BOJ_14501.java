import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_14501 퇴사
public class BOJ_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[2][N + 1];  // 0행은 기간, 1행은 금액
        int[] dp = new int[N + 1];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                input[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = N - 1; i >= 0; i--) {   // i는 날짜(뒤에서부터)
            if(input[0][i] + i > N) // 오늘 날짜 + 기간이 퇴사일을 넘어선다면
                dp[i] = dp[i + 1];  // 상담 불가이므로 내일의 금액을 오늘 날짜에 저장
            else
                // 내일의 이익(dp) vs 오늘의 이익(input[1]) + (오늘 + 기간)의 이익(dp)
                dp[i] = Math.max(dp[i + 1], input[1][i] + dp[i + input[0][i]]);
        }
        // 상담이 불가능할 때도 내일의 금액을 오늘로 가져왔기 때문에 맨 앞의 값이 최대값
        System.out.println(dp[0]);
    }
}
