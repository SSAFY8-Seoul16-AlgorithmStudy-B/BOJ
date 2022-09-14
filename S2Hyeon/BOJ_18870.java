import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_18870 좌표 압축
public class BOJ_18870 {

    public static class xInfo implements Comparable<xInfo> {
        int x, index, result;
        public xInfo(int x, int index, int result) {
            this.x = x; // 입력값 X
            this.index = index; // 입력받을 때 인덱스
            this.result = result; // 압축 결과
        }

        @Override
        public int compareTo(xInfo o) {
            return this.x - o.x;    // 입력값을 기준으로 오름차순
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        xInfo[] inputArr = new xInfo[N];    // 입력값과 인덱스, 압축 결과를 저장할 배열
        int[] resultArr = new int[N];       // 압축 결과를 입력받은 인덱스에 맞게 저장할 배열
        int result = 0;

        for(int i = 0; i < N; i++) {
            int inputNum = Integer.parseInt(st.nextToken());
            inputArr[i] = new xInfo(inputNum, i, 0);    // 결과값은 정렬 이후에 저장
        }

        Arrays.sort(inputArr);  // 입력값을 기준으로 오름차순 정렬

        for(int i = 0; i < N; i++) {
            xInfo xinfo = inputArr[i];
            if(i > 0 && inputArr[i - 1].x != xinfo.x) { // 이전 원소와 비교하여 다른 값이라면
                result++;   // 결과값을 1 올린 후
            }
            xinfo.result = result;  // 결과값 저장
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            xInfo xinfo = inputArr[i];
            resultArr[xinfo.index] = xinfo.result;  // 입력받을 때 인덱스에 결과값을 저장
        }

        for(int i = 0; i < N; i ++) {   // 출력
            sb.append(resultArr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
