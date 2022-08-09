import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {

			String sentence = sc.nextLine();
			String[] strArr = sentence.split(" ");

			for (int j = 0; j < strArr.length; j++) {

				String word = strArr[j];
				String temp = "";
				for (int k = word.length() - 1; 0 <= k; k--) {
					temp += word.charAt(k);
				}
				System.out.print(temp + " ");
			}
		}
	}

}