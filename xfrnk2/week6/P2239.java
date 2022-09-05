import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N = 9, emptyCnt;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		emptyCnt = 0;

		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				int inputValue = Character.getNumericValue(line.charAt(j));
				if (inputValue == 0)
					emptyCnt++;
				map[i][j] = inputValue;
			}
		}
		search(0, 0, 0);
	}

	public static void search(int cnt, int x, int y) {
		if (cnt == emptyCnt) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}

		if (N <= y) {
			search(cnt, x + 1, 0);
			return;
		}

		if (0 < map[x][y]) {
			search(cnt, x, y + 1);
			return;
		}
		int minX = x / 3 * 3, maxX = minX + 3, minY = y / 3 * 3, maxY = minY + 3;
		numTest: for (int testNum = 1; testNum <= N; testNum++) {
			for (int i = minX; i < maxX; i++) {
				for (int j = minY; j < maxY; j++) {
					if (map[i][j] == testNum) continue numTest;	
				}
			}
			for (int i = 0; i < N; i++) {
				if (map[x][i] == testNum || map[i][y] == testNum) {
					continue numTest;
				}
			}
			map[x][y] = testNum;
			search(cnt + 1, x, y + 1);
			map[x][y] = 0;
		}
	}
}
