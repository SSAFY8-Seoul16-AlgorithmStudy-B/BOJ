import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10799 {
    // BOJ_10799 쇠막대기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int stick = 0;
        int result = 0;
        int end = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '(')
                stick++;
            else {
                if(chars[i - 1] == '(') {
                    stick--;
                    result += stick;
                    result -= end;
                }
                else {
                    end++;
                }
            }
        }
        result += stick;
        System.out.println(result);
    }
}
