import java.util.Scanner;

public class BOJ2480 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[7];
        int max = 0;
        int result = 0;
        int index = 0;
        for(int i = 0; i < 3; i++) {
            arr[scan.nextInt()]++;
        }

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] >= max) {
                max = arr[i];
                index = i;
            }
        }

        if(max == 3) {
            result = 10000 + index * 1000;
        }
        else if(max == 2) {
            result = 1000 + index * 100;
        }
        else if(max == 1) {
            result = index * 100;
        }
        System.out.println(result);
    }
}