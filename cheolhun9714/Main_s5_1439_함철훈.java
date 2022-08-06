package cheolhun9714;

import java.util.Scanner;

public class Main_s5_1439_함철훈 {

	public static void main(String[] args) {
		int count=0;
		Scanner sc=new Scanner(System.in);
		String str = sc.next();
		for(int i=1; i<str.length();i++) {
			if(str.charAt(i)!=str.charAt(i-1))	count++;
		}
		if(count%2 ==0)	System.out.println(count/2);
		else System.out.println(count/2 +1);
	}

}
