package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G4_4485_함철훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt=1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}				
			}
			int[] d = new int[N*N];
			Arrays.fill(d, Integer.MAX_VALUE);
			d[0] = map[0][0];
			d[1] = map[0][1];
			d[N] = map[1][0];
			boolean[] visited= new boolean[N*N];
			visited[0] = true;
			while(true) {	
				int min = Integer.MAX_VALUE;
				int min_index = -1;
				for(int i=1; i<N*N;i++) {
					if(d[i] < min && !visited[i]) {
						min = d[i];
						min_index = i;
					}
				}
				if(min_index==N*N-1 || min_index == -1) break;
				visited[min_index]= true;
				if(min_index >= N && !visited[min_index-N]) {//첫행이 아니라면 위의 줄 확인
					if(d[min_index-N]> d[min_index]+map[(min_index-N)/N][(min_index-N)%N]) {
						d[min_index-N] = d[min_index]+map[(min_index-N)/N][(min_index-N)%N];
					}
				}
				if(min_index%N != 0 && !visited[min_index-1]) {//1열이 아니라면 왼쪽 확인
					if(d[min_index-1]> d[min_index]+map[(min_index-1)/N][(min_index-1)%N]) {
						d[min_index-1] = d[min_index]+map[(min_index-1)/N][(min_index-1)%N];
					}
				}
				if(min_index+N < N*N && !visited[min_index+N]) {//마지막행이 아니라면 아래확인
					if(d[min_index+N]> d[min_index]+map[(min_index+N)/N][(min_index+N)%N]) {
						d[min_index+N] = d[min_index]+map[(min_index+N)/N][(min_index+N)%N];
					}
				}
				if(min_index%N != N-1 && !visited[min_index+1]) {//마지막 열이 아니라면 오른쪽 확인
					if(d[min_index+1]> d[min_index]+map[(min_index+1)/N][(min_index+1)%N]) {
						d[min_index+1] = d[min_index]+map[(min_index+1)/N][(min_index+1)%N];
					}
				}
			}
			System.out.println("Problem "+ cnt+ ": " +(d[N*N-1]+d[0]));
			cnt++;
		}
	}

}
