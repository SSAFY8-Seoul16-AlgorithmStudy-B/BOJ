import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int screen = scan.nextInt();
		int basketSize = scan.nextInt();
		int apple = scan.nextInt();
		int [] arr = new int [apple];
		
		int count = 0;

		for(int i = 0; i < apple; i++) {
			arr[i] = scan.nextInt();
		}
		
		int location = basketSize;

		for(int i = 0; i < apple; i++) {
			while(true) {
				if(arr[i] >= (location  - (basketSize - 1)) && arr[i] <= location) {
					break;
	
				}else {
					if(arr[i] > location) {
						count += 1;
						location += 1;
				
					}else {
						count += 1;
						location -= 1;
					
					}
				}
			}	
		}
		
		System.out.println(count);
	}
}
	