import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class BOJ17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean isInTag = false;
		char[] input = br.readLine().toCharArray();
		LinkedList<Character> deque = new LinkedList<>();
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '<') {
				//태그의 시작이 입력된 경우
				while (deque.size() > 0) {
					//이전에 입력된 것이 있다면 뒤집어서 출력
					bw.write(deque.pollLast());
				}
				deque.add('<');
				isInTag = true;
				
			} else if(input[i] == '>') {
				//태그의 종료가 입력된 경우
				deque.add('>');
				while (deque.size() > 0) {
					//<태그 내용>을 뒤집지 않고 출력
					bw.write(deque.poll());
				}
				isInTag = false;
				
			} else if(input[i] == ' ' && !isInTag) {
				//태그 내의 공백이 아닌 경우
				while (deque.size() > 0) {
					//이전에 입력된 것이 있다면 뒤집어서 출력
					bw.write(deque.pollLast());
				}
				bw.write(' ');
			} else {
				//나머지의 경우 덱에 추가
				deque.add(input[i]);
			}
		}
		
		while (deque.size() > 0) {
			//출력 안 된것이 있다면 뒤집어서 출력
			bw.write(deque.pollLast());
		}
		bw.flush();
	}
}
