package cheolhun9714;
import java.util.Scanner;

public class Main_b2_2798_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] card = new int[N];
		int answer_dif =300000,dif = 300000, sum=0, answer=0;
		for (int i=0; i< N; i++) {
			card[i] = sc.nextInt();			
		}
		for (int i=0; i< N; i++) {
			for(int j=i+1;j<N;j++) {
				for (int k=j+1;k<N;k++) {
					sum = card[i]+card[j]+card[k];
					if (sum<=M) {						
						dif = M-sum;
						if (answer_dif>dif) {
							answer = sum;
							answer_dif = dif;
						}
					}
				}
			}
		}
		System.out.println(answer);
		
		sc.close();
	}

}
