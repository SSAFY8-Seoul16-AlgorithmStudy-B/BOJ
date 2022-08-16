package boj.p1k.p1600;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1697 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); 
		int b = sc.nextInt();
		int sec = 0;
		boolean[] visited = new boolean[100001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(a);
		
		loop:
		while(!q.isEmpty() ) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				visited[cur] = true;
				if (cur == b) {
					break loop;
				}
				if (cur * 2 <= 100000 && !visited[cur * 2]) q.offer(cur * 2);
				if (cur + 1 <= 100000 && !visited[cur + 1]) q.offer(cur + 1);
				if (cur - 1 >= 0 && !visited[cur - 1]) q.offer(cur - 1);



				
			}	
			sec ++;
		}
		System.out.println(sec);
		
		
	}

}
