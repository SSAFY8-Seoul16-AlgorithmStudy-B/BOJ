import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ_12904 A와 B
public class BOJ_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder();
        StringBuilder T = new StringBuilder();

        S.append(br.readLine());
        T.append(br.readLine());

        // S와 T의 길이가 같아질때까지 반복
        while(T.length() != S.length()) {
            char c = T.charAt(T.length() - 1);  // T의 마지막 글자 얻기
            T.deleteCharAt(T.length() - 1); // T의 마지막 글자 삭제

            if(c == 'B') {  // T의 마지막 글자가 B였다면
                T.reverse();    // 뒤집기
            }
        }

        if(T.toString().equals(S.toString())) { // T와 S가 같다면
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
