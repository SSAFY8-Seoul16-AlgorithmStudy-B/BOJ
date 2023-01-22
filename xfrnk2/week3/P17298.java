package boj.p17k.p17200;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P17298 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<int []> stack = new Stack<int []>();
		int[] answer = new int[N];
		Arrays.fill(answer, -1);
		for (int idx = 0; idx < N; idx++) {
			
			int cur = sc.nextInt();
			if (stack.isEmpty()) {
				stack.push(new int[] {cur, idx});
				continue;
				}
			if (stack.peek()[0] >= cur) { // 현재 number가 peek보다 작거나 같을때
				stack.push(new int[] {cur, idx});
			} else { // 현재 number가 peek보다 클 때
				Stack<int[]> temp = new Stack<int[]>();
				while (!stack.isEmpty()) {
					
					int[] top = stack.pop();
					if (top[0] < cur) {
						answer[top[1]] = cur;
					} 
					else {
						stack.push(top);
						break;
					}
				}
				stack.push(new int[] {cur, idx});
				
			}
			
			}
		StringBuilder sb = new StringBuilder();
		for (int elem : answer) {
			sb.append(elem).append(" ");
		}
		System.out.print(sb);

		}
		
		
		
	

}

/*
자바의 우선순위 큐. java.util.PriorityQueue
new PriorityQueue<>();
*/