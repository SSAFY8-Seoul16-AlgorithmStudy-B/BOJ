import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] matrixOrigin;
	static int[][] matrix;
	static int[][] operations;
	static int[] numbers;
	static boolean[] isUsed;
	static int answer;

	public static void rotate(int r, int c, int s) {

		for (int j = s; j > 0; j--) {

			int ret = matrix[r - j][c + j];

			System.arraycopy(matrix[r - j], c - j, matrix[r - j], c - j + 1, j * 2);
			for (int k = r - j; k < r + j; k++) {

				matrix[k][c - j] = matrix[k + 1][c - j];
			}

			System.arraycopy(matrix[r + j], c - j + 1, matrix[r + j], c - j, j * 2);
			for (int k = r + j; k > r - j; k--) {
				matrix[k][c + j] = matrix[k - 1][c + j];
			}

			matrix[r - j + 1][c + j] = ret;
		}

	}

	public static void permutation(int cnt) {
		if (cnt == K) {
			matrix = new int[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					matrix[i][j] = matrixOrigin[i][j];
				}
			}

			for (int i = 0; i < K; i++) {
				int[] op = operations[numbers[i]];
				rotate(op[0], op[1], op[2]);
				for (int[] row : matrix) {
				}
			}

			for (int[] row : matrix) {

				int sum = 0;
				for (int elem : row) {
					sum += elem;
				}
				answer = Math.min(answer, sum);
			}
			return;
		}
		for (int i = 0; i < K; i++) {
			if (isUsed[i])
				continue;
			numbers[cnt] = i;
			isUsed[i] = true;
			permutation(cnt + 1);
			isUsed[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		operations = new int[K][3];
		numbers = new int[K];
		isUsed = new boolean[K];
		answer = Integer.MAX_VALUE;

		matrixOrigin = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				matrixOrigin[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			operations[i] = new int[] { r, c, s };
		}
		permutation(0);
		System.out.print(answer);
	}

}
