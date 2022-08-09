package cheolhun9714;

import java.util.Scanner;

public class Main_s5_2828_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int M=sc.nextInt();
		int J=sc.nextInt();
		int pos = 1;
		int mov =0;
		
		for(int i=0; i<J; i++) {
			int fall = sc.nextInt();
			if(pos+M-1 < fall) {
				mov += fall-pos-M+1;
				pos += fall-pos-M+1;
			}else if(pos>fall) {
				mov += pos-fall;
				pos -= pos-fall;
			}
		}
		System.out.println(mov);
		sc.close();
	}

}
