package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_P5_17267_함철훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int[][] visited = new int[N][M];
		int answer=1;
		for(int i=0;i<N; i++) {
			for(int j=0;j<M; j++) {
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}			
		}
		Deque<int[]> queue = new ArrayDeque<int[]>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='2') {
					queue.offer(new int[] {i,j,0,0});
					visited[i][j] =0;
				}
			}
		}
		int[] current = queue.peek();
		for(int i=current[0]-1;i>=0;i--) {
			if(map[i][current[1]]!='1') {
				queue.offer(new int[] {i,current[1],0,0});
				visited[i][current[1]] =0;
				answer++;
			}else {
				break;
			}
		}
		for(int i=current[0]+1;i<N;i++ ) {
			if(map[i][current[1]]!='1') {
				queue.offer(new int[] {i,current[1],0,0});
				visited[i][current[1]] =0;
				answer++;
			}else {
				break;
			}
		}
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			if(current[2]<L) {				
				int nc = current[1]-1;
				if(nc>=0 && map[current[0]][nc]!='1' &&visited[current[0]][nc]>current[2]+current[3]+1) {
					for(int i=current[0];i>=0;i--) {
						if(map[i][nc]!='1') {
							queue.offer(new int[] {i,nc,current[2]+1,current[3]});
							visited[i][nc] = current[2]+current[3]+1;
							answer++;
						}else {
							break;
						}
					}
					for(int i=current[0]+1;i<N;i++ ) {
						if(map[i][nc]!='1') {
							queue.offer(new int[] {i,nc,current[2]+1,current[3]});
							visited[i][nc] =current[2]+current[3]+1;
							answer++;
						}else {
							break;
						}
					}
				}
			}
			if(current[3]<R) {				
				int nc =current[1]+1;
				if(nc<M && map[current[0]][nc]!='1' &&visited[current[0]][nc]>current[2]+current[3]+1) {
					for(int i=current[0];i>=0;i--) {
						if(map[i][nc]!='1') {
							queue.offer(new int[] {i,nc,current[2],current[3]+1});
							visited[i][nc] = current[2]+current[3]+1;
							answer++;
						}else {
							break;
						}
					}
					for(int i=current[0]+1;i<N;i++ ) {
						if(map[i][nc]!='1') {
							queue.offer(new int[] {i,nc,current[2],current[3]+1});
							visited[i][nc] =current[2]+current[3]+1;
							answer++;
						}else {
							break;
						}
					}
				}
			}
		}
		System.out.println(answer);
		
		
		
	}

}
