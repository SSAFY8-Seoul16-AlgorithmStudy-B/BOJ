package cheolhun9714;

import java.util.Scanner;

public class Main_b1_9093_함철훈 {

	public static void main(String[] args) {
		StringBuilder answer = new StringBuilder();
		Scanner sc= new Scanner(System.in);
		int T = sc.nextLine().charAt(0)-'0';
		for(int i=0; i<T;i++) {
			String str = "";
			str = sc.nextLine();
			String[] sub_str = str.split(" ");
			for(int k=0; k<sub_str.length;k++) {				
				for(int j=1;j<=sub_str[k].length();j++) {
					answer.append(sub_str[k].charAt(sub_str[k].length()-j));
				} answer.append(" ");
			}
			answer.append("\n");
		}
		System.out.print(answer);
		sc.close();
	}

}