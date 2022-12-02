import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_17244 아맞다우산
public class BOJ_17244 {
    static int N, M, totalStuff, time, stuffSize;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][] visited;

    static class Position {
        int row, col, stuff;

        public Position(int row, int col, int stuff) {
            this.row = row;
            this.col = col;
            this.stuff = stuff; // 물건 소지 여부를 비트마스킹으로 확인
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        int startR = 0;
        int startC = 0;
        int stuffNum = 0;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if(c == 'X') {  // 챙겨야 할 물건이 나오면
                    c = (char) ('a' + stuffNum++);  // 비트마스킹을 위해 알파벳 소문자로 변경
                    totalStuff++;   // 총 물건 수
                }
                else if(c == 'S') { // 시작지점
                    startR = i;
                    startC = j;
                }
                map[i][j] = c;
            }
        }

        map[startR][startC] = '.';  // 시작지점 .으로 표시
        stuffSize = (int) Math.pow(2, totalStuff);  // 물건 소지 여부의 최대값(물건 4개일 때 2^4 = 16)
        visited = new boolean[N][M][stuffSize]; // 물건 소지 여부를 포함한 방문표시 배열
        bfs(startR, startC);
        System.out.println(time);

    }
    private static void bfs(int startR, int startC) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(startR, startC, 0));
        visited[startR][startC][0] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            time++; // 시간 증가
            while(--size >= 0) {    // 레벨별 처리
                Position curPos = queue.poll();
                int curR = curPos.row;
                int curC = curPos.col;
                int curS = curPos.stuff;    // 현재 위치에서의 소지중인 물건 정보
                for(int i = 0; i < dx.length; i++) {
                    int nr = curR + dx[i];
                    int nc = curC + dy[i];
                    if(isIn(nr, nc) && !visited[nr][nc][curS] && map[nr][nc] != '#') {
                        char c = map[nr][nc];
                        if(c == '.') {  // 빈 공간이면 현재 물건 소지정보를 유지한 채 다음 위치로
                            queue.offer(new Position(nr, nc, curS));
                            visited[nr][nc][curS] = true;
                        }
                        else if(c == 'E') { // 나가는 문에 도착했을 때
                            if(curS >= stuffSize - 1)   // 물건을 모두 소지하고 있다면
                                return;
                        }
                        else {  // 물건이 있는 위치에 오면
                            int nextS = curS | 1 << (c - 'a');  // 소지중인 물건 정보를 갱신
                            queue.offer(new Position(nr, nc, nextS));
                            visited[nr][nc][nextS] = true;
                        }

                    }
                }
            }
        }
    }
    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }
}