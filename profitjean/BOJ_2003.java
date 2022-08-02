package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수열개수
		int M = Integer.parseInt(st.nextToken()); // 합
		int[] arr = new int[N];
		int sum;
		int result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = i; j < N; j++) {
				sum += arr[j];
				if (sum == M) {
					result += 1;
					continue;
				} 
				if (sum > M) {
					continue;
				}
			}
		}
		System.out.println(result);
	}
}
