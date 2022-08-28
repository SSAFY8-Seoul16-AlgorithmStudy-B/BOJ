package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int one= 0;
		int zero= 0;
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String lines = br.readLine();
		
		if (lines.charAt(0)=='0') {
			zero += 1;
		} else {
			one += 1;
		}
		
		// 수가 바뀌는 곳으로 영역 카운팅?
		for (int i = 1; i < lines.length(); i++) {
			if (lines.charAt(i-1) != lines.charAt(i)) {
				if (lines.charAt(i) == '0') {
					zero += 1;
				} else {
					one +=1;
				}
			}
		}
		// 최소횟수 출력
		System.out.println(Math.min(zero, one));
	}
}
