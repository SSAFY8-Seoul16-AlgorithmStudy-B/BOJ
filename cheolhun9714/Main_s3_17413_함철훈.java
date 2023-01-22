package cheolhun9714;

import java.util.Scanner;

public class Main_s3_17413_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		for(int i=0; i<str.length();i++) {
			if (str.charAt(i)=='<') {
				for(int j=1; j<=i;j++) {
					if(str.charAt(i-j)!='>'&&str.charAt(i-j)!=' '&&i!=j) {
						System.out.print(str.charAt(i-j));
						continue;
					}
					if(i==j)	System.out.print(str.charAt(0));
					break;
					
				}
				while(str.charAt(i)!='>') {
					System.out.print(str.charAt(i++));
				}
				System.out.print('>');
			}else if(str.charAt(i)==' ') {
				for(int j=1; j<=i;j++) {
					if(str.charAt(i-j)!='>'&&str.charAt(i-j)!=' '&&i!=j) {
						System.out.print(str.charAt(i-j));
						continue;
					}
					if(i==j)	System.out.print(str.charAt(0));
					System.out.print(" ");
					break;
					
				}				
			}else if(i==str.length()-1){
				for(int j=0; j<=i;j++) {
					if(str.charAt(i-j)!='>'&&str.charAt(i-j)!=' ') {
						System.out.print(str.charAt(i-j));
					}else {
						break;
					}
				}
			}
		}
		sc.close();
	}
}
