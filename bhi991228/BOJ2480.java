import java.util.Arrays;
import java.util.Scanner;

public class BOJ2480 {

	public static void main(String[] args) {
		int[] dice = new int[7];
		int max = 0;
		boolean bEnd = false;
		
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			dice[scan.nextInt()]++;
		}
		
		for (int i = 1; i < dice.length; i++) {
			
			if (dice[i] == 0) continue;
			
			if (dice[i] == 3) {
				System.out.println(10000+(i*1000));
				bEnd = true;
				break;
			} else if (dice[i] == 2) {
				System.out.println(1000+(i*100));
				bEnd = true;
				break;
			} else {
				max = Math.max(max, i);
			}
		}
		
		if (!bEnd) System.out.println(max*100);
	}

}
