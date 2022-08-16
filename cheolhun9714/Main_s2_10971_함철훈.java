package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_s2_10971_함철훈 {
	static int[][] W;
	static int N, price=0,min=Integer.MAX_VALUE;
	static boolean[] visited;
	static int[] answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = new int[N][N];
		visited =new boolean[N];
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = new int[N];
		dfs(0);
		System.out.println(min);
	}
	static void dfs(int cnt) {
		if(cnt == N){
			for(int i=0; i<N-1;i++) {
				if(W[answer[i]][answer[i+1]]==0)	{
					price=0;
					return;
				}
				price+=W[answer[i]][answer[i+1]];//				
			}
			if(W[answer[N-1]][answer[0]]==0)	return;
			price+=W[answer[N-1]][answer[0]];
			if(price<min)	{
				min = price;
			}
			price =0;
			return;
		}
		if(price> min) {
			return;
		}
		for(int i=0; i<N;i++ ) {
			if(!visited[i]) {
				visited[i] =true;
				answer[cnt] = i;
				dfs(cnt+1);
				visited[i] = false;
			}
		}
	}
}
