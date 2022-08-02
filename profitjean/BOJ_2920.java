package July;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// c d e f g a b C
		// 1 2 3 4 5 6 7 8
		Scanner sc = new Scanner(System.in);
		int[] asc = {1,2,3,4,5,6,7,8};
		int[] desc = {8,7,6,5,4,3,2,1};
		
		int[] arr = new int[8];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		if (Arrays.equals(arr,asc)) {
			System.out.println("ascending");
		} else if (Arrays.equals(arr,desc)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
		
	}

}
