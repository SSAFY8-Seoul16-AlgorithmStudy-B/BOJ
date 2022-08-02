import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2529 {
	static char[] signs;
	static int[] numbers = new int[10];
	static ArrayList<Long> answers = new ArrayList<Long>();
	
	public static void findNumbers(int num1, int signIndex, String answer) {
		String temp;
		numbers[num1] -= 1;
		
		if (signs[signIndex] == '<') {
			if (num1 == 9) {
				numbers[num1] += 1;
				return;
			}
			
			for (int i = num1+1; i < 10; i++) {
				temp = answer;
				
				if (numbers[i] > 0) {
					temp += Integer.toString(i);
					
					if (signIndex == signs.length-1) {
						answers.add(Long.parseLong(temp));
					}else {
						findNumbers(i, signIndex+1, temp);
					}
				}
			}
		}else {
			if (num1 == 0) {
				numbers[num1] += 1;
				return;
			}
			
			for (int i = num1-1; i >= 0 ; i--) {
				temp = answer;
				
				if (numbers[i] > 0) {
					temp += Integer.toString(i);
					
					if (signIndex == signs.length-1) {
						answers.add(Long.parseLong(temp));
					}else {
						findNumbers(i, signIndex+1, temp);
					}
				}
			}
		}
		
		numbers[num1] += 1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		signs = new char[k];
		Arrays.fill(numbers, 1);
		
		
		for (int i = 0; i < k; i++) {
			signs[i] = scan.next().charAt(0);
		}
		
		for (int i = 0; i < 10; i++) {
			findNumbers(i, 0, Integer.toString(i));
		}
		
		Collections.sort(answers);
		System.out.printf("%0"+(k+1)+"d%n", answers.get(answers.size()-1));
		System.out.printf("%0"+(k+1)+"d%n", answers.get(0));
	}

}
