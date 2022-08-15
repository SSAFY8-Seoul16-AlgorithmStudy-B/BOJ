import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_1697 숨바꼭질
public class BOJ_1697 {
    static int N, K, second;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001 * 2];

        bfs(N);
        System.out.println(second);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (--size >= 0) {
                int cur = queue.poll();
                if (cur == K) {
                    return;
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    queue.offer(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur + 1 < visited.length && !visited[cur + 1]) {
                    queue.offer(cur + 1);
                    visited[cur + 1] = true;
                }
                if (cur * 2 < visited.length && !visited[cur * 2]) {
                    queue.offer(cur * 2);
                    visited[cur * 2] = true;
                }
            }
            second++;
        }
    }
}
