import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


        int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;
		int answer = 0;
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[][] bus = new int[3][2];
        for (int i = 0; i < 3; i ++) {
            bus[i][0] = sc.nextInt();
            bus[i][1] = sc.nextInt();
        }


		for (int[] ints : bus) {
			start = Math.min(start, ints[0]);
			end = Math.max(end, ints[1]);
		}

		int[] scores = new int[end];

		for (int i = start; i < end; i++) {
			for (int j = 0; j < 3; j ++) {
				if (bus[j][0] <= i && i < bus[j][1]) {
					scores[i]++;
				}
			}
		}
		for (int i = start; i < end; i++) {
			int cur = scores[i];
			if (cur == 3)
				answer += c * 3;
			else if (cur == 2)
				answer += b * 2;
			else if (cur == 1)
				answer += a;
		}

		System.out.print(answer);

	}
}
