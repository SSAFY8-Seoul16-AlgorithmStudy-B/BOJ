package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_1543 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		String word = br.readLine();
		int ans = 0;
		
		for (int i = 0; i < doc.length() - word.length() +1; i++) {
			if (doc.substring(i, i+word.length()).equals(word)) {
				i = i + word.length() -1;
				ans ++;
			}
		}
		System.out.println(ans);
	}

}
