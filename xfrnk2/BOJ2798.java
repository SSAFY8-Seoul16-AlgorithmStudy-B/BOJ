import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++){
            numbers[i] = in.nextInt();
        } 
        int answer = search(numbers, N, M);
        System.out.println(answer);
    }
    
    static int search (final int[] numbers, final int N, final int M) {
        int result = 0;
        for (int i = 0; i < N - 2; i++){
            for (int j = i + 1; j < N - 1; j++){
                for (int k = j + 1; k < N; k++){
                    int temp = numbers[i] + numbers[j] + numbers[k];
                    
                    if (temp == M){
                        return temp;
                    }
					if(result < temp && temp < M) {
						result = temp;
					}
                }
        }
    }
        return result;
}
}