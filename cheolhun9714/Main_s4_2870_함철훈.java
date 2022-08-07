package cheolhun9714;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main_s4_2870_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		String str = "";
		BigInteger[] num =new BigInteger[5000];
		int count=0;
		for (int i=0; i<N;i++) {
			str = sc.next();
			for(int j=0;j<str.length();j++) {
				if(j>0&&str.charAt(j-1)>= 48&&str.charAt(j-1)<=57&&str.charAt(j)>= 48&&str.charAt(j)<=57) {
					num[count]= num[count].multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(str.charAt(j)-'0'));
				}else if(str.charAt(j)>= 48&&str.charAt(j)<=57) {
					count++;
					num[count]= BigInteger.valueOf(str.charAt(j)-'0');
				}
			}
		}
		BigInteger[] new_Array = Arrays.copyOfRange(num,1, count+1);
		Arrays.sort(new_Array);
		for(int i =0; i<new_Array.length; i++) {
			System.out.println(new_Array[i]);
		}
		sc.close();
	}

}
