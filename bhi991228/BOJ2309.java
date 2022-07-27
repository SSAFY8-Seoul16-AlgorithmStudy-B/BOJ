import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {

	public static void main(String[] args) {
		int[] heights = new int[9];
		int sum = 0;
		int i1 = -1, i2 = -1;
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			heights[i] = scan.nextInt();
		}
		
		Arrays.sort(heights);
		
		for (int i = 0; i < 9; i++) {
			for (int j = i+1; j < 9; j++) {
				
				sum = 0;
				for (int k = 0; k < 9; k++) {
					if (k == i || k == j) continue;
					sum += heights[k];
				}
				if (sum == 100) {
					i1 = i; i2 = j;
					break;
				}
			}
		}
		
		for (int i = 0; i < 9; i++) {
			if (i != i1 && i != i2) System.out.println(heights[i]);
		}
	}

}
