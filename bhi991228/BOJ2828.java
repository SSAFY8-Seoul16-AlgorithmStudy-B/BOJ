import java.util.Iterator;
import java.util.Scanner;

public class BOJ2828 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int j = scan.nextInt();
		int apple = 0;
		int start = 1, end = m;
		int answer = 0;
		int temp = 0;
		
		
		for (int i = 0; i < j; i++) {
			apple = scan.nextInt();
			
			if (apple >= start && apple <= end) {
				continue;
			} else {
				if (apple > end) {
					temp = apple - end;
					start += temp;
					end += temp;
				}
				else {
					temp = start - apple;
					start -= temp;
					end -= temp;
				}
				
				answer += temp;
			}
		}
		
		System.out.println(answer);
	}

}
