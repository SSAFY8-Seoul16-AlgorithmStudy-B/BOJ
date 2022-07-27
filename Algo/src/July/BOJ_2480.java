package July;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2480 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] dice = new int[3];
		int ans = 0;
		for(int i =0; i<3;i++) {
			dice[i] = sc.nextInt();
		}
		
		if (dice[0] == dice[1] && dice[1] == dice[2] && dice[0] == dice[2]) {
			ans = 10000 + dice[0]*1000;
		} else if (dice[0] == dice[1] || dice[1] == dice[2]) {
			ans = 1000 + (dice[1]*100);
		} else if(dice[0]==dice[2]) {
			ans = 1000 + (dice[0]*100);
		} else {
			Arrays.sort(dice);
			ans = dice[2]*100;
		}
		System.out.print(ans);
	}

}
