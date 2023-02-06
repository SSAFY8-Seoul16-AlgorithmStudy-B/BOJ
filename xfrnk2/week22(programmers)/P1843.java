package programmers;

import java.util.Arrays;

public class P1843 {
	public static void main(String[] args) {
		String[] arr = new String[] {"1", "-", "3", "+", "5", "-", "8"};
		String[] arr2 = new String[] {"5", "-", "3", "+", "1", "+", "2", "-", "4"};
		System.out.println(solution(arr));
	}
	
	public static int cal(String op, int a, int b) {
		int res = 0;
		if (op == "-") {
			res = a - b;
		} else {
		res = a + b;
		}
		System.out.println("res" + res);
		return res;
	}
	
    public static int solution(String arr[]) {
    	int size = arr.length;
    	System.out.println(size);
    	int numberSize = size / 2 + 1;
    	
        int[] numbers = new int[numberSize];
        String[] operators = new String[size/ 2];
        for (int i = 0; i < size; i++) {
			if (i % 2 == 0) {
				numbers[i / 2] = Integer.valueOf(arr[i]);
			} else {
				operators[i / 2] = arr[i];
			}
		}
        
        int[][] dp = new int[numberSize][numberSize];
        
        
        for (int i = 0; i < numberSize; i ++) {
        	Arrays.fill(dp[i], -1000 * 101);
			dp[i][i] = numbers[i];
			for (int j = i; j < size / 2; j++) {
				
				dp[j][j + 1] = cal(operators[j], numbers[j], numbers[j + 1]);
				System.out.println(i + " " + j + " " + operators[j] + " " + numbers[j] + " " + numbers[j + 1]);
			}
		}
        for (int i = 0; i < numberSize; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
        
//        System.out.println(Arrays.toString(numbers));
//        System.out.println(Arrays.toString(operators));
        
        for (int k = 1; k < numberSize; k++) { // 간격
			for (int i = 0; i < numberSize; i++) {
				int max = i + k;
				if (numberSize <= max) continue; // 범위를 벗어나면 continue
				//0 ~ 3 ? max 3임
//				dp[i][i + k] = cal(operators[i + k - 1], dp[i][i + k - 1], dp[i + k][i + k]);
//				dp[i][i + k] = cal(operators[i + k - 2], dp[i][i + k - 2], dp[i + k - 1][i + k]);
//				dp[i][i + k] = cal(operators[i + k - 3], dp[i][i + k - 3], dp[i + k - 2][i + k]);
				
				for (int j = 1; j <= max; j++) {
					if (i > max - j) continue;
//					System.out.println(i);
//					System.out.println(j);
//					System.out.println(max);
//					System.out.println(i + " ~ " + (max - j) + " , " + (max - j + 1) + " ~ " + max);
//					System.out.println("before" + dp[i][max]);
					dp[i][max] = Math.max(dp[i][max], cal(operators[max - j], dp[i][max - j], dp[max - j + 1][max]));	
					//System.out.println("after" + dp[i][max]);
				}
				//System.out.println("dp" + "[" + i + "][" + max + "] : " + dp[i][max]);
				
				// 5개인 경우, dp[1][5] ? -> dp[1][4] + dp[5][5] -> cal(o[4], dp[1][4], dp[5][5]);
						// dp[1][3]  + dp[4][5]
						// dp[1][2] + dp[3][5]
						//dp[1][1] + dp[2][5]
			}
		}
        
//        for (int i = 0; i < numberSize; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
//        
        int answer = dp[0][numberSize - 1];
        return answer;
    }
}
