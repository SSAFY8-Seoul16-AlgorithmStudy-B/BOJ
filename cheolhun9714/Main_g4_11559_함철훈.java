package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_g4_11559_함철훈 {

	static ArrayList<int[]> arr= new ArrayList<int[]>();
	static char[][] map = new char[12][6];
	static boolean[][] isSelected = new boolean[12][6];
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean finish, need_move;
	static int answer =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i=0;i<12;i++) {
			String str = sc.nextLine();
			for (int j=0;j<6;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		while(!finish) {
			for(int i=0; i<12;i++) {		
				for (int j=0;j<6;j++) {
					if(map[i][j]!='.')	arr.add(new int[]{i,j});
				}
			}
			while(!arr.isEmpty()) {
				if(isSelected[arr.get(0)[0]][arr.get(0)[1]])	arr.remove(0);
				else	puyo(arr.get(0)[0],arr.get(0)[1]);
			}
			isSelected = new boolean[12][6];
			finish=true;
			move();
		}
		System.out.println(answer);
		
	}
	
	static void puyo(int r, int c) {
		int count=0;
		ArrayList<int[]> arr_to_remove= new ArrayList<int[]>();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r,c});
		arr_to_remove.add(new int[] {r,c});
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0; i<size;i++) {
				int[] now = queue.poll();
				count++;
				isSelected[now[0]][now[1]]=true;
				for(int j=0; j<4; j++) {
					int nr = now[0]+dr[j];
					int nc = now[1]+dc[j];
					if(nr >=0&& nr <12 && nc >=0&& nc< 6&& map[nr][nc]==map[r][c]&&!isSelected[nr][nc]) {
						queue.add(new int[] {nr,nc});
						arr_to_remove.add(new int[] {nr,nc});
					}
				}
			}
		}
		if(count>=4) {
			for(int i=0; i< arr_to_remove.size(); i++) {
				map[arr_to_remove.get(i)[0]][arr_to_remove.get(i)[1]] = '.';
				need_move=true;
			}
			arr_to_remove.clear();
		}
	}
	static void move() {
		for(int j=0; j<6;j++) {
			for(int i=11; i>0; i--) {
				if(map[i][j]=='.'&&map[i-1][j]!='.') {
					map[i][j] = map[i-1][j];
					map[i-1][j] = '.';
					finish = false;
					if(i!=11) {
						i+=2; 
						continue;
					}
				}
			}
		}
		if(need_move) {
			answer++;
			need_move = false;
		}
	}
}
