import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int prev = Integer.parseInt(st.nextToken());
		int ans = prev;
		
		for (int i = 1; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			prev = Math.max(now, prev + now);
			ans = Math.max(prev, ans);
		}
		System.out.println(ans);
		
		
	}

}
