package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_s1_1697_함철훈 {
	static boolean[] pos;
	static int N,K,cnt=0, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pos = new boolean[100001];
		
		bfs();
		System.out.println(answer);
	}
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		int count=-1;
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0; i<size ; i++) {
				int current = queue.poll();
				pos[current] = true;
				if(current==K) {
					queue.clear();
					break;
				}
				for(int j=0; j<3; j++) {
					int next = change(j, current);
					if(next>=0 && next<100001&& !pos[next]) {
						queue.offer(next);
					}
				}
			}
			count++;
		}
		answer = count;
	
	}
	static int change(int i, int num) {
		switch(i) {
			case 0: num--;
					break;
			case 1: num++;
					break;
			case 2: num*=2;
					break;
			default:
					break;
		}
		return num;
	}
}
