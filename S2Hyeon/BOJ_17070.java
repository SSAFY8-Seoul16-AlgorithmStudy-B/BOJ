import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_17070 파이프 옮기기 1
public class BOJ_17070 {

    static int map[][];
    static int N, result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 움직이는 방향의 점의 위치만 알면 된다.
        move(1, 2 , 0);
        System.out.println(result);
    }

    private static void move(int row, int col, int state) { // state는 파이프의 상태(가로, 세로, 대각선)

        if(row == N && col == N) {  // 현재 점이 목표지점에 도착하면 카운트++
            result++;
            return;
        }
        int nRow = row + 1; // 진행방향이 증가만 하기 때문에 미리 + 1을 해준다.
        int nCol = col + 1;
        if(state == 0) { // 가로
            if(canMove(row, nCol)) {  // 가로
                move(row, nCol, 0);
            }
            if(canMove(nRow, nCol) && canMove(row, nCol) && canMove(nRow, col)) {    // 대각선
                move(nRow, nCol, 2);
            }
        }
        else if(state == 1) { // 세로
            if(canMove(nRow, col)) {  // 세로
                move(nRow, col, 1);
            }
            if(canMove(nRow, nCol) && canMove(row, nCol) && canMove(nRow, col)) {    // 대각선
                move(nRow, nCol, 2);
            }
        }
        else { // 대각선
            if(canMove(row, nCol)) {  // 가로
                move(row, nCol, 0);
            }

            if(canMove(nRow, col)) {  // 세로
                move(nRow, col, 1);
            }

            if(canMove(nRow, nCol) && canMove(row, nCol) && canMove(nRow, col)) {    // 대각선
                move(nRow, nCol, 2);
            }
        }


    }

    private static boolean canMove(int row, int col) {  // 다음 점이 범위내에 있고, 갈 수 있는 공간이라면 true
        if(row > 0 && row <= N && col > 0 && col <= N && map[row][col] == 0)
            return true;
        return false;
    }
}
