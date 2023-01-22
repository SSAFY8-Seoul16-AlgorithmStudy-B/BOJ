package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_g4_17298_함철훈 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] answer =new int[N];
		StringBuilder str = new StringBuilder();
		Stack<int[]> stack = new Stack<>();
		st = new StringTokenizer(br.readLine());
		stack.push(new int[] {0,Integer.parseInt(st.nextToken())});
		for(int i=1; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			for(int j=0; j< stack.size();j++) {
				if(stack.peek()[1]<input) {
					int[] add = stack.pop();
					j--;
					answer[add[0]]= input;
				}else break;
			}
			stack.push(new int[] {i, input});
		}
		for (int i=0; i<N; i++) {
			str.append((answer[i]==0? -1:answer[i] )).append(" ");
		}
		System.out.println(str);
	}
}
