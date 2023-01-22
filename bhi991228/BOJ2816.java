import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2816 {

	public static Object[] move(int targetIndex, int now, boolean isKBS1, List<String> list) {
		
		Object[] returnValue = new Object[2];
		String answer = "";
		int n = 0;
		if (!isKBS1) n = 1;
		
		while (targetIndex != n) {
			if (targetIndex > now) {
				if (targetIndex - now > 1) {
					for (int i = 0; i < targetIndex-now-1; i++) {
						answer += "1";
					}
					now += targetIndex - now - 1;
				} else {
					if (targetIndex == n+1) {
						list.remove(targetIndex);
						list.add(now, " ");
						answer += "3";
						targetIndex -= 1;
						now += 1;
					} else {
						answer += "1";
						now += 1;
					}
				}
			} else if (targetIndex < now) {
				for (int i = 0; i < now - targetIndex; i++) {
					answer += "2";
				}
				now -= now - targetIndex;

				list.remove(targetIndex);
				list.add(now-1, " ");
				answer += "4";
				targetIndex -= 1;
				now -= 1;
			} else {
				list.remove(targetIndex);
				list.add(now-1, " ");
				answer += "4";
				targetIndex -= 1;
				now -= 1;
			}
		}
		
		returnValue[0] = now;
		returnValue[1] = answer;
		
		return returnValue;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		int now = 0;
		int kbs1 = -1, kbs2 = -1;
		String answer = "";
		
		int n = scan.nextInt();
				
		for (int i = 0; i < n; i++) {
			list.add(scan.next());
		}
		
		for (int i = 0; i < n; i++) {
			if (kbs1 == -1 && list.get(i).equals("KBS1")) kbs1 = i;
			if (kbs2 == -1 && list.get(i).equals("KBS2")) kbs2 = i;
			if (kbs1 != -1 && kbs2 != -1) break;
		}
		
		Object[] temp = move(kbs1, now, true, list);
		now = (int)temp[0];
		answer += (String)temp[1];

		for (int i = 0; i < n; i++) {
			if (list.get(i).equals("KBS2")) {
				kbs2 = i;
				break;
			}
		}
		
		temp = move(kbs2, now, false, list);
		answer += (String)temp[1];
		
		System.out.println(answer);
	}

}
