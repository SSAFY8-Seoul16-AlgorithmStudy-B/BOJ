import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		solution(n, k, arr);

	}

	public static void solution(int n, int k, int[] arr) {

		int sum = 0;
		int mx = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];

			if (i == k - 1)
				mx = sum; // 윈도우의 크기가 만족되었을 때 최댓값 초기화
			if (i >= k) { // 윈도우의 크기를 넘어서는 경우
				sum -= arr[i - k];
				mx = Math.max(mx, sum);
			}
		}
		System.out.print(mx);
	}
}