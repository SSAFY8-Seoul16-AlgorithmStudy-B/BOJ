package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_P5_23289_함철훈 {
	static int[] dr= {0,0,0,-1,1};//우좌상하
	static int[] dc ={0,1,-1,0,0};
	static int R,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int[][] wall = new int[R+1][C+1];
		ArrayList<int[]> check_list = new ArrayList<>();
		ArrayList<int[]> heaters = new ArrayList<>();
		for(int i=0; i<R; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				int num= Integer.parseInt(st.nextToken());
				if(num==5) {
					check_list.add(new int[] {i,j});
				}else if(num!=0) {
					heaters.add(new int[] {i,j,num});
				}
			}			
		}
		int W = Integer.parseInt(br.readLine());
		for(int i=0; i<W; i++) {
			st = new StringTokenizer(br.readLine());
			wall[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]+=(Integer.parseInt(st.nextToken())+1);
		}
		boolean finish = false;
		int choco = 0;
		Deque<int[]> queue = new ArrayDeque<int[]>();
		while(!finish) {
			//바람 나옴
			for(int[] heater:heaters) {
				boolean[][] visited = new boolean[R][C];
				int nr = heater[0]+dr[heater[2]];
				int nc = heater[1]+dc[heater[2]];
				map[nr][nc]+=5;
				visited[nr][nc]=true;
				queue.offer(new int[] {nr,nc,4});
				switch(heater[2]) {
				case 1://오른쪽
					while(!queue.isEmpty()) {
						int[] current = queue.poll();
						nr = current[0]-1;
						nc = current[1]+1;
						boolean pass=false;
						if(isin(nr,nc)) {
							if(wall[current[0]][current[1]]==1 ||wall[current[0]][current[1]]==3  || wall[nr][current[1]]>=2) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {									
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
						nr++;
						pass=false;
						if(isin(nr,nc)) {
							if(wall[current[0]][current[1]]>=2) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {									
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
						nr++;
						pass=false;
						if(isin(nr,nc)) {
							if(wall[nr][current[1]]!=0) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {									
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
					}
					break;
					//x,y과 x-1,y 사이에 벽 t=0 x,y와 x,y+1 사이에 벽 t=1 

				case 2://왼쪽
					while(!queue.isEmpty()) {
						int[] current = queue.poll();
						nr = current[0]-1;
						nc = current[1]-1;
						boolean pass=false;
						if(isin(nr,nc)) {
							if(wall[current[0]][current[1]]==1 || wall[nr][nc]>=2||wall[current[0]][current[1]]==3) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {									
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
						nr++;
						pass=false;
						if(isin(nr,nc)) {
							if(wall[nr][nc]>=2) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {											
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
						nr++;
						pass=false;
						if(isin(nr,nc)) {
							if(wall[nr][current[1]]==1||wall[nr][current[1]]==3 || wall[nr][nc]>=2) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {									
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
					}
					break;
				case 3://위
					while(!queue.isEmpty()) {
						int[] current = queue.poll();
						nr = current[0]-1;
						nc = current[1]-1;
						boolean pass=false;
						if(isin(nr,nc)) {
							if(wall[current[0]][nc]!=0) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {									
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
						nc++;
						pass=false;
						if(isin(nr,nc)) {
							if(wall[current[0]][nc]==1||wall[current[0]][nc]==3) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {										
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
						nc++;
						pass=false;
						if(isin(nr,nc)) {
							if(wall[current[0]][nc]==1||wall[current[0]][nc]==3 || wall[current[0]][current[1]]>=2) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {										
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
					}
					break;
				case 4://아래
					while(!queue.isEmpty()) {
						int[] current = queue.poll();
						nr = current[0]+1;
						nc = current[1]-1;
						boolean pass=false;
						if(isin(nr,nc)) {
							if(wall[nr][nc]==1 ||wall[nr][nc]==3 || wall[current[0]][nc]>=2) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {								
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
						nc++;
						pass=false;
						if(isin(nr,nc)) {
							if(wall[nr][nc]==1||wall[nr][nc]==3) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {							
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
						nc++;
						pass=false;
						if(isin(nr,nc)) {
							if(wall[nr][nc]==1||wall[nr][nc]==3 || wall[current[0]][current[1]]>=2) {
								pass = true;
							}
							
							if(!pass) {
								if(current[2]!=1 && !visited[nr][nc]) {									
									queue.offer(new int[] {nr,nc,current[2]-1});
								}
								if(!visited[nr][nc]) {									
									map[nr][nc]+=current[2];
									visited[nr][nc]=true;
								}
							}
						}
					}
					break;
				default:
					break;
				}
				
//				for(int i=0; i<R; i++) {
//					System.out.println(Arrays.toString(map[i]));
//				}
//				System.out.println();
			}
			
			//온도조절
			int[][] temp_map = new int[R][C];
			for(int i=0; i<R;i++) {
				for(int j=0; j<C;j++) {
					int minus=0;
					for(int d=1; d<=4;d++) {//우좌상하
						int nr = i+dr[d];
						int nc = j+dc[d];
						boolean pass=false;
						if(nr>=0 && nc>=0 &&nr<R && nc<C) {
							switch(d) {
							case 1:
								if(wall[i][j]>=2) {
									pass = true;
								}
								break;
							case 2:
								if(wall[nr][nc]>=2) {
									pass = true;
								}
								break;
							case 3:
								if(wall[i][j]==1||wall[i][j]==3) {
									pass = true;
								}
								break;
							case 4:
								if(wall[nr][nc]==1||wall[nr][nc]==3) {
									pass = true;
								}
								break;
							default:
								break;
							}
							if(!pass) {								
								if(map[i][j]>map[nr][nc]) {
									temp_map[nr][nc]+=(map[i][j]-map[nr][nc])/4;
									minus+=(map[i][j]-map[nr][nc])/4;
								}
							}
						}
					}
					temp_map[i][j] += map[i][j]-minus;
				}
			}
			//////온도가 1 이상인 가장 바깥쪽 칸의 온도 감소//////////////
			for(int i=0; i<R;i++) {
				for(int j=0; j<C;j++) {
					map[i][j] = temp_map[i][j];
					if(temp_map[i][j]>=1 && (i==0 || j==0 || i==R-1|| j==C-1)) {
						map[i][j]--;
					}
				}
			}
			//초콜릿을 하나 먹는다
			choco++;
			if(choco>100) {
				break;
			}
			finish=true;
			//검사한다
			for(int i=0; i<check_list.size();i++) {
				if(map[check_list.get(i)[0]][check_list.get(i)[1]]>=K) {
					check_list.remove(i);
					i--;
				}else {
					finish=false;
					break;
				}
			}
//			for(int[] check: check_list) {
//				if(map[check[0]][check[1]]<K) {
//					finish=false;
//					break;
//				}
//			}
		}
//		for(int i=0; i<R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		System.out.println(choco>100? 101:choco);
	}
	private static boolean isin(int r, int c) {
		if(r>=0 && c>=0 && r<R && c<C) {
			return true;
		}
		return false;
	}

}