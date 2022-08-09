import java.io.*;
import java.util.ArrayList;

public class BOJ_11729 {
    //BOJ_11729 하노이 탑 이동 순서

    static int cnt;
    static ArrayList<String> process;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        process = new ArrayList<>();
        hanoi(N, 1, 2, 3);
        bw.write(cnt + "\n");
        bw.flush();
        for(int i = 0 ; i < process.size(); i++)
            bw.write(process.get(i) + "\n");
        bw.flush();
    }

    private static void hanoi(int n, int from, int temp, int to) {
        if(n == 0)
            return;
        hanoi(n - 1, from, to, temp);
        cnt++;
        process.add(from + " " + to);
        hanoi(n - 1, temp, from, to);
    }
}
