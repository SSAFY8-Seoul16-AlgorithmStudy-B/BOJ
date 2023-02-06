import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
   static int[][] matrix, dp;

   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(in.readLine());
      matrix = new int[n][2];
      dp = new int[n][n]; // a, b, result

      StringTokenizer st;

      for (int i = 0; i < n; i++) {
         st = new StringTokenizer(in.readLine());
         matrix[i][0] = Integer.parseInt(st.nextToken());
         matrix[i][1] = Integer.parseInt(st.nextToken());
       //  Arrays.fill(dp[i], Integer.MAX_VALUE);
      }
      
      for (int i = 0; i < n - 1; i++) {
		dp[i][i+1] = mul(matrix[i][0], matrix[i][1], matrix[i+1][1]);
      }
   
      for (int i = 2; i < n; i++) {
		for (int j = 0; i + j < n; j++) {
			int k = i + j;
			dp[j][k] = Integer.MAX_VALUE;
			for (int z = j; z < k; z++) {
				dp[j][k] = Math.min(dp[j][z] + dp[z+1][k] + mul(matrix[j][0], matrix[z][1], matrix[k][1]), dp[j][k]);
			}
		}
	}
      System.out.println(dp[0][n-1]);

         //1, 5일때?
         /*

      * 경우의 수
      1. i-1(1, 4일 때)에서 최댓값 * 5 // 5를 결합 -> i-1일때가 (1234)이다
      2. 45를 결합 -> i-2일때가 (123)이다.
      3. 345를 결합 -> i-3일 때가 (12이다.)
      4. 45, 345, 2345, 12345 했을 때의 곱셈값과 최종 최댓값 갱신  
      */

     // i-1에서의 최댓값 * i - i-1까지 모든 행렬을 곱한 최댓값 결과행렬과 현재 행렬을 곱한다.

  
  
   }

   public static int mul (int a, int b, int c) {
      return a * b * c;
   }

}