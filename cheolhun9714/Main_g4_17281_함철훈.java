package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_g4_17281_함철훈 {
	static int order[] = new int[9];
	static boolean isSelected[] = new boolean[9];
	static int N,answer=0;
	static int[][] act;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		act= new int[N][9];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9;j++) {
				act[i][j] = Integer.parseInt(st.nextToken()); //i 이닝에 j번째 player가 할 행동
			}
		}
		perm(0);
		System.out.println(answer);
	}

	private static void perm(int cnt) {
		if(cnt == 9) {
			Deque<Integer> queue = new ArrayDeque<Integer>();
			for(int i=0; i<9;i++) {
				queue.offer(order[i]);
			}
			int out =0,score =0;
			ArrayList<Integer> player_position = new ArrayList<>(); // 진루한 player의 위치 저장
			for(int inning=0; inning<N; inning++) {
				while(out!=3) {
					int player = queue.poll();
					int acting = act[inning][player];
					if(acting==0) {
						out++;
					}else if(acting==4) {
						score+=player_position.size()+1;
						player_position.clear();
					}else {
						for(int i=0; i<player_position.size();i++) {
							if(player_position.get(i)+acting>3) {
								score++;
								player_position.remove(i--);
							}else	player_position.set(i, player_position.get(i)+acting);
						}
						player_position.add(acting);
					}
					queue.offer(player);
				}
				player_position.clear();
				out =0;
			}
			if(answer<score)	answer = score;
			
			
			return;
		}
		for(int i=1; i<9; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				order[cnt] = i;
				if(cnt==2) {
					perm(cnt+2);
				}else {
					perm(cnt+1);
				}
				isSelected[i]=false;
			}
		}
	}
}