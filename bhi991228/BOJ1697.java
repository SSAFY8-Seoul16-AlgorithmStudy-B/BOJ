import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int now;
	int cnt;
	Pair(int now, int cnt){
		this.now = now;
		this.cnt = cnt;
	}
}

public class BOJ1697 {

	static int N, K, answer;
	static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();	//수빈이 위치
		K = scan.nextInt();	//동생 위치
		int cnt = 0;
		
		bfs(new Pair(N, cnt));
		System.out.println(answer);
	}
	
	private static void bfs(Pair start) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(start);
		visited[start.now] = true;
		Pair pos;
		
		while (queue.size() > 0) {
			pos = queue.poll();
			
			if (pos.now == K) {
				answer = pos.cnt;
				return;
			}
						
			//1 감소
			if (pos.now > 0 && !visited[pos.now-1]) {
				queue.offer(new Pair(pos.now-1, pos.cnt+1));
				visited[pos.now-1] = true;
			}
			
			//1 증가
			if (pos.now < 100000 && !visited[pos.now+1]) {
				queue.offer(new Pair(pos.now+1, pos.cnt+1));
				visited[pos.now+1] = true;
			}
			
			//2 배수
			if (pos.now <= 50000 && !visited[pos.now*2]) {
				queue.offer(new Pair(pos.now*2, pos.cnt+1));
				visited[pos.now*2] = true;
			}
		}
	}
}
