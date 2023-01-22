import java.util.Arrays;
import java.util.Scanner;

public class BOJ2294 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] coins = new int[n];
		int[] useCoinsNum = new int[k+1];
		Arrays.fill(useCoinsNum, Integer.MAX_VALUE); //n���� ���� �ּ� ������ int �ִ� ������ ����
		
		for (int i = 0; i < n; i++) {
			coins[i] = scan.nextInt();
			
			//���� ��ġ�� ������ ���� �ּ� ���� 1��
			if (coins[i] <= k) useCoinsNum[coins[i]] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			int coin = coins[i]; //����
			
			if (coin > k) {
				//���� �ݾ� ������ �������ϴ� �ݾ׺��� ũ�� continue
				continue;
			}
			
			for (int j = coin+1; j < k+1; j++) {
				if (useCoinsNum[j-coin] != Integer.MAX_VALUE) { //j-coin ���� ���� �� �ִ� ��찡 ���� ��
					//������� ���� (j���� ���� �ּ� ����)�� (j-coin�� ���� �ּ� ���� + 1��) �� �� ���� ������ ����
					useCoinsNum[j] = Math.min(useCoinsNum[j], useCoinsNum[j-coin]+1);					
				}
			}
		}
		
		if (useCoinsNum[k] != Integer.MAX_VALUE) System.out.println(useCoinsNum[k]);
		else System.out.println(-1);
	}

}
