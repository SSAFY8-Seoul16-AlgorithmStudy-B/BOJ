import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_10971 외판원 순회 2
public class BOJ_10971 {

    static int N, startCity, min;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];    // 비용 행렬
        min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // N만큼 반복문 돌면서 시작점 별로 dfs
        for(int i = 0; i < N; i++) {
            visited = new boolean[N];   // N개의 도시 방문여부 배열
            startCity = i;
            dfs(i, 0, 1);
        }
        System.out.println(min);
    }
    // dfs
    private static void dfs(int curCity, int weight, int cityCnt) {
        if(cityCnt == N && map[curCity][startCity] != 0) {  // 모든 도시를 돌고 현재 도시에서 시작점 도시로 갈 수 있을 때
            weight += map[curCity][startCity];
            min = Math.min(min, weight);
            return;
        }
        if(weight >= min) return;   // 비용이 최소값을 넘으면 더이상 탐색할 필요 없음

        visited[curCity] = true;


        for(int ad = 0; ad < N; ad++) {
            if(!visited[ad] && map[curCity][ad] != 0) {
                dfs(ad, weight + map[curCity][ad], cityCnt + 1);
                visited[ad] = false;    // 탐색을 마치고 돌아오면 방문표시 해제
            }
        }
    }
}
