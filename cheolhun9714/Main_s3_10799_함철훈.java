package cheolhun9714;

import java.util.Scanner;

public class Main_s3_10799_함철훈 {

	public static void main(String[] args) {
		int layer=0;
		int count=0;
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '(') {
				if(str.charAt(i+1)!=')') {
					layer++;
				}
			}else {
				if(str.charAt(i-1)=='(') {
					count+=layer;
				}else {
					layer--;
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
