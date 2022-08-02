import java.util.Scanner;

public class BOJ2979 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int t1 = 0, t2 = 0;
		int[] cost = {0, a, b, c};
		
		int answer = 0;
		
		int[] parkStatus = new int[101];
		for (int i = 0; i < 3; i++) {
			t1 = scan.nextInt();
			t2 = scan.nextInt();
			
			for (int j = t1; j < t2; j++) {
				parkStatus[j]++;
			}
		}
		
		for (int i : parkStatus) {
			answer += cost[i] * i;
		}
		
		System.out.println(answer);
	}
}
