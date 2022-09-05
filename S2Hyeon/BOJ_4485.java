import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_4485 녹색 옷 입은 애가 젤다지?
public class BOJ_4485 {

    static int N, min;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    static class Position {
        int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int tc = 1;
        while(N != 0) {
            map = new int[N][N];

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            bfs(0, 0);

            sb.append("Problem ").append(tc).append(": ").append(min).append("\n");
            N = Integer.parseInt(br.readLine());
            tc++;
        }
        System.out.println(sb);
    }

    private static void bfs(int row, int col) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(row, col));

        int[][] minArr = new int[N][N];

        // 최소값 비교를 위해 배열원소 정수 최대값 채우기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                minArr[i][j] = Integer.MAX_VALUE;
            }
        }
        // 시작점(0, 0) 입력
        minArr[0][0] = map[0][0];

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(--size >= 0) {    // 레벨단위 처리
                Position cur = queue.poll();
                int curRow = cur.row;
                int curCol = cur.col;
                for(int i = 0; i < dx.length; i++) {
                    int nr = curRow + dx[i];
                    int nc = curCol + dy[i];
                    if(isIn(nr, nc)) {
                        int num = minArr[curRow][curCol] + map[nr][nc]; // 지금까지의 최소 비용과 다음 위치의 비용 더하기
                        if(minArr[nr][nc] > num) { // 기존값과 비교하여 작은수일 때
                            queue.offer(new Position(nr, nc)); // 큐에 넣고
                            minArr[nr][nc] = num; // 배열 갱신
                        }

                    }
                }
            }
        }
        min = minArr[N - 1][N - 1];
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N;
    }
}
