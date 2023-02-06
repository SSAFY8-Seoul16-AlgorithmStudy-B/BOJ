import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
	static String pattern = "(100+1+|01)+";
	
	public static boolean check(String str) {

		return	Pattern.matches(pattern, str)
				;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < n; i++) {
			
			boolean res = check(in.readLine());
			System.out.println(res ? "YES" : "NO");
		}
		

	}

}
