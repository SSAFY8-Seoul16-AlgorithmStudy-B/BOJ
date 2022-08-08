package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1021 {
	// 1. 첫번째 원소 뽑기 poll
		// 2. 왼쪽으로 이동 -> 뒤에 붙이기 , poll한거 offer
		// 3. 오른쪽으로 이동 -> 맨뒤꺼 꺼내서 앞으로
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int ans = 0;
			int[] check = new int[M];
			Deque<Integer> dq = new ArrayDeque<>();
			// first는 왼쪽 last는 오른쪽으로

			for (int i = 1; i <= N; i++) {
				dq.offerLast(i);
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				check[i] = Integer.parseInt(st.nextToken());
				int count = 0;
				// top이 check[i] 될때까지
				while (dq.peek()!=check[i]) {
					dq.offerLast(dq.poll());
					count ++;
				}
				// 왼쪽으로 빼는거랑 오른쪽으로 빼는거 비교하기 
				ans += Math.min(count, dq.size()-count);
				dq.poll(); // 탐색끝냈으니 아웃
			}
			System.out.println(ans);

		}
}
