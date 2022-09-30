import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1080 {
	
	static int[][] arrA;
	static int[][] arrB;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		arrA = new int[R][C];
		arrB = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				arrA[i][j] = line.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				arrB[i][j] = line.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < R-2; i++) {
			for (int j = 0; j < C-2; j++) {
				if (arrA[i][j] != arrB[i][j]) {
					answer++;
					revert(i, j);
				}
			}
		}
		
		//행렬 A와 B가 같은 지 확인
		boolean isSame = true;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arrA[i][j] != arrB[i][j]) {
					isSame = false;
				}
			}
		}
		
		if (isSame) System.out.println(answer);
		else System.out.println(-1);
	}
	
	private static void revert(int r, int c) {
		for (int i = r; i < r+3; i++) {
			for (int j = c; j < c+3; j++) {
				arrA[i][j] = (arrA[i][j] == 1) ? 0 : 1;
			}
		}
	}
}
