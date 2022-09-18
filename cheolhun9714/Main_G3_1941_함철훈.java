package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_G3_1941_함철훈 {
	static int answer;
	static int[] parents=new int[7];
	//서로소 집합 생성
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	static ArrayList<Integer> Yseat =new ArrayList<>();
	static ArrayList<Integer> Sseat =new ArrayList<>();
	static int[] selected_y, selected_s, selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[5][5];
		for(int i=0; i<5; i++){
			String str = br.readLine();
			for(int j=0; j<5; j++) {				
				map[i][j] = str.charAt(j);
				if(map[i][j] =='Y') {
					Yseat.add(5*i+j);//임도연 파인 사람의 위치 저장
				}else {
					Sseat.add(5*i+j);//이다솜 파인 사람의 위치 저장
				}
			}
		}
		answer =0;
		selected = new int[7];//최종 선택한 7명의 위치를 저장하는 배열 생성
		if(Sseat.size() >=7) { // 이다솜 파인 사람이 7명 이상인 경우
			for(int i=4; i<=7;i++) {// 그 중 4명~7명을 선택하는 부분
				selected_s = new int[i];
				selected_y = new int[7-i];
				comb_y(0,0,7-i);//임도연 파 3명~0명 선택
			}
		}else if(Sseat.size()>=4){// 이다솜 파인 사람이 4~6명인 경우
			for(int i=4; i<=Sseat.size();i++) {// 그 중 4명~전체를 선택하는 부분
				selected_s = new int[i];
				selected_y = new int[7-i];
				comb_y(0,0,7-i);//임도연 파 3명~0명 선택
			}
		}
		System.out.println(answer);
		
	}
	// 임도연 파인 사람들 선택하는 함수
	private static void comb_y(int start, int cnt, int y) {
		if(cnt==y) {//
			for(int i=0; i<y; i++) {// 임도연파 y명을 최종 선택에 추가
				selected[i] = Yseat.get(selected_y[i]);
			}
			comb_s(0,0,7-y);//임도연파 y명이므로 이다솜파 7-y명을 뽑는 함수
			return;
		}
		
		for(int i=start; i<Yseat.size();i++) {
			selected_y[cnt]=i;
			comb_y(i+1,cnt+1,y);
		}
	}

	//이다솜파인 사람들 선택하는 함수
	private static void comb_s(int start, int cnt, int s) {
		if(cnt==s) {
			for(int i=0; i<s;i++) {//이다솜파 s명을 최종 선택에 추가
				selected[6-i]=Sseat.get(selected_s[i]);
			}
			for(int i=0; i<7;i++) {//서로소 집합 생성
				parents[i] = i;
			}
			int count=0;
			for(int i=0; i<7; i++) {// 옆, 앞, 뒤로 이어져 있는지 확인
				for(int j=i+1; j<7;j++) {
					int i_r = selected[i]/5;
					int i_c = selected[i]%5;
					int j_r = selected[j]/5;
					int j_c = selected[j]%5;
					if(Math.abs(i_r-j_r)+Math.abs(i_c-j_c)==1) {//맨허튼 거리가 1인 경우
						if(union(i,j)) count++;	//union하고, 연결되어 있지 않았다면 count 증가					
					}
				}
			}
			if(count==6) { // 7명이 인접해 있다면
				answer++;//정답
			}
			
			return;
		}
		
		for(int i=start; i<Sseat.size();i++) {
			selected_s[cnt]=i;
			comb_s(i+1,cnt+1,s);
		}
		
	}

}
