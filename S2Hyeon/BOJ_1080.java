import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1080 행렬
public class BOJ_1080 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] matrixA = new int[N][M];
        int[][] matrixB = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                matrixA[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                matrixB[i][j] = str.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // 현재 위치의 값이 다르고 3 X 3크기를 뒤집을 수 있다면(범위내에 있다면)
                if(matrixA[i][j] != matrixB[i][j] && isIn(i, j)) {
                    matrixA[i][j] ^= 1;
                    matrixA[i][j + 1] ^= 1;
                    matrixA[i][j + 2] ^= 1;
                    matrixA[i + 1][j] ^= 1;
                    matrixA[i + 1][j + 1] ^= 1;
                    matrixA[i + 1][j + 2] ^= 1;
                    matrixA[i + 2][j] ^= 1;
                    matrixA[i + 2][j + 1] ^= 1;
                    matrixA[i + 2][j + 2] ^= 1;
                    cnt++;
                }
            }
        }

        boolean flag = true;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // 완성된 행렬 A가 B와 다르면 -1을 출력하기 위해 flag 설정
                if(matrixA[i][j] != matrixB[i][j]) {
                    flag = false;
                    break;
                }
            }
            // 행렬 A가 B와 다르다면 더이상 비교할 필요가 없으므로 break
            if(!flag)
                break;
        }
        if(!flag) {
            System.out.println(-1);
        }
        else {
            System.out.println(cnt);
        }

    }

    private static boolean isIn(int i, int j) {
        return i + 2 < N && j + 2 < M;
    }
}
