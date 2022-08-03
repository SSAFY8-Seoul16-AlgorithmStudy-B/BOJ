package cheolhun9714;

import java.util.Arrays;
import java.util.Scanner;

public class Main_s4_2621_함철훈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] color = new char[5];
		String input = new String("");
		int[] num = new int[5];
		int[] count = new int[10];
		int[] count_num = new int[10];
		int answer =0;
		boolean color_5 = true;
		for(int i=0; i<5;i++) {
			input = sc.nextLine();
			color[i] = input.charAt(0);
			num[i] = input.charAt(2)-'0';
			count[num[i]]++;
			count_num[num[i]]++;
			if(i>0&&color[i]!=color[i-1]) color_5=false;
		}
		
		if(color_5) {
			Arrays.sort(num);
			if(num[4] - num[0]==4) System.out.println(900+num[4]);
			else System.out.println(600+num[4]);
		}else {
			Arrays.sort(count_num);
			if(count_num[9]==4) {
				for(int i=1;i<10;i++) {
					if(count[i]==4) {
						System.out.println(i+800);
						break;
					}
				}
			}else if(count_num[9]==3 && count_num[8]==2) {
				for(int i=1;i<10;i++) {
					if(count[i]==3) {
						answer += 10*i; 
					}else if(count[i]==2) {
						answer+=i;
					}
				}
				System.out.println(answer+=700);
			}else if(count_num[9]==3) {
				for(int i=1;i<10;i++) {
					if(count[i]==3) {
						System.out.println(i+400);
						break;
					}
				}
			}else if(count_num[9]==2 && count_num[8]==2) {
				for(int i=9;i>0;i--) {
					if(count[i]==2&&answer==0) {
						answer += 10*i; 
					}else if(count[i]==2) {
						answer+=i;
					}
				}
				System.out.println(answer+300);
			}else if(count_num[9]==2) {
				for(int i=1;i<10;i++) {
					if(count[i]==2) {
						System.out.println(i+200);
						break;
					}
				}
			}else {
				Arrays.sort(num);
				if(num[4]-num[0]==4) {
					System.out.println(num[4]+500);
				}else {
					for(int i=9;i>0;i--) {
						if(count[i]==1) {
							System.out.println(i+100);
							break;
						}
					}
				}
			}
		}	
		sc.close();
	}

}
