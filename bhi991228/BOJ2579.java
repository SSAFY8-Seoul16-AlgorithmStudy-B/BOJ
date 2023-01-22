import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N];
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = scores[0];									//첫 번째 계단은 무조건 밟는게 이득
		if (N >= 2) dp[1] = scores[0] + scores[1];						//두 번째 계단은 무조건 첫 계단 밟고 오는게 이득
		if (N >= 3) dp[2] = Math.max(scores[0], scores[1]) + scores[2];	//세 번째 계단은 처음 or 두 번째 계단 중 큰 점수 밟고 오는게 이득
		
		for (int i = 3; i < N; i++) {
			// (지금 계단-2의 최종 점수 + 지금 계단 점수) 				=> 2계단 전에서 지금 위치로 바로 오는 경우이므로 3계단 연속 가능성 없음.
			// (지금 계단-3의 최종 점수 + 직전 계단 점수 + 지금 계단 점수) 	=> 직전 계단의 dp 사용 시 3계단 연속의 가능성 있으므로 3계단 전의 최종 점수 + 직전 계단의 점수 사용
			dp[i] = Math.max(dp[i-2]+scores[i], dp[i-3]+scores[i-1]+scores[i]);
		}
		
		System.out.println(dp[N-1]);
	}

}
