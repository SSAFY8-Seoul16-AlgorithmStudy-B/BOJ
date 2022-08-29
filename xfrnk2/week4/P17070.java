import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.IntBinaryOperator;

public class Main {
	static int N, goal, ans;
	static boolean[][] map;
	static Map<String, BiPredicate> commands;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		goal = N - 1;
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j].equals("0") ? false : true;
			}
		}
		BiPredicate<Integer, Integer> movableToEast = (x, y) -> y + 1 <= goal && !map[x][y + 1];
		BiPredicate<Integer, Integer> movableToSouth = (x, y) -> x + 1 <= goal && !map[x + 1][y];
		BiPredicate<Integer, Integer> movableToDiagonal = (x, y) -> y + 1 <= goal && x + 1 <= goal && !map[x][y + 1]
				&& !map[x + 1][y] && !map[x + 1][y + 1];

		commands = new HashMap<String, BiPredicate>();
		commands.put("동쪽으로이동가능?", movableToEast);
		commands.put("남쪽으로이동가능?", movableToSouth);
		commands.put("대각선으로이동가능?", movableToDiagonal);

		dfs(0, 1, 0);

		System.out.print(ans);
	}

	public static void dfs(int x, int y, int direction) {
		if (x == goal && y == goal) {
			ans++;
			return;
		}
		switch (direction) {
		case 0:
			if (commands.get("동쪽으로이동가능?").test(x, y)) dfs(x, y + 1, 0);
			break;
		case 1:
			if (commands.get("남쪽으로이동가능?").test(x, y)) dfs(x + 1, y, 1);
			break;
		case 2:
			if (commands.get("동쪽으로이동가능?").test(x, y)) dfs(x, y + 1, 0);
			if (commands.get("남쪽으로이동가능?").test(x, y)) dfs(x + 1, y, 1);
			break;
		}
		if (commands.get("대각선으로이동가능?").test(x, y)) 	dfs(x + 1, y + 1, 2);
	}
}
