import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> deque = new LinkedList<Integer>();
		StringTokenizer st;
		int findIndex = 0, answer = 0;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			findIndex = deque.indexOf(Integer.parseInt(st.nextToken()));
			if (findIndex <= N-findIndex) {
				//앞으로 땡기는 횟수가 더 적을 때
				for (int j = 0; j < findIndex; j++) {
					deque.add(deque.poll());
				}
				deque.poll();
				answer += findIndex;
			}else {
				//뒤로 땡기는 횟수가 더 적을 때
				for (int j = 0; j < N-findIndex; j++) {
					deque.addFirst(deque.pollLast());
				}
				deque.poll();
				answer += N-findIndex;
			}
			
			N -= 1;
		}
		
		System.out.println(answer);
	}

}
