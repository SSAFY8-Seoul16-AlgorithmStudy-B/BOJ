import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ2447 {
	
	static int N;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(board[i], ' ');
		}
		
		makePattern(N, 0, 0);
		for (char[] line : board) {
			for (char c : line) {
				bw.write(c);
			}
			bw.write("\n");
		}
		bw.flush();
	}

	private static void makePattern(int size, int startR, int startC) {
		for (int i = startR; i < startR + size; i += size/3) {
			for (int j = startC; j < startC + size; j += size/3) {
				if((i == startR + (size/3)) && (j == startC + (size/3))) continue;
				
				if(size > 3)
					makePattern(size/3, i, j);
				else
					board[i][j] = '*';
			}
		}
	}
}
