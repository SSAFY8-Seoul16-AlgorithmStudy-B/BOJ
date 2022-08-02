import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		String str = "";
		int[] num =new int[5000];
		int count=0;
		for (int i=0; i<N;i++) {
			str = sc.next();
			for(int j=0;j<str.length();j++) {
				if(j>0&&str.charAt(j-1)>= 48&&str.charAt(j-1)<=57&&str.charAt(j)>= 48&&str.charAt(j)<=57) {
					num[count]= num[count]*10+str.charAt(j)-'0';
				}else if(str.charAt(j)>= 48&&str.charAt(j)<=57) {
					count++;
					num[count]= str.charAt(j)-'0';
				}
			}
		}
		Arrays.sort(num);
		for(int i =5000-count; i<5000; i++) {
			System.out.println(num[i]);
		}
		sc.close();
	}

}
