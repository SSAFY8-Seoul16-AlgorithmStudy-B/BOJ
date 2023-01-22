import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ11729 {

	static int cnt = 0;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder stringBuilder = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		hanoi(N, 1, 2, 3);
		bw.write(cnt+"\n");
		bw.write(stringBuilder.toString());
		bw.flush();
	}
	
	public static void hanoi(int no, int from, int temp, int to) {
		if (no == 0) return;
		
		hanoi(no-1, from, to, temp);
		cnt++;
		stringBuilder.append(from).append(" ").append(to).append("\n");
		hanoi(no-1, temp, from, to);
	}

}
