import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution_문자열압축 {
    public static int solution(String s) {
        int answer = 1000;
        int strLength = s.length();
        if(strLength == 1)  // 문자열 길이가 1이라면 답은 1
            answer = 1;

        StringBuilder result;
        String[] arr;   // 자른 문자열을 담을 배열
        for(int i = 1; i <= strLength / 2; i++) {  // i : 자를 단위 => 절반을 넘어가면 압축 불가
            result = new StringBuilder();
            int arrLength = strLength / i + 1;  // 배열 마지막에 -1을 넣어주기 위해 배열길이 + 1
            if(strLength % i != 0)  // 문자열을 지정된 크기만큼 자른 뒤 남은 글자가 있다면
                arrLength++;    // 남은 글자 넣기위해 배열 크기 하나 증가
            arr = new String[arrLength];
            for(int j = 0; j < arr.length - 1; j++) {
                int start = i * j;  // substring 시작점
                int end = start + i; // substring 끝점
                if(end >= strLength)    // 끝점이 문자열 길이를 넘으면 문자열 끝으로 재설정
                    end = strLength;
                arr[j] = s.substring(start, end);   // 자른 문자열을 배열에 저장
            }
            arr[arr.length - 1] = "-1"; // 이전 값 비교에서 범위 초과 방지

            // 비교
            int cnt = 0;
            for(int j = 1; j < arr.length; j++) {
                if(result.length() > answer) {  // 결과값이 이미 최소값을 넘은경우 break
                    break;
                }

                if(arr[j - 1].equals(arr[j])) { // 이전값과 비교하여 같다면
                    cnt++;
                }
                else {  // 이전값과 다른 글자가 나왔다면
                    if(cnt == 0) {  // 같은 글자가 하나도 없었다면
                        result.append(arr[j - 1]);  // 숫자 없이 이전글자 출력
                    }
                    else {  // 같은 글자가 한쌍이라도 있었다면
                        result.append(cnt + 1).append(arr[j - 1]);  // 숫자 포함 이전글자 출력
                    }
                    cnt = 0;
                }
            }
            answer = Math.min(answer, result.length()); // 최소값 비교
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = solution(br.readLine());
        System.out.println(n);
    }
}