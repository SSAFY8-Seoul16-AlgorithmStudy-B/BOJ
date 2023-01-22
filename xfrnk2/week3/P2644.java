package boj.p2k.p2600;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2644 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = sc.nextInt(), b = sc.nextInt();
		int M = sc.nextInt();
		int answer = 0;
		
		boolean[][] map = new boolean[N + 1][N + 1]; 
		boolean[][] visited = new boolean[N + 1][N + 1]; 
		
		for (int i = 0; i < M; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			map[parent][child] = true;
			map[child][parent] = true;
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {a, 0});
		while(!q.isEmpty() && answer == 0) {
			int[] cur = q.poll();
			if (cur[0] == b) {
				answer = cur[1];
				break;
			}
			for (int i = 1; i <= N; i++) {

				if (map[i][cur[0]] && !visited[i][cur[0]]) {
					visited[i][cur[0]] = true;
					visited[cur[0]][i] = true;
					q.offer(new int[] {i, cur[1] + 1});
				}
			}
		}
		System.out.println(answer == 0 ? -1 : answer);
		
	}
}
