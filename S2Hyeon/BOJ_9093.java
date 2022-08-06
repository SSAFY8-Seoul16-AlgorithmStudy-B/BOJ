import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9093 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                for(int j = str.length() - 1; j >= 0; j--) {
                    bw.write(str.charAt(j));
                }
                bw.write(" ");
            }
            bw.write("\n");
            bw.flush();
        }
    }
}
