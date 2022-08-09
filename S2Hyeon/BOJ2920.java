import java.util.Scanner;

public class BOJ2920 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 8;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        int ascending = 0;
        int descending = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == i + 1)
                ascending++;
            if(arr[i] == n - i)
                descending++;
        }

        if(ascending == n) {
            System.out.println("ascending");
        }
        else if(descending == n) {
            System.out.println("descending");
        }
        else {
            System.out.println("mixed");
        }
    }
}
