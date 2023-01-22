import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BOJ_4991 로봇 청소기
public class BOJ_4991 {

    static class Position {
        int row, col, key;
        public Position(int row, int col, int key) {
            this.row = row;
            this.col = col;
            this.key = key;
        }
    }

    static int h, w,totalD;
    static LinkedList<Position> dest;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int robotR = 0;
        int robotC = 0;

        while(w != 0 && h != 0) {
            int idx = 0;
            map = new char[h][w];
            dest = new LinkedList<>();
            for(int i = 0; i < h; i++) {
                String str = br.readLine();
                for(int j = 0; j < w; j++) {
                    char c = str.charAt(j);
                    if(c == 'o') {
                        robotR = i;
                        robotC = j;
                    }
                    else if(c == '*') {
                        c = (char)('a' + idx++);
                    }
                    map[i][j] = c;
                }
            }
            map[robotR][robotC] = '.';
            totalD = (int)Math.pow(2, idx);
            visited = new boolean[h][w][totalD];
            System.out.println(bfs(robotR, robotC));

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
    }

    private static int bfs(int robotR, int robotC) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(robotR, robotC, 0));
        visited[robotR][robotC][0] = true;
        int move = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            move++;
            while(--size >= 0) {
                Position curPos = queue.poll();
                int curR = curPos.row;
                int curC = curPos.col;
                int curK = curPos.key;
                for(int i = 0 ; i < dx.length; i++) {
                    int nr = curR + dx[i];
                    int nc = curC + dy[i];
                    if(isIn(nr, nc) && !visited[nr][nc][curK] && map[nr][nc] != 'x') {
                        char next= map[nr][nc];
                        if(next == '.') {
                            queue.offer(new Position(nr, nc, curK));
                            visited[nr][nc][curK] = true;
                        }
                        else {
                            int nk = curK | 1 << (next - 'a');
                            if(nk >= totalD - 1) {
                                return move;
                            }
                            queue.offer(new Position(nr, nc, nk));
                            visited[nr][nc][nk] = true;
                        }

                    }
                }
            }
        }
        return -1;
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nr < h && nc >= 0 && nc < w;
    }
}