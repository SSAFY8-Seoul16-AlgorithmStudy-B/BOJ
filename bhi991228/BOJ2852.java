import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ2852 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int team=0, tempSec=0, min = 0, sec = 0;
		int winSec1 = 0, winSec2 = 0;
		int[] winTime = new int[3];
		
		for (int i = 0; i < n; i++) {
			team = scan.nextInt();
			winTime[team]++;
			StringTokenizer st = new StringTokenizer(scan.next(), ":");
			min = Integer.parseInt(st.nextToken());
			sec = Integer.parseInt(st.nextToken());
			
			if (team == 1) {
				if ((winTime[1] > winTime[2]) && (winTime[1]-winTime[2] == 1)) 
					tempSec += min*60+sec;
				else if (winTime[1] == winTime[2]) {
					winSec2 += (min*60+sec) - tempSec;
					tempSec = 0;
				}
			}else {
				if ((winTime[1] < winTime[2]) && (winTime[2]-winTime[1] == 1)) 
					tempSec += min*60+sec;
				else if (winTime[1] == winTime[2]) {
					winSec1 += (min*60+sec) - tempSec;
					tempSec = 0;
				}
			}
		}

		if (winTime[1] > winTime[2]) {
			winSec1 += (48 * 60) - tempSec;
		} else if (winTime[1] < winTime[2]) {
			winSec2 += (48 * 60) - tempSec;
		}
		
		System.out.printf("%02d:%02d%n", winSec1/60, winSec1%60);
		System.out.printf("%02d:%02d%n", winSec2/60, winSec2%60);
	}

}
