package July;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 키의 합이 100
		int [] height = new int[9];
		int [] ans = new int[7];
		int sum = 0;
		int idx1 = 0;
		int idx2 = 0;
		
		for (int i = 0; i < height.length; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}
		
		//int sum = Arrays.stream(height).sum();
		// 정렬?
		Arrays.sort(height);
		for (int i = 0; i < height.length; i++) {
			for (int j = i+1; j < height.length; j++) {
				if (sum-height[i]-height[j] == 100 ) {
					idx1 = i;
					idx2 = j;
					break;
				}
			}
		}
		
		for (int i = 0; i < height.length; i++) {
			if (i==idx1 || i == idx2) {
				continue;
			}
			System.out.println(height[i]);
		}
	
		
	}

}
