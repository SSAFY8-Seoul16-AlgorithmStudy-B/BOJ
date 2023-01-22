import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_15665 N과 M (11)
public class BOJ_15665 {
    static int N, M;
    static int[] inputs, numbers;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inputs = new int[N];
        numbers = new int[M];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs);
        perm(0);
        System.out.println(sb.toString());
    }

    private static void perm(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int temp = 0;
        for(int i = 0; i < N; i++) {
            if(inputs[i] == temp) continue;
            numbers[cnt] = inputs[i];
            temp = inputs[i];
            perm(cnt + 1);
        }
    }
}
