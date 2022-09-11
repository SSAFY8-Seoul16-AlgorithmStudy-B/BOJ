package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_s5_2751_함철훈 {
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		StringBuilder answer =new StringBuilder();
//		Arrays.sort(arr);
		
		pivot(0, N-1);		
		for(int i=0;i<N; i++) {
			answer.append(arr[i]).append("\n");
		}
		System.out.println(answer);
	}
	static void pivot(int start, int end) {
		if(start>=end) return;
		int pivot=arr[end];
		int i=start-1;
		int j=start;
		while(j!=end) {
			if(arr[j]>pivot) {
				j++;
				if(j==end) {
					System.out.println("end:"+end+"i"+i);
					swap(++i,end);
					pivot(0,i-1);
					pivot(i+1,end);
					break;
				}
			}else {
				i++;
				if(i==j) j++;
				else	swap(i,j);
			}
		}
		
		
	}
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]= temp;
	}
}
