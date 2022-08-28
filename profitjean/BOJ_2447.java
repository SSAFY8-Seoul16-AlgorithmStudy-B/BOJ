package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {

	static char[][] arr;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 가운데는 무조건 비워져야해
		// N = 3, 9, 27
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		makeStar(0,0,N,false);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	private static void makeStar(int x, int y, int n,boolean isEmpty) {
		
		// 공백 처리
		if (isEmpty) {
			for (int i = x; i < x+n; i++) {
				for (int j = y; j < y+n; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		if (n==1) {
			arr[x][y] = '*';
			return;
		}
		int size = n/3; // 27 9 3 1
		int count = 0;
		for (int i = x; i < x+n; i=i+size) {
			for (int j = y; j < y+n; j=j+size) {
				count ++;
				if (count==5) {
					makeStar(i,j,size,true);
				} else {
					makeStar(i,j,size,false);
				}
			}
		}
		
	}

}
