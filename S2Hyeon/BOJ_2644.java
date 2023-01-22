import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_2644 촌수 계산
public class BOJ_2644 {
    static int N, p1, p2, result;
    static boolean[][] adjMatrix;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        adjMatrix = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            adjMatrix[row][col] = true;
            adjMatrix[col][row] = true;
        }

        dfs(p1, 0);
        if(flag)
            System.out.println(result);
        else
            System.out.println(-1);
    }

    private static void dfs(int cur, int cnt) {
        if(cur == p2) {
            result = cnt;
            flag = true;
            return;
        }
        visited[cur] = true;

        for(int ad = 1; ad <= N; ad++) {
            if(!visited[ad] && adjMatrix[cur][ad] && !flag) {
                visited[ad] = true;
                dfs(ad, cnt + 1);
            }
        }
    }
}
