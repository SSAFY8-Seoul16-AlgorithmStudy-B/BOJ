package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_g1_17472_함철훈 {
	static int[][] map;
	static int N,M,answer=0;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};//상하좌우
	static int[] dc = {0,0,-1,1};//상하좌우
	static LinkedList<int[]> dist;
	static Deque<int[]> queue;
	static int[] head;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		queue = new LinkedList<>();
		dist = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num = 1;
		for(int i=0; i<N; i++) {	// 섬마다 번호 매기기
			for(int j=0; j<M; j++) {
				if(map[i][j] ==1&&!visited[i][j]) {
					queue.offer(new int[] {i,j});
					island_bfs(num);
					num++;
				}					
			}
		}
		head = new int[num];
		for(int i=0; i<N; i++) {		// 섬 번호 확인하는 코드
			System.out.println(Arrays.toString(map[i]));
		}
		for(int i=1; i<num; i++) {
			for(int r=0;r<N;r++) {
				for(int c=0; c<M;c++) {
					if(map[r][c]==i) {
						queue.offer(new int[] {r,c,4});
					}
				}
			}
			bfs(i);
		}
		dist.sort(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[2] != o2[2]) {
					return o1[2] - o2[2];
				}
				for(int i=0; i<2;i++) {
					if(o1[i]!=o2[i]) {
						return o1[i] - o2[i];
					}
				}
				return 0;
			}
		});
		
		for(int i=0; i<dist.size();i++) {	// 연결관계 확인하는 코드
			System.out.println(Arrays.toString(dist.get(i)));
		}
		kruskal();
		System.out.println(answer);
	}
	private static void kruskal() {
		int count=0;
		for(int i=1; i<head.length; i++) {
			head[i] = i;
		}
		for(int i=0; i<dist.size();i++) {
			int[] temp=dist.get(i);
			if(head[temp[1]]==head[temp[0]]) { //이미 두정점이 둘다같은집합에 속해있는 경우(loop가 형성된경우)
				continue;
			}else {
				System.out.println(Arrays.toString(head));
				int to_change=head[temp[1]];
				for(int j=head.length-1;j!=0;j--) {
					if(head[j]==to_change) {
						head[j] = head[temp[0]];
					}
				}
				answer+=temp[2];
				count++;
			}
		}
		if(count !=head.length-2) answer = -1;
		// 1 2 3 4 5 6
		// 1 2 3 2 3 6
		
	}
	private static void bfs(int num) {
		int distance = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int[] temp = queue.poll();
				int r = temp[0];
				int c = temp[1];
				int direction = temp[2];
				if(direction ==4) {					
					for(int j=0; j<4;j++) {
						int nr = r+dr[j];
						int nc = c+dc[j];
						if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==0) {
							queue.offer(new int[] {nr,nc,j});
						}
					}
				}else {
					int nr = r+dr[direction];
					int nc = c+dc[direction];
					if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==0) {
						queue.offer(new int[] {nr,nc,direction});
					}else if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]!=0&&map[nr][nc]!=num) {
						if(distance==1)	continue;
						else {
							for(int j=0; j<dist.size();j++) {
								if(dist.get(j)[0] == num&& dist.get(j)[1]==map[nr][nc]&&distance<=dist.get(j)[2]) {
									dist.remove(j);
									break;
								}
							}
							if(num<map[nr][nc]) {
								dist.add(new int[] {num, map[nr][nc], distance});
							}
						}
					}
				}
				
			}
			distance++;
		}
	}
	private static void island_bfs(int num) {
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int[] temp=queue.poll();
				int r=temp[0];
				int c=temp[1];
				visited[r][c] = true;
				map[r][c] = num;
				for(int j=0; j<4;j++) {
					int nr = r+dr[j];
					int nc = c+dc[j];
					if(nr>=0&&nr<N&&nc>=0&&nc<M&&!visited[nr][nc]) {
						if(map[nr][nc]==1) {
							queue.offer(new int[] {nr,nc});
						}
					}
				}
			}
		}
	}
}
