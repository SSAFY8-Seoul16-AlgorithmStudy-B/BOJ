import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BOJ_19238 스타트 택시
public class BOJ_19238 {
    static int N, M;
    static int[] dx = {-1, 0 , 0, 1};   // 상 좌 우 하
    static int[] dy = {0, -1 , 1, 0};
    static int[][] map;
    static boolean[][] visited;
    static Taxi taxi;
    static Map<Integer, Position> destination;

    static class Position implements Comparable<Position>{
        int row, col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Position o) {  // 위쪽 행, 왼쪽 열 우선
            int result = this.row - o.row;
            if(result == 0) {
                return this.col - o.col;
            }
            return result;
        }
    }

    static class Taxi {
        int row, col, fuel;
        public Taxi(int row, int col, int fuel) {
            this.row = row;
            this.col = col;
            this.fuel = fuel;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());   // 승객 수
        int fuel = Integer.parseInt(st.nextToken());    // 초기 연료
        map = new int[N + 1][N + 1];
        destination = new HashMap<>();  // 손님 번호를 키로 하는 목적지 맵

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());

        taxi = new Taxi(startR, startC, fuel);  // 택시의 현재 위치와 남아있는 연료

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pR = Integer.parseInt(st.nextToken());  // 손님 위치 행
            int pC = Integer.parseInt(st.nextToken());  // 손님 위치 열
            int dR = Integer.parseInt(st.nextToken());  // 목적지 행
            int dC = Integer.parseInt(st.nextToken());  // 목적지 열

            map[pR][pC] = i + 2;    // 손님 위치를 2번부터 시작해서 맵에 표시
            destination.put(i + 2, new Position(dR, dC));   // 손님 번호를 키로 하여 목적지 저장
        }

        int success = 1;
        int goal = 0;   // 이동시킨 손님 수
        while(success == 1) {   // 이전 손님을 목적지까지 이동 시켰다면
            visited = new boolean[N + 1][N + 1];
            int nowDest = operation(new Position(-1, -1)); // 가장 가까이에 있는 손님 찾기
            if(nowDest != -1) { // 가장 가까이에 손님이 있다면
                visited = new boolean[N + 1][N + 1];
                success = operation(destination.get(nowDest));    // 손님 번호로 목적지 설정
            }
            else {  // 택시가 갈 수 있는 위치에 손님이 없는데
                if(goal != M) { // 맵에 손님이 남아있다면
                    success = -1;
                    break;
                }
            }
            goal++; // 이동시킨 손님 수 증가
            if(goal == M) {
                break;
            }
        }

        if(success == 1) {   // 모든 손님을 목적지까지 이동시켰다면
            System.out.println(taxi.fuel);
        }
        else {
            System.out.println(-1);
        }

    }

    // 손님을 찾을 때 dest의 행열은 -1, 목적지로 이동 할 때 dest는 목적지의 위치
    private static int operation(Position dest) {
        LinkedList<Position> queue = new LinkedList<>();
        int taxiR = taxi.row;   // 택시의 현재 위치 받아오기
        int taxiC = taxi.col;
        int taxiF = taxi.fuel;

        queue.offer(new Position(taxiR, taxiC));
        visited[taxiR][taxiC] = true;

        int destR = dest.row;   // 목적지 위치
        int destC = dest.col;   // 손님을 찾을 때라면 -1이 저장되어있음

        while(!queue.isEmpty()) {
            int size = queue.size();
            if(destR == -1) {  // 손님을 찾는 상황이면
                Collections.sort(queue); // 같은 거리에 있는 손님 중 위쪽, 왼쪽 손님이 우선이므로 정렬
            }
            if(taxiF < 0) { // 연료가 없다면 false 리턴
                return -1;
            }
            while(--size >= 0) {
                Position curPos = queue.poll();
                int curR = curPos.row;
                int curC = curPos.col;

                if(destR == -1 && map[curR][curC] > 1) {   // 손님을 찾는 중이고 현재 위치가 손님이 있는 위치라면
                    taxi.row = curR;    // 택시 위치 설정
                    taxi.col = curC;
                    taxi.fuel = taxiF;  // 손님위치까지 이동한만큼 연료 감소
                    int passenger = map[curR][curC];    // 손님번호 저장
                    map[curR][curC] = 0;    // 손님 탑승했으니 현재 위치를 0으로 변환
                    return passenger; // 손님 번호 리턴
                }

                else if(curR == destR && curC == destC) {   // 현재 위치가 목적지라면
                    taxi.row = curR;    // 택시 위치 설정
                    taxi.col = curC;
                    int reward = (taxi.fuel - taxiF) * 2;   // 보상 연료 계산
                    taxi.fuel = taxiF;  // 남아있는 연료 저장
                    taxi.fuel += reward; // 남아있는 연료 + 보상 연료
                    return 1;
                }
                for(int i = 0; i < dx.length; i++) {
                    int nr = curR + dx[i];
                    int nc = curC + dy[i];
                    if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 1) {
                        queue.offer(new Position(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
            taxiF--;    // 연료감소
        }
        return -1;
    }

    private static boolean isIn(int nr, int nc) {
        return nr > 0 && nr <= N && nc > 0 && nc <= N;
    }
}
