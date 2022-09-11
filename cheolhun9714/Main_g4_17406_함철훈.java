package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_g4_17406_함철훈 {
	static int[][] map,temp_map[],rcs;
	static int N,M,K;
	static boolean[] isSelected;
	static int[] numbers;
	static int answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int r,c,s;
		map = new int[N][M];
		rcs = new int[K][3];
		isSelected = new boolean[K];
		numbers = new int[K];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i =0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			r= Integer.parseInt(st.nextToken())-1;
			c= Integer.parseInt(st.nextToken())-1;
			s= Integer.parseInt(st.nextToken());
			rcs[i] = new int[] {r,c,s};
		}
		perm(0);
		System.out.println(answer);
	}
	private static void perm(int cnt) {
		int temp_answer=0, temp_answer2=0;
		if(cnt == K) {
			for(int i=0;i<K;i++) {
				rotate(rcs[numbers[i]][0],rcs[numbers[i]][1],rcs[numbers[i]][2],i);
			}
			for(int i=0; i<M; i++) {
				temp_answer += temp_map[(K-1)%2][0][i];
			}
			for(int i=1; i<N; i++) {
				for(int j=0; j<M; j++) {
					temp_answer2 +=temp_map[(K-1)%2][i][j];
				}		
				if(temp_answer > temp_answer2) {
					temp_answer = temp_answer2;
				}
				temp_answer2=0;
			}
			
			if(temp_answer < answer) answer = temp_answer;
			return;
		}
		for(int i=0; i<K; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				numbers[cnt] = i;
				perm(cnt+1);
				isSelected[i] = false;
			}
		}
		
	}
	private static void rotate(int r, int c, int s, int times) {
		if(times==0) {
			temp_map = new int[2][N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					for(int k=1; k<=s;k++) {					
						if(i==r-k && j>=c-k&&j<c+k) {//위
							temp_map[0][i][j+1]=map[i][j];
						}else if(j==c+k && i>=r-k&&i<r+k) {//오른쪽
							temp_map[0][i+1][j]=map[i][j];
						}else if(i==r+k && j<=c+k&&j>c-k) {//아래
							temp_map[0][i][j-1]=map[i][j];
						}else if(j==c-k && i>r-k&&i<=r+k) {//왼쪽
							temp_map[0][i-1][j]=map[i][j];
						}
					}
					if(i<r-s||i>r+s||j>c+s||j<c-s||(j==c&&r==i)) temp_map[0][i][j] = map[i][j];
				}
			}
		}else {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					for(int k=1; k<=s;k++) {					
						if(i==r-k && j>=c-k&&j<c+k) {//위
							temp_map[times%2][i][j+1]=temp_map[(times-1)%2][i][j];
						}else if(j==c+k && i>=r-k&&i<r+k) {//오른쪽
							temp_map[times%2][i+1][j]=temp_map[(times-1)%2][i][j];
						}else if(i==r+k && j<=c+k&&j>c-k) {//아래
							temp_map[times%2][i][j-1]=temp_map[(times-1)%2][i][j];
						}else if(j==c-k && i>r-k&&i<=r+k) {//왼쪽
							temp_map[times%2][i-1][j]=temp_map[(times-1)%2][i][j];
						}
					}
					if(i<r-s||i>r+s||j>c+s||j<c-s||(j==c&&r==i)) temp_map[(times)%2][i][j] = temp_map[(times-1)%2][i][j];
				}
			}
		}
	}
}
