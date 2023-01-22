package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_14501_함철훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] money = new int[N+1];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if(i!=0&&money[i]<money[i-1]) {
				money[i]=money[i-1];
			}
			if(i+t<=N && money[i+t]< money[i]+p ) {
				money[i+t]=money[i]+p;
			}
		}
		System.out.println(money[N-1]>money[N]? money[N-1]:money[N]);
	}

}
