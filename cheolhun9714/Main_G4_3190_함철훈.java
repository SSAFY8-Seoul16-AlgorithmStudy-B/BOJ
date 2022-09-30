package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_G4_3190_함철훈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		//우, 하,좌,상 순으로 d가 입력될 시 idx++, l이 입력될시 idx--
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		
		int map[][] = new int[N][N];
		map[0][0] = 2;//뱀의 위치는 2로 저장
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offerFirst(new int[] {0,0});//첫 뱀의 위치 저장
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//사과의 위치는 1로 저장
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		int t =0;//현재시간-1
		int finish_time=0;
		int L = Integer.parseInt(br.readLine());
		int dir =0;//방향은 오른쪽 부터 시작
		for(int i=0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());//언제까지 그 방향으로 갈 것인지 받음
			if(finish_time ==0) {//뱀이 죽지 않은 경우
				for(int j=t+1; j<=time;j++) {// 현재 시간~time까지 이동
					int[] current = queue.peek();//뱀의 머리위치 확인
					//뱀의 머리 위치와 바라보는 방향을 통해 다음 위치 계산
					int nr = current[0] +dr[dir];
					int nc = current[1] +dc[dir];
					
					if(nr<0 || nc<0 || nr>N-1 || nc>N-1 || map[nr][nc] == 2) {//끝나는 경우
						finish_time = j;//종료 시간 저장
						break;//탈출
					}else if(map[nr][nc]==0){//빈 공간인 경우
						int[] delete = queue.pollLast();//꼬리 부분
						map[delete[0]][delete[1]] = 0;//이 사라지고
						queue.offerFirst(new int[] {nr,nc});//머리 위치가 옮겨짐
						map[nr][nc] = 2;
					}else {//사과가 있는 경우
						queue.offerFirst(new int[] {nr,nc});//꼬리는 그대로 존재하고 길이가 늘어나 머리 위치가 옮겨짐
						map[nr][nc] = 2;
					}
				}
				t=time;//현재까지의 시간 저장
			}
			//이동이 끝났으므로 방향 전환
			if(st.nextToken().equals("D")){//d일 경우 
				if(dir!=3) {
					dir+=1;					
				}else {
					dir=0;
				}
			}else {//l일 경우
				if(dir!=0) {
					dir-=1;
				}else {
					dir=3;
				}
			}
		}
		while(finish_time==0) {//이동 명령을 다 수행했다면 게임이 끝날때까지 현재 저장된 방향으로 직진함.
								//게임이 종료되었다면 해당 loop 돌지 않음
			t++;//한칸 전진시 마다 time증가
			//위와 동일
			int[] current = queue.peek();
			int nr = current[0] +dr[dir];
			int nc = current[1] +dc[dir];
			if(nr<0 || nc<0 || nr>N-1 || nc>N-1 || map[nr][nc] == 2) {
				finish_time = t; 
				break;
			}else if(map[nr][nc]==0){
				int[] delete = queue.pollLast();
				map[delete[0]][delete[1]] = 0;
				queue.offerFirst(new int[] {nr,nc});
				map[nr][nc] = 2;
			}else {
				queue.offerFirst(new int[] {nr,nc});
				map[nr][nc] = 2;
			}
		}
		System.out.println(finish_time);
		
	}
}
