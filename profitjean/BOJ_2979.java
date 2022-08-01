package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2979 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int one = Integer.parseInt(st.nextToken());
		int two = Integer.parseInt(st.nextToken());
		int three = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[101];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			for (int j = first; j < second; j++) {
				arr[j] += 1;
			}
			
			if (first<=min){
				min = first;
			}
			if (second>=max) {
				max = second;
			}

		}
		

		int cost = 0;
		for (int k = min; k <=max ; k++) {
			if (arr[k] == 1) {
				cost += one;
			} else if (arr[k] == 2) {
				cost += (2*two);
			} else if (arr[k] == 3) {
				cost += (3*three);
			}
		}
		System.out.println(cost);
	}
}
