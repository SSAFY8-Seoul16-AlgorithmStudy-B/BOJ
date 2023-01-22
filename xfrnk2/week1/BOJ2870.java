import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}

		solution(n, arr);

	}

	public static void solution(int n, String[] arr) {
		List<String> results = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < arr[i].length(); j++) {
				if (Character.isDigit(arr[i].charAt(j))) {
					sb.append(arr[i].charAt(j));
				} else {
					if (sb.length() > 0) {
						results.add(sb.toString());
						sb = new StringBuilder();
					}
				}

			}
			if (sb.length() > 0) {
				results.add(sb.toString());
			}

		}

		List<BigInteger> intList = new ArrayList<>();

		for (String elem : results) {
			intList.add(new BigInteger(String.valueOf(elem)));
		}

		Collections.sort(intList);

		StringBuilder sb = new StringBuilder();
		for (BigInteger elem : intList) {
			sb.append(elem).append("\n");
		}
		System.out.print(sb);
	}

}
