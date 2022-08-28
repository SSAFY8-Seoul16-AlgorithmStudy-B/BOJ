package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
	static StringBuilder result = new StringBuilder(50);
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		Hanoi(N,1,2,3);
		System.out.println(count);
		System.out.println(result);
	}

	private static void Hanoi(int n, int start, int temp, int end) {
		if (n==0) {
			return;
		}
		count++;
		Hanoi(n-1, start, end, temp );
		result.append(start+ " "+end+"\n");
		Hanoi(n-1,temp,start,end);
		
		
	}
}
