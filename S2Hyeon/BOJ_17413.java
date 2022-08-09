import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_17413 {

    // BOJ_17413 단어 뒤집기 2
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        char[] chars = br.readLine().toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '<') {
                while(!stack.isEmpty())
                    bw.write(stack.pop());
                while(chars[i] != '>')
                    bw.write(chars[i++]);
                bw.write('>');
            }
            else if(chars[i] == ' ') {
                while(!stack.isEmpty())
                    bw.write(stack.pop());
                bw.write(' ');
            }
            else {
                stack.push(chars[i]);
            }
        }
        while(!stack.isEmpty())
            bw.write(stack.pop());
        bw.flush();

    }


}
