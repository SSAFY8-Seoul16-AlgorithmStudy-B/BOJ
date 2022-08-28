package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_9093 {

	static int test;
	static String[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		test = Integer.parseInt(br.readLine());
		for (int i = 0; i < test; i++) {
			String s = br.readLine();
			arr = s.split(" ");
			StringBuilder sb = new StringBuilder();
			
			for (String a : arr) {
				StringBuilder rev = new StringBuilder(a);
				sb.append(rev.reverse());
				sb.append(" ");
			}
			
			System.out.println(sb);
		}
		

	}

}
