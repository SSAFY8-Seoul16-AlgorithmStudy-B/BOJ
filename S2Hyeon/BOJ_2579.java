import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ_2579 계단 오르기
public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[] dp = new int[N + 1];
        int sum = 0;

        for(int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
            sum += stairs[i];
        }

        if(N <= 2) {    // 계단 수가 2개 이하라면 계단의 점수 합을 출력
            System.out.println(sum);
            return;
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];  // 1, 2번째 계단까지 도달하는데 최대 점수
        for(int i = 3; i <= N; i++) {
            // 현재 계단까지 도달하는 경우
            // 1. i - 2번째 계단을 밟고 온 경우
            // 2. i - 1번째 계단과 i - 3번째 계단을 밟고 온 경우
            //      i - 1번째 계단은 이전 계단에서 i - 2번째 계단을 밟고 온 점수가 들어있을 수 있으므로
            //      stairs[i - 1] 점수와 i - 3번째에서의 최대 점수를 더해준다.
            dp[i] = Math.max(dp[i - 2], stairs[i - 1] + dp[i - 3]) + stairs[i];
        }

        System.out.println(dp[N]);
    }
}
