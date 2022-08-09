import java.util.Scanner;

public class BOJ2747 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println(arr[n]);
    }
}
