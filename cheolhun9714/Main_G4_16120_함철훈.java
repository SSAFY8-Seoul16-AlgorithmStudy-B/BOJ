package boj;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main_G4_16120_함철훈 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean answer=true;
		Deque<Character> stack = new ArrayDeque<Character>();
		if(str.equals("P")) {
			answer = true;
		}else if(str.length()>3) {
			for(int i=0; i<str.length();i++) {
				if(str.charAt(i)=='A') {
					if(!stack.isEmpty() &&stack.pop()=='P') {
						if(i!=str.length()-1 && stack.size() !=0 && stack.peek()=='P' && str.charAt(i+1)=='P') {
							i++;
						}else {
							answer=false;
							break;
						}
					}else {
						answer=false;
						break;
					}
				}else if(str.charAt(i)=='P') {
					stack.push('P');
				}else {
					answer=false;
					break;
				}
			}
			if(answer&&stack.size()==1) {
				if(stack.peek()=='P') {
					answer=true;
				}else {
					answer=false;
				}
			}else {
				answer = false;
			}
		}else {
			answer=false;
		}
		if(answer) {
			System.out.println("PPAP");
		}else {
			System.out.println("NP");
		}
	}
}
