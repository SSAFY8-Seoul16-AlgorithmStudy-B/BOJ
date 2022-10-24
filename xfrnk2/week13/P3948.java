import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	static long[][] euler;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		euler = new long[21][21];

		euler[0][0] = 1;

		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(in.readLine());
			if (n == 1)
				System.out.println(1);
			else
				System.out.println(dfs(n, n) * 2);
			;
		}

	}

	public static long dfs(int n, int r) {

		if (r == 0) {
			return n == 0 ? 1 : 0;
		}
		if (euler[n][r] != 0)
			return euler[n][r];
		return euler[n][r] = dfs(n, r - 1) + dfs(n - 1, n - r);
	}

}
