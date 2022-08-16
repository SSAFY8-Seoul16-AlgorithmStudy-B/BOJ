import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6603 {
	static int N, R = 6;
	static int[] arr;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				return;
			arr = new int[N];
			selected = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combination(0, 0);
			System.out.println();
		}

	}

	public static void combination(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
		for (int i = start; i < N; i++) {
			selected[i] = true;
			combination(cnt + 1, i + 1);
			selected[i] = false;
		}
	}

}
