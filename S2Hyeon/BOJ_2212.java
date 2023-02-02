import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_2212 센서
public class BOJ_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 센서의 개수
        int K = Integer.parseInt(br.readLine());    // 집중국의 개수
        int[] input = new int[N];
        int[] arr = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 센서 좌표를 오름차순으로 정렬한 뒤 센서간 거리 차이를 구한 뒤
        // 센서 거리차이가 많이나는 곳부터 기지국을 배치하면 센서 간 거리차이를 최소로 만들 수 있다.

        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        Arrays.sort(input); // 센서 좌표 오름차순 정렬
        for(int i = 0; i < N - 1; i++) {
            arr[i] = Math.abs(input[i] - input[i + 1]); // 센서간 거리차이를 저장
        }

        Arrays.sort(arr);   // 센서 간 거리차이를 오름차순으로 정렬
        for(int i = 0; i < N - K; i++) {    // 거리차이가 많이 나는곳부터 K개의 기지국을 배치할 것이므로 N - K까지
            sum += arr[i];  // 센서간 거리차이를 더해준다.
        }

        System.out.println(sum);
    }
}
