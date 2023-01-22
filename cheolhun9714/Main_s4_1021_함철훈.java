package cheolhun9714;

import java.util.Scanner;

public class Main_s4_1021_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int M= sc.nextInt();
		int cnt =0;
		int[] num = new int[M];
		for(int i=0;i<M;i++) {
			num[i] = sc.nextInt();
		}
		for(int i=0;i<M;i++) {
			if(num[i]<N-i+2-num[i]) {
				for(int j=i+1;j<M;j++) {
					num[j]-=num[i];
					if(num[j]<=0) {
						num[j]+=N-i;
					}
				}
				cnt+=num[i]-1;
			}else {
				for(int j=i+1;j<M;j++) {
					num[j]+=N-i-num[i];
					if(num[j]>N-i) {
						num[j]-=N-i;
					}
				}
				cnt+=N-i-num[i]+1;
			}
		}
		System.out.println(cnt);
		
	}

}
