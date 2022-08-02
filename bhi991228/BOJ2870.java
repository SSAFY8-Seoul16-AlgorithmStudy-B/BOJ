import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2870 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String str, temp;
		boolean prevIsNum = false;
		ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
		
		for (int i = 0; i < n; i++) {
			str = scan.next();
			temp = "";
			prevIsNum = false;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) < 'a') {
					//숫자일 때
					temp += str.charAt(j);
					prevIsNum = true;
				}else {
					//문자일 때
					if (prevIsNum) {
						numbers.add(new BigInteger(temp));
						temp = "";
						prevIsNum = false;
					}
				}
			}
			if (prevIsNum) numbers.add(new BigInteger(temp));
		}
		
		Collections.sort(numbers);
		for (BigInteger i : numbers) {
			System.out.println(i);
		}
	}

}
