import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17406 {

	static int N, M, R;
	static int[][] arrOri;
	static int[][] arr;
	static int[][] rotationOper;
	static int[] rotationPerm;
	static int rectCnt;
	static int answer = Integer.MAX_VALUE;
	static int[] dr = {1, 0, -1, 0}; //하 우 상 좌
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arrOri = new int[N][M];
		arr = new int[N][];
		rotationOper = new int[R][3];
		rotationPerm = new int[R];
		
		//배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arrOri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			rotationOper[i][0] = Integer.parseInt(st.nextToken()) - 1;
			rotationOper[i][1] = Integer.parseInt(st.nextToken()) - 1;
			rotationOper[i][2] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0, 0);
		System.out.println(answer);
	}

	
	private static void permutation(int cnt, int flag) {
		if(cnt == R) {
			//초기 배열 복사
			for (int i = 0; i < N; i++) {
				arr[i] = Arrays.copyOf(arrOri[i], M);
			}
			
			for (int i = 0; i < R; i++) {
				int[] oper = rotationOper[rotationPerm[i]];
				rotation(oper[0], oper[1], oper[2]);
			}
			
			answer = Math.min(answer, getArrValue());
			return;
		}
		
		for (int i = 0; i < R; i++) {
			if ((flag & 1 << i) != 0) continue;
			
			rotationPerm[cnt] = i;
			permutation(cnt+1, flag | 1 << i);
		}
	}


	private static int getArrValue() {
		int value = Integer.MAX_VALUE;
		
		for (int[] line : arr) {
			int sum = 0;
			for (int i : line) {
				sum += i;
			}
			value = Math.min(value, sum);
		}
		
		return value;
	}


	private static void rotation(int baseR, int baseC, int s) {
		int startR = baseR-s;
		int startC = baseC-s; 
		int endR = baseR+s;
		int endC = baseC+s; 
		int r, c, dir, temp;
		int nr, nc;
		
		for (int i = 0; i < s; i++) {
			r = startR+i;
			c = startC+i;
			dir = 0;
			temp = arr[r][c];	//첫 시작점의 값은 덮어씌여지기 전 미리 저장
			
			while(dir < 4) {
				nr = r + dr[dir];
				nc = c + dc[dir];
				
				if (nr >= startR+i && nr <= endR-i && nc >= startC+i && nc <= endC-i) {
					arr[r][c] = arr[nr][nc];
					r = nr;
					c = nc;
					
				}else {
					dir += 1;
				}
			}
			
			arr[startR+i][startC+i+1] = temp;	//네모 하나가 다 돌면 저장해둔 값을 -> 시작점이 돌아갔어야 할 위치에 저장
		}
	}

}
