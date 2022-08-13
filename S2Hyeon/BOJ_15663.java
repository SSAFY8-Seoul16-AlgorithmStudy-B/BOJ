import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// BOJ_15663 N과 M (9)
public class BOJ_15663 {
    static int N, M;
    static int[] inputs, numbers;
    static StringBuilder sb;
    static HashSet<String> set;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inputs = new int[N];
        numbers = new int[M];
        set = new HashSet<>();
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputs);
        perm(0, 0);

        System.out.print(sb.toString());
    }

    private static void perm(int cnt, int flag) {
        if(cnt == M) {
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < M; i++) {
                sb2.append(numbers[i]).append(" ");
            }
            if(!set.contains(sb2.toString())) {
                sb.append(sb2).append("\n");
                set.add(sb2.toString());
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if((flag & 1 << i) != 0) continue;
            numbers[cnt] = inputs[i];
            perm(cnt + 1, flag | 1 << i);
        }
    }
}
