package cheolhun9714;

import java.util.Arrays;
import java.util.Scanner;

public class Main_b4_2480_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] eye = new int[3];
		int answer = 0;
		for (int i=0;i<3;i++) {
			eye[i]=sc.nextInt();
		}
		Arrays.sort(eye);
		if (eye[0] == eye[2]) {
			answer = 10000+eye[0]*1000;
		}else if(eye[0] == eye[1]|| eye[1]==eye[2]) {
			answer = 1000+eye[1]*100;
		}else {
			answer = eye[2]*100;
		}
		System.out.println(answer);
		sc.close();
	}

}
