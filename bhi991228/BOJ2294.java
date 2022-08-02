import java.util.Arrays;
import java.util.Scanner;

public class BOJ2294 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] coins = new int[n];
		int[] useCoinsNum = new int[k+1];
		Arrays.fill(useCoinsNum, Integer.MAX_VALUE); //n원을 만들 최소 개수를 int 최대 값으로 세팅
		
		for (int i = 0; i < n; i++) {
			coins[i] = scan.nextInt();
			
			//동전 가치와 동일한 값은 최소 개수 1개
			if (coins[i] <= k) useCoinsNum[coins[i]] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			int coin = coins[i]; //단위
			
			if (coin > k) {
				//현재 금액 단위가 만들어야하는 금액보다 크면 continue
				continue;
			}
			
			for (int j = coin+1; j < k+1; j++) {
				if (useCoinsNum[j-coin] != Integer.MAX_VALUE) { //j-coin 원을 만들 수 있는 경우가 있을 때
					//현재까지 나온 (j원을 만들 최소 개수)와 (j-coin을 만들 최소 개수 + 1개) 중 더 적은 개수로 저장
					useCoinsNum[j] = Math.min(useCoinsNum[j], useCoinsNum[j-coin]+1);					
				}
			}
		}
		
		if (useCoinsNum[k] != Integer.MAX_VALUE) System.out.println(useCoinsNum[k]);
		else System.out.println(-1);
	}

}
