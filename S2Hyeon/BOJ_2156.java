import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ_2156 포도주 시식
public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        if(n <= 2) {
            System.out.println(sum);
            return;
        }

        dp[1] = arr[1];
        dp[2] = dp[1] + arr[2];
        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]), dp[i - 1]);
        }

        System.out.println(dp[n]);

    }
}
