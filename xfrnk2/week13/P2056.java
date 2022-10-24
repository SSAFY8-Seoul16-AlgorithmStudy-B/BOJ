import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] indegrees = new int[N + 1];
		List<Integer>[] edges = new ArrayList[N + 1];
		int[] times = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			int time = Integer.parseInt(st.nextToken());
			times[i] = time;

			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int need = Integer.parseInt(st.nextToken());

				edges[need].add(i);
				indegrees[i]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (indegrees[i] == 0) {
				queue.offer(i);
			}
		}

		int ans = 0;
		int[] result = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			result[i] = times[i];
		}

		while (!queue.isEmpty()) {
			Integer now = queue.poll();


			for (int i = 0; i < edges[now].size(); i++) {
				int nxt = edges[now].get(i);
				result[nxt] = Math.max(result[nxt], result[now] + times[nxt]);
				indegrees[nxt]--;
				if (indegrees[nxt] == 0)
					queue.offer(nxt);
			}
		}

		for (int i = 1; i < N + 1; i++) {
			ans = Math.max(result[i], ans);
		}
		System.out.println(ans);

	}

}
