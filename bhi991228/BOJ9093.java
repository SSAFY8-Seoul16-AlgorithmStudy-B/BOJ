import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ9093 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String strBase;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreElements()) {
				strBase = st.nextToken();
				for (int j = strBase.length()-1; j >= 0; j--) {
					bw.write(strBase.charAt(j));
				}
				bw.write(" ");
			}
			bw.write("\n");
			bw.flush();
		}
	}

}
