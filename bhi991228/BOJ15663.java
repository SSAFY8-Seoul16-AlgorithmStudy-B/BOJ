import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ15663 {

	static int N, M;
	static int[] input;
	static int[] numbers;
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		input = new int[N];
		numbers = new int[M];
		
		for (int i = 0; i < N; i++) {
			input[i] = scan.nextInt();
		}
		
		Arrays.sort(input); //증가하는 순서로 출력하기 위해 정렬
		permutation(0, 0);
	}
	
	private static void permutation(int cnt, int flag) {
		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
			for (int num : numbers) {
				sb.append(num+" ");
			}
			
			if (!set.contains(sb.toString())) {
				set.add(sb.toString());
				System.out.println(sb.toString());
			}
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) continue;
			numbers[cnt] = input[i];
			permutation(cnt+1, flag | 1 << i);
		}
	}
}
