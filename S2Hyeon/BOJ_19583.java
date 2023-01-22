import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// BOJ_19583 싸이버개강총회
public class BOJ_19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 시작시간, 끝난 시간, 스트리밍 끝난 시간
        int S = Integer.parseInt(st.nextToken().replace(":", ""));
        int E = Integer.parseInt(st.nextToken().replace(":", ""));
        int Q = Integer.parseInt(st.nextToken().replace(":", ""));
        int result = 0;

        // 중복된 것을 거르기 위한 Set
        Set<String> set = new HashSet<>();
        String line = br.readLine();

        while(line != null && line.length() != 0) {
            st = new StringTokenizer(line);
            // 쉬운 비교를 위해 23:00꼴의 시간을 숫자 2300으로 변환
            int time = Integer.parseInt(st.nextToken().replace(":", ""));

            // 시작 시간보다 일찍 채팅을 쳤으면 set에 추가
            if(time <= S) {
                set.add(st.nextToken());
            }
            // 시작 시간이 지나면 break
            else
                break;

            line = br.readLine();
        }

        while(line != null && line.length() != 0) {
            st = new StringTokenizer(line);
            int time = Integer.parseInt(st.nextToken().replace(":", ""));

            // 개강총회가 끝난 시간 ~ 스트리밍이 끝난 시간일 때
            if(time >= E && time <= Q) {
                String str = st.nextToken();
                // 채팅 친 사람이 이미 Set에 들어가 있다면
                if(set.contains(str)) {
                    // 출석 인정 후 Set에서 제거
                    result++;
                    set.remove(str);
                }
            }
            // 스트리밍이 끝난 뒤 올라온 채팅이 있다면 break
            else if(time > Q)
                break;

            line = br.readLine();
        }

        System.out.println(result);
    }
}
