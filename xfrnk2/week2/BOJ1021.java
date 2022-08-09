import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = sc.nextInt();
		}
		solution(n, m, arr);
	}

	public static void solution(int n, int m, int[] arr) {
		Queue<Integer> queue = new LinkedList<>();
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		for (int target : arr) {

			int cnt = 0;
			while (target != queue.peek()) {
				queue.offer(queue.poll());
				cnt++;
			}
			answer += Math.min(cnt, queue.size() - cnt);
			queue.poll();
		}
		System.out.println(answer);

	}
}
