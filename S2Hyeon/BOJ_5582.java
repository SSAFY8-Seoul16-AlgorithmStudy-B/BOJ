import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ_5582 공통 부분 문자열
public class BOJ_5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int length1 = str1.length;
        int length2 = str2.length;
        // 첫번 째 문자열을 열(가로)로, 두 번째 문자열은 행(세로)으로
        int[][] lcs = new int[length2 + 1][length1 + 1];
        int max = 0;

        // 각 문자열의 크기만큼 2차원 배열을 돌면서
        // 같은 문자가 나오면 이전 문자(i - 1, j - 1)까지의 공통부분에 + 1
        for(int i = 1; i <= length2; i++) {
            for(int j = 1; j <= length1; j++) {
                if(str2[i - 1] == str1[j - 1]) {    // 현재 문자가 같다면
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;  // 이전 문자까지의 공통부분 + 1
                    max = Math.max(max, lcs[i][j]); // 최대값 갱신
                }
            }
        }

        System.out.println(max);
    }
}
