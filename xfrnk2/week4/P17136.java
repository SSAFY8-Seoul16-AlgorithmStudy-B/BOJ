import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int SIZE = 10, answer = Integer.MAX_VALUE;
	static int[] papers = new int[] {0, 5, 5, 5, 5, 5};
	
	static boolean [][] field;
	
	public static void main(String[] args) throws IOException {

		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
		

		field = new boolean[SIZE][SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				String input = st.nextToken();
				if (input.equals("1")) {
					field[i][j] = true;
				}
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	public static void fill(int x, int y, int size, boolean value) {
	       for (int i = x; i < x + size; i++) {
	            for (int j = y; j < y + size; j++) {
	                field[i][j] = value;
	            }
	        }
	}
	
    public static boolean checkIsAttachable(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                    return false;
                }
 
                if (!field[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void dfs(int x, int y, int cnt) {
        if (answer <= cnt) {
            return;
        }
        
        if (y > 9) {
        	if (x >= 9) {
        		answer = Math.min(answer, cnt);
                return;	
        	}
        	dfs(x + 1, 0, cnt);
            return;
        }
 
 
        if (field[x][y]) {
            for (int i = 5; i >= 1; i--) {
            	if (papers[i] <= 0 || !checkIsAttachable(x, y, i)) continue;
                    papers[i]--;
                    fill(x, y, i, false);
                    dfs(x, y + 1, cnt + 1);
                    papers[i]++;
                    fill(x, y, i, true); 
            }
        } else {
            dfs(x, y + 1, cnt);
        }
    }
 
}
