import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1021 {
    // BOJ_1021 회전하는 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }
        for(int i = 0; i < M; i++) {
            int mid = q.size() / 2;
            int target = Integer.parseInt(st.nextToken());
            int targetIndex = q.indexOf(target);
            if(mid >= targetIndex) {
                while(q.get(0) != target) {
                    q.offer(q.poll());
                    cnt++;
                }
            }
            else {
                while(q.get(0) != target) {
                    q.offerFirst(q.pollLast());
                    cnt++;
                }
            }
            q.poll();
        }
        System.out.println(cnt);
    }
}
