package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_s2_2644_함철훈 {
	static boolean[][] siblings;
	static boolean[] isSelected;
	static int[] find;
	static int n,answer=-1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r,c;
		n = Integer.parseInt(st.nextToken());
		siblings = new boolean[n+1][n+1];
		isSelected = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		find = new int[2];
		for (int i = 0; i < 2; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int number = Integer.parseInt(st.nextToken());
		for (int i=0; i<number; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			siblings[r][c] = true;
			siblings[c][r] = true;
		}
		dfs();
		System.out.println(answer);
		
	}
	static void dfs() {
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] {find[0],-1});
		int[] now;
		while(!stack.empty()) {
			now = stack.pop();
			if(now[0] == find[1]) {
				answer = now[1]+1;
				break;
			}
			isSelected[now[0]] = true;
			for(int i=1; i<n+1; i++) {
				if(siblings[now[0]][i]&&!isSelected[i]) {
					stack.push(new int[] {i,now[1]+1});
				}
			}
		}
	}
}
