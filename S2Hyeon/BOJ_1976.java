import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_1976 여행 가자
public class BOJ_1976 {

    static int N, M, start, end, visitedCnt;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        Queue<Integer> plan = new ArrayDeque<>();

        StringTokenizer st;

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i == j)  // 같은 도시를 방문 할 수 있다.
                    map[i][j] = 1;
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            plan.offer(Integer.parseInt(st.nextToken()));   // 여행 계획을 큐에 담는다.
        }

        start = plan.poll();    // 첫 시작점
        end = plan.poll();      // 다음에 방문할 도시

        for(int i = 0; i < M; i++) {
            visited = new boolean[N + 1];   // bfs를 돌때마다 방문표시 배열 초기화
            if(bfs() && !plan.isEmpty()) {  // 방문할 도시를 찾았고 여행계획이 비어있지 않다면
                start = end;    // 시작점을 방문한 도시로 갱신
                end = plan.poll();  // 다음 방문할 도시를 여행계획 큐에서 꺼내온다.
            }
            else {  // 방문할 도시를 못찾았거나 여행계획이 비어있다면
                break;
            }
        }

        if(visitedCnt == M - 1) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    private static boolean bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int ad = 1; ad <= N; ad++) {
                if(map[cur][ad] == 1 && !visited[ad]) {
                    if(ad == end) { // 다음에 방문할 도시를 찾았다면
                        visitedCnt++;   // 방문카운트 증가
                        return true;    // 성공 표시
                    }
                    queue.offer(ad);
                    visited[ad] = true;
                }
            }
        }
        return false;
    }
}
