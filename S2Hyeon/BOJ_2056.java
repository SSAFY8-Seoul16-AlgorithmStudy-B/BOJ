import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_2056 작업
public class BOJ_2056 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];		// 선행작업 소요시간 + 현재 작업을 수행하고 난 뒤까지의 시간을 저장
        int max = 0;

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());	// 각 작업의 소요 시간
            int preNum = Integer.parseInt(st.nextToken());	// 선행 작업의 개수
            if(preNum == 0) {	// 선행작업의 개수가 0이면
                dp[i] = time;	// dp배열에 현재 작업의 소요시간 저장
            }
            else {	// 선행작업이 있다면
                int maxTime = 0;	//
                for(int j = 0; j < preNum; j++) {	// 선행작업 개수만큼 반복
                    int pre = Integer.parseInt(st.nextToken());	// 선행작업 번호
                    // 선행작업들 중 최대시간이 지나야 현재 작업을 수행할 수 있기 때문에
                    // 선행작업들 중 최대작업시간을 찾는다
                    maxTime = Math.max(maxTime, dp[pre]);
                }
                time += maxTime;	// 현재 작업의 작업시간 + 선행작업 중 최대 작업시간
                dp[i] = time;	// dp에 저장
            }

            max = Math.max(max, time);	// 선행작업이 하나도 없는 경우도 있기 때문에 작업시간의 최대값 비교
        }
        System.out.println(max);
    }
}