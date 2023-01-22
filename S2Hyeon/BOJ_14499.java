import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_14499 주사위 굴리기
public class BOJ_14499 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());    // 세로 크기
        M = Integer.parseInt(st.nextToken());    // 가로 크기
        int x = Integer.parseInt(st.nextToken());    // 주사위 x좌표
        int y = Integer.parseInt(st.nextToken());    // 주사위 y좌표
        int k = Integer.parseInt(st.nextToken());    // 명령의 개수

        int[][] map = new int[N][M];
        int[] dice = new int[6];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int move = Integer.parseInt(st.nextToken());
            int temp = dice[0];
            if(move == 1) {     // 동
                if(isIn(x, y + 1)) {
                    y++;    // 주사위 이동
                    dice[0] = dice[3];  // 이동에 따른 주사위 순서 변경
                    dice[3] = dice[5];
                    dice[5] = dice[2];
                    dice[2] = temp;
                }
                else {  // 범위 밖이면 명령 무시
                    continue;
                }
            }
            else if(move == 2) {
                if(isIn(x, y - 1)) {
                    y--;
                    dice[0] = dice[2];
                    dice[2] = dice[5];
                    dice[5] = dice[3];
                    dice[3] = temp;
                }
                else {
                    continue;
                }
            }
            else if(move == 3) {
                if(isIn(x - 1, y)) {
                    x--;
                    dice[0] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[4];
                    dice[4] = temp;
                }
                else {
                    continue;
                }
            }
            else if(move == 4) {
                if(isIn(x + 1, y)) {
                    x++;
                    dice[0] = dice[4];
                    dice[4] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = temp;
                }
                else {
                    continue;
                }
            }
            if(map[x][y] == 0) {    // 맵이 빈칸이면
                map[x][y] = dice[5];    // 주사위의 바닥면에있는 값 복사
            }
            else {
                dice[5] = map[x][y];    // 주사위의 바닥면에 맵의 숫자 복사
                map[x][y] = 0;  // 복사 후 칸에 쓰여있는 수 설정
            }
            System.out.println(dice[0]);   // 주사위의 윗면 출력
        }
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}