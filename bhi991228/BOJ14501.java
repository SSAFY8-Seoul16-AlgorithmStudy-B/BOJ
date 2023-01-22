import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] needs = new int[N+1];
		int[] pays = new int[N+1];
		int[] dp = new int[N+2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			needs[i] = Integer.parseInt(st.nextToken());
			pays[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int day = N; day >= 1; day--) {
			if (needs[day] > N-day+1) dp[day] = dp[day+1];	//이 일을 퇴사 전에 못 끝내는 상황이면 선택 안함
			else dp[day] = Math.max(dp[day+needs[day]] + pays[day], dp[day+1]);	//이 일을 선택 + 이 일이 끝난 이후부터의 수익 vs 이 일을 선택 x
		}
		
		System.out.println(dp[1]);
	}

}
