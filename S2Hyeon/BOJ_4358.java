import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BOJ_4358 생태학
public class BOJ_4358 {
    public static void main(String[] args) throws IOException {
        // Set으로 중복 비교하면서 각 종별 개수 카운트(Map<String, int>)
        // Set을 list나 array로 전환 후
        // 전체 개수에서 종별 개수 나눠서 비율 계산 후 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();  // 중복 여부를 판단

        // 종 이름과 각 나무 종의 개수 저장, TreeMap을 사용하여 사전순으로 정렬하며 저장
        Map<String, Integer> map = new TreeMap<>();
        int totalCnt = 0;   // 전체 나무 개수

        String str = br.readLine();
        while(str != null && str.length() != 0) {
            if(set.contains(str)) { // 종이 이미 set에 들어가 있는 경우
                int n = map.get(str) + 1; // 개수 증가
                map.put(str, n);    // 맵에 같은 키값을 이용하여 개수만 갱신
            }
            else {  // 처음 나온 종 이라면
                set.add(str);   // set에 추가
                map.put(str, 1);    // 맵에 기본값(1)으로 저장
            }
            str = br.readLine();    // 다음 라인 읽어오기
            totalCnt++; // 전체 나무 개수 증가
        }

        StringBuilder sb = new StringBuilder();
        for(String name : map.keySet()) {   // 맵에 있는 키셋 가져오기
            int n = map.get(name);  // 키에 맞는 개수 가져오기
            double percent = 100.0 * n / totalCnt;  // 백분율 계산
            sb.append(name).append(" ").append(String.format("%.4f\n", percent));
        }
        System.out.println(sb);
    }
}
