package cheolhun9714;

import java.util.Scanner;

public class Main_s1_11729_함철훈 {
	public static int answer =0;
	public static StringBuilder result = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(N,1,2,3);
		System.out.println(answer);
		System.out.println(result);
		
	}
	
	public static void hanoi(int n, int start, int temp, int end) {
		if(n==1) {
			answer++;
			result.append(start).append(" ").append(end).append("\n");
		}else {
			hanoi(n-1, start, end, temp);
			hanoi(1,start,temp,end);
			hanoi(n-1,temp,start,end);
		}
		
		return;
	}
}
