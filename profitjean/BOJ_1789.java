package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_1789 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		int count = 0;
		long sum = 0;
		
		while(true) {
			count += 1;
			sum += count;
			if (sum > S) {
				break;
			}
		}
		System.out.println(count-1);
	}

}
