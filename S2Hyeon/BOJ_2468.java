import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_2468 안전 영역
class Position {
    int row, col;
    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class BOJ_2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int max = 0;
        int maxHeight = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        for(int i = 0; i <= maxHeight; i++) {
            visited = new boolean[N][N];
            int safeZone = 0;
            for(int row = 0; row < N; row++) {
                for(int col = 0; col < N; col++) {
                    if(!visited[row][col] && map[row][col] > i) {
                        bfs(new Position(row, col), i);
                        safeZone++;
                    }
                }
            }
            max = Math.max(max, safeZone);
        }

        System.out.println(max);
    }

    private static void bfs(Position start, int height) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.row][start.col] = true;

        while(!queue.isEmpty()) {
             Position curPos = queue.poll();
             int row = curPos.row;
             int col = curPos.col;
             for(int i = 0; i < dx.length; i++) {
                 int nextRow = row + dx[i];
                 int nextCol = col + dy[i];
                 if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N) {
                     if(map[nextRow][nextCol] > height && !visited[nextRow][nextCol]) {
                         visited[nextRow][nextCol] = true;
                         queue.offer(new Position(nextRow, nextCol));
                     }
                 }
             }
        }

    }
}
