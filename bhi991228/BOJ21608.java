import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ21608 {

	static class Pos implements Comparable<Pos>{
		int r, c;
		int emptyNum;
		public Pos(int r, int c, int emptyNum) {
			this.r = r;
			this.c = c;
			this.emptyNum = emptyNum;
		}
		@Override
		public int compareTo(Pos o) {
			if (o.emptyNum == this.emptyNum) {
				if (this.r == o.r) return this.c - o.c;
				return this.r - o.r;
			}
			return o.emptyNum - this.emptyNum;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] favorite = new int[(N*N)+1][4];
		int[][] map = new int[N][N];
		Set<Integer>[][] adjStdnt = new HashSet[N][N];
		PriorityQueue<Pos> availPos = new PriorityQueue<>();
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		//나중에 빈 자리 계산을 위해 인접한 곳 중 배열을 벗어나는 곳은 미리 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adjStdnt[i][j] = new HashSet<>();
				int num = 0;
				
				for (int dir = 0; dir < 4; dir++) {
					int nr = i + dr[dir];
					int nc = j + dc[dir];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) adjStdnt[i][j].add(--num);
				}
			}
		}
		
		//앉힐 순서대로 입력
		for (int i = 1; i <= N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			int maxAdj = -1;
			availPos.clear();
			
			for (int j = 0; j < 4; j++) {
				favorite[student][j] = Integer.parseInt(st.nextToken());
			}
			
			/* 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸 */
			//가능한 자리 후보 선정하여 availPos에 저장 (map에 저장된 정보 == 그 위치에 인접한 학생들 번호)
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 0) {
						int adjNum = 0;
						for (int idx = 0; idx < 4; idx++) {
							if (adjStdnt[r][c].contains(favorite[student][idx])) adjNum++; 
						}
						
						if (adjNum < maxAdj) continue;
						if (adjNum > maxAdj) {
							maxAdj = adjNum;
							availPos.clear();
						}
						availPos.add(new Pos(r, c, 4 - adjStdnt[r][c].size()));
					}
				}
			}
			
			/* 인접한 칸 중에 비어있는 칸이 가장 많은 순 -> 행 숫자가 작은 순 -> 열 숫자가 작은 순 선정 */
			Pos sitPos = availPos.poll();
			map[sitPos.r][sitPos.c] = student;
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = sitPos.r + dr[dir];
				int nc = sitPos.c + dc[dir];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				adjStdnt[nr][nc].add(student);
			}
		}
		
		/* 만족도 구하기 */
		int answer = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				int score = 0;
				for (int idx = 0; idx < 4; idx++) {
					if (adjStdnt[r][c].contains(favorite[map[r][c]][idx])) {
						if (score == 0) score = 1;
						else score *= 10;
					}
				}
				answer += score;
			}
		}
		
		System.out.println(answer);
	}

}
