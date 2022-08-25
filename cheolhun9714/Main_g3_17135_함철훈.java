package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_g3_17135_함철훈 {
	static int N,M,D;
	static boolean[] bow;
	static ArrayList<int[]> enemy,enemy_temp;
	static ArrayList<int[]> target;
	static int[][] map;
	static int answer=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		bow = new boolean[M];
		map = new int[N][M];
		enemy = new ArrayList<>();
		target = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==1) enemy.add(new int[] {i,j});
			}
		}
		comb(0,0);
		System.out.println(answer);
	}
	static void comb(int cnt, int start) {
		if(cnt == 3) {
			int[][] temp_map = new int[N][M];
			enemy_temp = new ArrayList<>();
			for(int i=0;i<enemy.size();i++) {
				enemy_temp.add(enemy.get(i));
			}
			for(int i=0; i<N;i++) {
				for(int j=0; j<M; j++) {
					temp_map[i][j] = map[i][j];
				}
			}
			int kill=0;
			while(!enemy_temp.isEmpty()) {
				for(int i=0; i<M;i++) {
					if(bow[i]) {
						find_target(i);
					}
				}
				for(int i=0; i<target.size();i++) {
					int[] temp = target.get(i);
					if(temp_map[temp[0]][temp[1]]==1) {
						temp_map[temp[0]][temp[1]] =0;
						kill++;
					}
					for(int j=0; j<enemy_temp.size();j++) {
						if (enemy_temp.get(j)[0] == temp[0] && enemy_temp.get(j)[1]==temp[1])	{
							enemy_temp.remove(j);
							j--;
						}
					}
					target.remove(i);
					i--;
				}
				for(int i=0; i<enemy_temp.size();i++) {
					if(enemy_temp.get(i)[0]==N-1) {
						int[] temp = enemy_temp.get(i);
						temp_map[temp[0]][temp[1]] =0;
						enemy_temp.remove(i);
						i--;
					}else {
						int[] temp = enemy_temp.get(i);
						temp_map[temp[0]][temp[1]] =0;
						temp_map[temp[0]+1][temp[1]] =1;
						enemy_temp.set(i,new int[] {enemy_temp.get(i)[0]+1,enemy_temp.get(i)[1]});
					}
				}
			}
			if( kill> answer) answer = kill;
			
			return;
		}
		
		for(int i=start; i<M;i++) {
				bow[i]=true;
				comb(cnt+1,i+1);
				bow[i]=false;
		}
	}
	static void find_target(int pos) {
		int min[] = {0,0,M+N+1};
		boolean plus=false;
		for(int i=0; i<enemy_temp.size();i++) {
			if(N - enemy_temp.get(i)[0]+Math.abs(pos-enemy_temp.get(i)[1]) <= D){
				plus = true;
				if(N-enemy_temp.get(i)[0]+Math.abs(pos-enemy_temp.get(i)[1])<min[2]) {
					min[0] = enemy_temp.get(i)[0];
					min[1] = enemy_temp.get(i)[1];
					min[2] = N-enemy_temp.get(i)[0]+Math.abs(pos-enemy_temp.get(i)[1]);
				}else if(N-enemy_temp.get(i)[0]+Math.abs(pos-enemy_temp.get(i)[1])==min[2]) {
					min[0] = (min[1] >enemy_temp.get(i)[1]) ? enemy_temp.get(i)[0]:min[0];
					min[1] = (min[1] >enemy_temp.get(i)[1]) ? enemy_temp.get(i)[1]:min[1];
				}
			}
		}
		if(plus)	target.add(new int[] {min[0],min[1]});
	}
}
