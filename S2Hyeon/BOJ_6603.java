import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// BOJ_6603 로또
public class BOJ_6603 {
    static int N, R;
    static int[] numbers, inputs;
    static LinkedList<String> list;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String tc = br.readLine();
        R = 6;

        while(!tc.equals("0")) {
            st = new StringTokenizer(tc);
            N = Integer.parseInt(st.nextToken());
            numbers = new int[R];
            inputs = new int[N];
            list = new LinkedList<>();
            for(int i = 0 ; i < N; i++) {
                inputs[i] = Integer.parseInt(st.nextToken());
            }

            sb = new StringBuilder();
            comb(0, 0);
            System.out.println(sb);
            tc = br.readLine();
        }
    }

    private static void comb(int cnt, int r) {
        if(r == R) {
            for(int i = 0; i < R; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        if(cnt == N) return;

        numbers[r] = inputs[cnt];
        comb(cnt + 1, r + 1);
        comb(cnt + 1, r);
    }
}
