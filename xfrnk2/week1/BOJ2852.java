import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int winner = 0; // 음수면 1팀 승, 양수면 2팀 승
		int prevTime = 0;
		boolean flag = false;
		int team1 = 0, team2 = 0;

		while (n-- > 0) {
			int win = sc.nextInt();
			String[] input = sc.next().split("");
			int h = Integer.parseInt(input[0]) * 600;
			int m = Integer.parseInt(input[1]) * 60;
			int s1 = Integer.parseInt(input[3]) * 10;
			int s2 = Integer.parseInt(input[4]);
			int time = h + m + s1 + s2;
			int pWinner = winner;
			if (win == 1) {
				winner--;
			} else {
				winner++;
			}
			if (winner == 0) {
				flag = false;
				if (pWinner < 0)
					team1 += time - prevTime;
				if (pWinner > 0)
					team2 += time - prevTime;
			} else if (!flag) {
				prevTime = time;
				flag = true;
			}

		}
		if (winner < 0)
			team1 += 48 * 60 - prevTime;
		if (winner > 0)
			team2 += 48 * 60 - prevTime;

		System.out.printf("%02d:%02d\n", team1 / 60, team1 % 60);
		System.out.printf("%02d:%02d", team2 / 60, team2 % 60);

	}
}
