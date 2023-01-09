import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// BOJ_2002 추월
public class BOJ_2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String[] out = new String[N];
        int cnt = 0;

        // 입장순서 저장
        for(int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }

        // 퇴장순서 저장
        for(int i = 0; i < N; i++) {
            out[i] = br.readLine();
        }

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                // 뒤에 나올 차량들보다 입장순번이 크다면 추월했다는 의미
                if(map.get(out[i]) > map.get(out[j])) {
                    cnt++;  // 추월차량 개수 증가 후 break
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
