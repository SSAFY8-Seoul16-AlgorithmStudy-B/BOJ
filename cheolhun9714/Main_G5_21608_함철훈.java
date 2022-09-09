package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_21608_함철훈 {
	static int[] dr = {-1,0,0,1};//상좌우하
	static int[] dc = {0,-1,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> friend = new ArrayList<>();
		int[][] map = new int[N][N];
	
		for(int i=0; i<N*N+1; i++) {
			friend.add(new int[] {});
		}
		int[] order = new int[N*N];
		for(int i=0; i<N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			friend.set(now, new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			order[i] = now;
		}
		int answer=0;
		for(Integer student: order) {	
			int max=-1;
			int empty_max=-1;
			int r = 0;
			int c=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 0) {
						if(max ==-1) {
							r = i;
							c=j;
						}
						int count=0;
						int empty_count=0;
						for(int k=0; k<4;k++) {
							int nr = i+dr[k];
							int nc = j+dc[k];
							if(nr>=0 && nc>=0 && nr <N && nc<N ) {
								if(map[nr][nc]!=0) {									
									for(int l=0; l<4; l++) {
										if(friend.get(student)[l] ==map[nr][nc]) {
											count++;
										}
									}
								}else {
									empty_count++;
								}
							}
						}
						if(count>max) {
							max = count;
							r= i;
							c=j;
							empty_max = empty_count;
						}else if(count==max) {
							if(empty_max<empty_count) {
								r=i;
								c=j;
								empty_max=empty_count;
							}
						}
						if(max==0 && empty_max<empty_count) {
							empty_max = empty_count;
							r=i;
							c=j;
						}
						
					}
				}
			}
			map[r][c] = student;
		}
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N;j++) {
				int count =0 ;
				for(int k=0; k<4; k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					if(nr>=0 && nc>=0 && nr <N && nc<N) {
						for(int l=0; l<4; l++) {
							if(friend.get(map[i][j])[l]==map[nr][nc]) {
								count++;
							}
							
						}
					}
				}
				switch(count) {
				case 1:
					answer +=1;
					break;
				case 2:
					answer+=10;
					break;
				case 3:
					answer+=100;
					break;
				case 4:
					answer+=1000;
					break;
				default:
					break;
				}
			}
		}
		System.out.println(answer);
	}

}
