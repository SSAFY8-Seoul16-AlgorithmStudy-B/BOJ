package cheolhun9714;

import java.util.Scanner;

public class Main_b2_2920_함철훈 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr = new int[8];
		boolean ascending = true;
		boolean descending = true;
		
		for(int i=0; i<8;i++) {
			arr[i] = sc.nextInt();
			if (arr[i] !=i+1) ascending =false;
			if (arr[i] !=8-i) descending = false;
		}
		if (ascending == true) System.out.println("ascending");
		else if (descending == true) System.out.println("descending");
		else System.out.println("mixed");
		sc.close();
	}

}
