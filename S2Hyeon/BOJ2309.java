import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
            sum += arr[i];
        }

        boolean check = false;
        int fake1 = 0;
        int fake2 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(check) {
                break;
            }
            for(int j = i + 1; j < arr.length; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    check = true;
                    fake1 = arr[i];
                    fake2 = arr[j];
                    break;
                }
            }
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != fake1 && arr[i] != fake2) {
                System.out.println(arr[i]);
            }
        }
    }
}
