import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(in.readLine());
		int[][] d = new int[n+1][3];
		for (int i = 1; i <= n; i++) {
			int s = Integer.valueOf(in.readLine());
			d[i][2] = d[i-1][1] + s;
			d[i][1] = d[i-1][0] + s;  
			d[i][0] = Math.max(d[i-1][1], d[i-1][2]);
		}
		System.out.print(Math.max(d[n][1], d[n][2]));
	}
		

		
	
}
