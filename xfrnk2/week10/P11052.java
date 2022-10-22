import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(in.readLine());		
		int[] d = new int[n+1];
		
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= n; i++) {
			int cur = Integer.valueOf(st.nextToken());
			d[i] = cur;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				d[i] = Math.max(d[i], d[i-j] + d[j]);

			}
		}
		System.out.println(d[n]);
		
		
		
	}

}