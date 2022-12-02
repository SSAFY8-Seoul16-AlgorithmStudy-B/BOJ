import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1912 연속합
public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int max = dp[0];
        boolean check = false;    // 음수 표시할 변수
        if (dp[0] < 0) check = true;    // 첫번째 값이 음수라면 true로 시작

        // 음수가 나오면 다음 위치에서 음수를 합한 값 + 다음 위치 값 vs 다음 위치 값
        for (int i = 1; i < n; i++) {
            if (check) {    // 이전 값이 음수라면
                dp[i] = Math.max(dp[i - 1] + dp[i], dp[i]);    // 이전 위치(음수)를 합산한 값 vs 현재 값(입력 값)
                check = false;    // 음수를 확인했으므로 false로 초기화
            } else {    // 이전 값이 음수가 아니라면
                dp[i] += dp[i - 1];    // 현재 위치에 이전 값을 합산한 값 저장
            }

            if (dp[i] < 0) {    // 현재 위치가 음수라면
                check = true;    // 음수 표시
            }
            max = Math.max(max, dp[i]);    // 현재 값과 최대값 비교하여 갱신

        }

        System.out.println(max);
    }
}