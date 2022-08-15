import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {

	static int K;
	static int[] input;
	static int[] numbers = new int[6];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if (K == 0) break;
			
			sb = new StringBuilder();
			input = new int[K];
			for (int i = 0; i < K; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			System.out.println(sb.toString());
		}
	}

	private static void combination(int cnt, int start) {
		if (cnt == 6) {
			for (int i : numbers) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < K; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}
}
