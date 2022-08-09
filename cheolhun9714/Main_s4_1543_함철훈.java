package cheolhun9714;

import java.util.Scanner;

public class Main_s4_1543_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String str1 = sc.nextLine();
		int count =0;
		for (int i=0; i<=str.length()-str1.length();i++) {
			for(int j=0; j<str1.length();j++) {
				if (str.charAt(i+j) != str1.charAt(j)) break;
				if (j==str1.length()-1) {
					count++;
					i+=str1.length()-1;
				}
			}
		}
		System.out.println(count);
	}

}
