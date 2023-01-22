import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1091 카드 섞기
public class BOJ_1091 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] P = new int[N];   // 카드가 어떤 플레이어에게 가야 하는지
        int[] S = new int[N];   // 카드를 섞는 방법
        int[] copy = new int[N];    // 이전 결과를 복사할 배열
        int[] result = new int[N];  // 섞인 카드를 저장할 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            result[i] = P[i];   // 결과 배열 초기화
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        while(count >= 0) { // 실패 시 count가 -1이 되므로 0이상일 때 반복
            if(check(result)) break;    // 목적 달성 시 break
            count++;
            for(int i = 0; i < N; i++) {    // 이전 결과 복사
                copy[i] = result[i];
            }
            for(int i = 0; i < N; i++) {    // 주어진 방법으로 카드 섞기
                result[S[i]] = copy[i];
            }

            for(int i = 0; i < N; i++) {
                if(result[i] != P[i]) break;    // 초기 상태와 비교하여 다르다면
                if(i == N - 1) {    // 초기 상태로 되돌아 왔다면
                    count = -1; // 실패
                    break;
                }
            }

        }
        System.out.println(count);
    }

    private static boolean check(int[] result) {
        for(int i = 0; i < N; i++) {
            if(result[i] != (i % 3)) {  // 0, 1, 2로 반복되는지 확인
                return false;
            }
        }
        return true;
    }

}
