package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1080_함철훈 {
	//본인 포함 팔방을 뒤집기 위함
	static int[] dr= {-1,-1,-1,0,0,1,1,1,0};
	static int[] dc= {-1,0,1,-1,1,-1,0,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean calc = true;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if(N<3 || M<3) calc =false; // 행렬 사이즈가 3*3보다 작다면 calc 안돌려요
		int map_a[][] = new int[N][M];
		int map_b[][] = new int[N][M];
		//행렬 A생성
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map_a[i][j] = str.charAt(j)-'0';
			}
		}
		//행렬 B 생성
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map_b[i][j] = str.charAt(j)-'0';
			}
		}
		int cnt=0;
		if(calc) {//행렬의 크기가 3x3이상일 경우
			for(int i=1; i<N-1;i++) {//행->렬 순으로 값이 다르다면 3x3 부분행렬을 뒤집어줌
				for(int j=1; j<M-1; j++) {
					if(map_a[i-1][j-1] !=map_b[i-1][j-1]) {
						for(int k=0; k<9;k++) {
							//0->1    1->0
							map_a[i+dr[k]][j+dc[k]]=Math.abs(map_a[i+dr[k]][j+dc[k]]-1);
						}
						cnt++;
					}
				}
			}
		}else {//행렬의 크기가 3x3보다 작을 경우
			for(int i=0; i<N;i++) {
				for(int j=0; j<M; j++) {
					if(map_a[i][j]!=map_b[i][j]) cnt=-1; //하나라도 다른 값이 있다면 같아질 수 없음
				}
			}
		}
		loop1:
		for(int i=0; i<N; i++) {
			for(int j=0; j<M;j++) {
				if(map_a[i][j] != map_b[i][j]) {//a와 b의 행렬이 다른경우
					cnt=-1; //-1출력
					break loop1;
				}
			}
		}
		System.out.println(cnt);
	}

}
