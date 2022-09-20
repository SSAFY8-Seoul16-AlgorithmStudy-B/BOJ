import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ1941 {

	static char[][] room;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int answer = 0;
	static int[] select;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		room = new char[5][];
		select = new int[7];

		for (int i = 0; i < 5; i++) {
			room[i] = br.readLine().toCharArray();
		}
		
		combi(0, 0, 0);
		
		System.out.println(answer);
	}

	private static void combi(int cnt, int start, int SCnt) {
		if (cnt - SCnt >= 4) return;
		
		if (cnt == 7) {
			//연결 여부 체크
			bfs();
			return;
		}
		
		for (int i = start; i < 25; i++) {
			select[cnt] = i;
			combi(cnt+1, i+1, (room[i/5][i%5])=='S' ? SCnt+1 : SCnt);
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(select[0]);
		boolean[] visited = new boolean[7];
		int n = 0;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = (now/5)+dr[i];
				int nc = (now%5)+dc[i];
				
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
				
				for (int j = 0; j < 7; j++) {
					if (select[j] == (nr*5)+nc && !visited[j]) {
						n++;
						visited[j] = true;
						queue.add((nr*5)+nc);
						break;
					}
				}
			}
		}
		
		if (n >= 7) {
			answer++;
		}
	}
}
