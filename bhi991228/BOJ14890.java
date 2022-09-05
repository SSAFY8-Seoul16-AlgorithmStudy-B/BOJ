import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890 {

	static int N;
	static int L;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (IsAvailRoad(i)) answer++;
		}
		
		rotation();
		
		for (int i = 0; i < N; i++) {
			if (IsAvailRoad(i)) answer++;
		}
		
		System.out.println(answer);
	}
	
	private static void rotation() {
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				int temp = map[i][j];
				map[i][j] = map[j][i];
				map[j][i] = temp;
			}
		}
	}

	/* n 행이 지나갈 수 있는 길인지 확인 */
	private static boolean IsAvailRoad(int n) {
		int now, next;
		boolean[] putSlope = new boolean[N]; 
		
		for (int i = 0; i < N-1; i++) {
			now = map[n][i];
			next = map[n][i+1];
			
			if (now == next) continue;
			
			if (Math.abs(now - next) > 1) {
				//높이 차이가 2 이상이면 경사로로 해결이 안되니 false
				return false;
			} else {
				if (now > next) {	//현재 칸이 다음 칸보다 높은 경우 (경사로를 오른쪽으로 둬야 하는 경우)
					if (N-(i+1) < L) return false;	//경사로를 놓을 길이가 안되면 false
					for (int j = 0; j < L; j++) {
						if (map[n][i+1+j] != next) return false;	//경사로를 놓을 위치에 높이가 다른 칸이 있으면 false
					}
					
					for (int j = 0; j < L; j++) {
						putSlope[i+1+j] = true;	//경사로 표시
					}
					
					i += L-1;	//다음 반복에서 now가 현재 놓은 경사로의 마지막 칸을 가리키도록 설정
					
				} else {			//현재 칸이 다음 칸보다 낮은 경우 (경사로를 왼쪽으로 둬야 하는 경우)
					if (i+1 < L) return false;		//경사로를 놓을 길이가 안되면 false
					
					for (int j = 0; j < L; j++) {
						if (map[n][i-j] != now || putSlope[i-j] == true) return false;
					}
				}
			}
		}
		
		return true;
	}
}
