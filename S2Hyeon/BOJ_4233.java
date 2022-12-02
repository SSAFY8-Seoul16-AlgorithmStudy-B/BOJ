import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// BOJ_4233 가짜소수
public class BOJ_4233 {

    static long MOD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            if(p == 0 && a == 0) {
                break;
            }

            MOD = p;

            if(isPrime(p)) {
                System.out.println("no");
            }
            else {
                if(pow(a, p) % MOD == a) {
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            }
        }
    }

    private static boolean isPrime(long p) {

        for(long i = 2; i * i <= p; i++) {
            if(p % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static long pow(long a, long p) {
        if(p == 1) {
            return a;
        }
        long n = pow(a, p / 2);
        long next = (n * n) % MOD;
        if(p % 2 == 0) {
            return next;
        }
        else {
            return (next * a) % MOD;
        }
    }
}
