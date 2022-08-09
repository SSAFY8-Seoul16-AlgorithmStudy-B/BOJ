package cheolhun9714;

import java.util.Arrays;
import java.util.Scanner;

public class Main_b1_2309_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] height = new int[9];
		int sum=0;
		for(int i =0; i<9;i++) {
			sum += height[i] = sc.nextInt();
		}
		boolean end = false;
		Arrays.sort(height);
		int dif = sum-100;
		for(int i=0; i<8;i++) {
			if (!end) {				
				for(int j=i+1; j<9;j++) {
					if(height[i]+height[j]==dif) {
						for(int k=0;k<9;k++) {
							if (k!=i && k!=j) {
								System.out.println(height[k]);
							}
						}
						end = true;
						break;
					}
				}
			}
		}
		sc.close();
	}

}
