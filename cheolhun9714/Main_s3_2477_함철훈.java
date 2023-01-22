package cheolhun9714;

import java.util.Scanner;

public class Main_s3_2477_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] rect = new int[6][2];
		int K = sc.nextInt();
		int small_rect = 0, large_rect=0;
		for(int i=0;i<6;i++) {
			for(int j=0;j<2;j++) {
				rect[i][j] = sc.nextInt();
			}
		}
		for(int i=3;i<6;i++) {		//0123, 1234,2345
			if (rect[i-2][0]==rect[i][0]&&rect[i-3][0]==rect[i-1][0]) {
				small_rect = rect[i-2][1]*rect[i-1][1];
				large_rect = (rect[i-2][1]+rect[i][1])*(rect[i-3][1]+rect[i-1][1]);
			}
		}
		
		if (rect[0][0]==rect[4][0]&&rect[3][0]==rect[5][0]) {	//3450
			small_rect = rect[4][1]*rect[5][1];
			large_rect = rect[1][1]*rect[2][1];
		}else if (rect[0][0]==rect[4][0]&&rect[1][0]==rect[5][0]) {	//4501
			small_rect = rect[5][1]*rect[0][1];
			large_rect = rect[2][1]*rect[3][1];
		}else if (rect[1][0]==rect[5][0]&&rect[2][0]==rect[0][0]) {	//5012
			small_rect = rect[1][1]*rect[0][1];
			large_rect = rect[3][1]*rect[4][1];
		}
		System.out.println((large_rect-small_rect)*K);
		sc.close();
	}

}
