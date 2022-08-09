import java.util.Scanner;

public class BOJ2798 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int sum = 0;
        int temp = 0;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    temp = arr[i] + arr[j] + arr[k];

                    if(temp > sum && temp <= M) {
                        sum = temp;
                    }

                }
            }
        }
        System.out.println(sum);

    }
}
