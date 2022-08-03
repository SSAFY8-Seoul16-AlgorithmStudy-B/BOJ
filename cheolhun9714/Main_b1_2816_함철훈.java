package cheolhun9714;

import java.util.Scanner;

public class Main_b1_2816_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pos1=0, pos2=0;
		int N = sc.nextInt();
		String[] channel = new String[N];
		for (int i=0; i<N; i++) {
			channel[i] = sc.next();
			if (channel[i].equals("KBS1")) {
				pos1=i;
			}
			else if(channel[i].equals("KBS2")) {
				pos2=i;
			}
		}
		for (int i =0;i<pos1;i++) {
			System.out.print(1);
		}
		for (int i =0;i<pos1;i++) {
			System.out.print(4);
		}
		
		if(pos1> pos2) {
			for (int i =0;i<pos2+1;i++) {
				System.out.print(1);
			}
			for (int i =1;i<pos2+1;i++) {
				System.out.print(4);
			}
			
		}else {
			for (int i =0;i<pos2;i++) {
				System.out.print(1);
			}
			for (int i =1;i<pos2;i++) {
				System.out.print(4);
			}
		}
		sc.close();
	}

}
