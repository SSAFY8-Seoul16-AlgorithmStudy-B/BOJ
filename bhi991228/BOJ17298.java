import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		int[] answers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		int nowIdx, compIdx = 0;
		
		Arrays.fill(answers, -1);
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			stack.push(i);
		}
		//마지막은 어차피 -1
		stack.pop();
		
		while (!stack.isEmpty()) {
			nowIdx = stack.pop();
			compIdx = nowIdx+1;
			
			while (true) {
				if (numbers[nowIdx] < numbers[compIdx]) {	//현재 값보다 비교 값이 클 때
					answers[nowIdx] = compIdx;	//현재 값 위치의 정답은 비교 값(지금은 인덱스로 저장=>나중에 나오는 nowIdx가 따라갈 수도 있으니까)
					break;
				} else {
					if (answers[compIdx] != -1) {	//현재 값보다 비교 값은 작지만 대신 비교 값보다 큰게 그 오른쪽 수들 중에 있을 때
						compIdx = answers[compIdx];	//그 수가 현재 값보다 큰 지 작은 지 비교하기 위해 인덱스 가져옴
					} else {	//현재 값보다 비교 값이 작은데 그 다음 수들중에서도 비교 값보다 큰게 없을 때
						answers[nowIdx] = -1;	//오른쪽 수들중에 현재 값보다 큰 수가 없을 것이기 때문에 -1
						break;
					}
				}
			}
			
		}

		for (int i = 0; i < N; i++) {
			sb.append((answers[i] == -1 ? -1 : numbers[answers[i]]) + " ");
		}

		System.out.println(sb.toString());

//		Queue 사용했지만 시간 초과 ㅠㅠ
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int[] numbers = new int[N];
//		int[] answers = new int[N];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		Queue<Integer> queue = new LinkedList<Integer>();
//		int size, index;
//		Arrays.fill(answers, -1);
//		
//		for (int i = 0; i < N; i++) {
//			numbers[i] = Integer.parseInt(st.nextToken());
//			
//			if (!queue.isEmpty()) {
//				size = queue.size();
//				for (; size > 0; size--) {
//					index = queue.poll();
//					if (numbers[index] < numbers[i]) {
//						answers[index] = numbers[i];
//					}else {
//						queue.offer(index);
//					}
//				}
//			}
//			
//			queue.offer(i);
//		}
//		
//		for (int i = 0; i < N; i++) {
//			sb.append(answers[i] + " ");
//		}
//		
//		System.out.println(sb.toString());
	}
}
