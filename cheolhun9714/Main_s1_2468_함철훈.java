package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_s1_2468_함철훈 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] isSelected;
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int count=0, max_height =0,max=0;
		map = new int[N][N];
		isSelected = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>max)	max = map[i][j];
			}			
		}
		for(int height=0; height<max; height++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>height && !isSelected[i][j]) {
						isSelected[i][j] =true;
						bfs(i, j, height);
						count++;
					}
				}
			}
			if (count > max_height)	max_height=count;
			count=0;
			for(int i=0;i<N;i++) {
				Arrays.fill(isSelected[i], false);
			}
		}
		System.out.println(max_height);
		
	}
	static void bfs(int r,int c,int height ) {
		for(int i=0; i<4; i++) {
			int nr = dr[i]+r;
			int nc = dc[i]+c;
			if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc]>height&&!isSelected[nr][nc]) {
				isSelected[nr][nc]=true;
				bfs(nr,nc,height);
			}
		}
	}
}
