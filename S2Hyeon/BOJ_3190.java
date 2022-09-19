import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// BOJ_3190 뱀
public class BOJ_3190 {
    static int N, time;
    static int headDir;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean gameOver;
    static Deque<Position> snake;

    static class Position {
        int row, col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        // 뱀의 위치는 1로 표시
        map[1][1] = 1;  // 뱀의 첫 시작 위치 표시
        headDir = 1;    // 뱀의 머리 방향 : 0부터 상 우 하 좌
        snake = new ArrayDeque<>(); // 뱀의 위치를 저장할 deque
        snake.offer(new Position(1, 1));    // 뱀의 첫 시작 위치 저장

        int apple = Integer.parseInt(br.readLine());    // 사과 개수
        StringTokenizer st;

        for(int i = 0; i < apple; i++) {
            st = new StringTokenizer(br.readLine());
            // 사과의 위치를 2로 표시
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
        }

        int L = Integer.parseInt(br.readLine());    // 방향 변환 횟수
        int preX = 0;   // 이동시간을 구하기 위한 이전 시간
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());   // 현재 방향으로 이동할 시간
            simulate(X - preX, st.nextToken().charAt(0)); // 이동시간, 변환 방향
            preX = X;   // 현재 시간을 이전 시간으로
            if(gameOver) {  // 게임이 끝났으면 break
                break;
            }
        }

        // gameover가 되지 않고 반복문이 끝났으면 더이상 방향전환 없이 뱀이 벽에 부딪혀 게임을 끝내야 한다
        if(!gameOver) {
            simulate(N, 'X');   // 최대 길이인 N만큼 이동하며 관련 없는 문자인 X를 인자로 넘긴다
        }

        System.out.println(time);

    }

    private static void simulate(int X, char C) {
        Position curPos;
        for(int i = 0; i < X; i++) {
            curPos = snake.peekFirst(); // 현재 뱀의 머리위치
            time++;
            // 뱀의 다음 위치 구하기
            int nr = curPos.row + dx[headDir];
            int nc = curPos.col + dy[headDir];

            if(isGameOver(nr, nc)) {    // 게임오버 판정
                return;
            }

            if(map[nr][nc] != 2) {  // 다음 위치가 사과가 아니라면
                // deque의 끝자리 poll 해서 해당 위치 0으로 변환
                Position tailPos = snake.pollLast();
                map[tailPos.row][tailPos.col] = 0;
            }
            map[nr][nc] = 1;    // 뱀의 머리 위치를 1로 표시
            snake.offerFirst(new Position(nr, nc)); // 뱀의 머리의 새로운 위치 저장
        }

        if(C == 'L') {  // 이동 종료 후 방향값이 L(왼쪽)이면
            headDir--;  // 방향값 감소
            if(headDir < 0) // -1로 떨어지면 3으로 변경
                headDir = 3;
        }
        else if(C == 'D') { // 오른쪽이면
            headDir++;  // 방향값 증가
            headDir %= 4;   // 4가 되면 나머지연산으로 0으로 변경
        }
    }

    private static boolean isGameOver(int nr, int nc) {
        // 다음위치가 보드 크기 범위를 벗어나거나 뱀의 몸(1)인 경우
        if(nr > N || nr < 1 || nc > N || nc < 1 || map[nr][nc] == 1)
            gameOver = true;    // 게임오버

        return gameOver;
    }
}
