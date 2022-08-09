import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int answer = a == b && a == c ?10000+ a*1000 :
			a == b || a == c ?1000+ a*100 : b == c ?1000+ b*100 :Math.max(a,Math.max(b, c))*100;
		System.out.println(answer);
	}
}
