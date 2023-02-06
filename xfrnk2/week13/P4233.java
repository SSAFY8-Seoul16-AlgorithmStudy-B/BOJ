import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean isPrime(long p) {
		if (p == 0) return false;
		if (p % 2 == 0) {
			if (p == 2) return true;
			return false;
		}
		for (int i = 3; i <= Math.sqrt(p); i+= 2) {
			if (p % i == 0) return false; 
		}
		return true;
	}
	
	public static long pow (long a, long p, long mod) {
		long res = 1;
		while (0 < p) {
			if ((p & 1) == 1) {
				res = res * a % mod;
			}
			a = (long) a * a % mod;
			p >>= 1;
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(in.readLine());
			long p = Long.valueOf(st.nextToken());
			long n = Long.valueOf(st.nextToken());
			if (n == 0 && p == 0) {
				break;
				}
			
			if (isPrime(p)) {
				sb.append("no\n");
			} else {
				if (pow(n, p, p) == n) {
					sb.append("yes\n");
				} else {
					sb.append("no\n");
				}
			}
			
			
			}
		System.out.println(sb.toString());
		}

}
