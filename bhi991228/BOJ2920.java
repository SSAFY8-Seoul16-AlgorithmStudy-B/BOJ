import java.util.Scanner;

public class BOJ2920 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int prev = scan.nextInt();
		int n = 0;
		boolean asc = true;
		boolean desc = true;
		
		for (int i = 0; i < 7; i++) {
			n = scan.nextInt();
			if (asc && n != prev+1) asc = false;
			if (desc && n != prev-1) desc = false;
			prev = n;
		}
		
		if (asc) System.out.println("ascending");
		else if (desc) System.out.println("descending");
		else System.out.println("mixed");
	}

}
