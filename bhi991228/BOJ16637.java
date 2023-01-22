import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16637 {

	static int N;
	static char[] exp;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		exp = br.readLine().toCharArray();
		
		makeResult(exp[0]-'0', 2, true); 
		System.out.println(answer);
	}

	private static void makeResult(int nowResult, int index, boolean canBrace) {		
		if(index > N) {
			answer = Math.max(answer, nowResult);
			return;
		}
		
		if (canBrace) { //이번에 괄호 사용 가능한 경우
			//그냥 지금까지 연산결과에 현재 index 계산
			makeResult(calc(nowResult, exp[index]-'0', exp[index-1]), index+2, true);
			
			//바로 연산안하고 괄호 열려고 하는 경우 (마지막 수일 경우는 해당 안됨)
			if (index < N-1) makeResult(nowResult, index+2, false);	//연산 결과와 괄호로 묶은 애들 앞의 결과 연산하여 넘김 (현재 괄호로 묶었기 때문에 바로 다음에선 괄호 사용 불가)
		} else { //괄호 사용 불가능한 경우
			//괄호가 이미 열렸으니 앞 인덱스와 먼저 연산 후 그 앞 결과와 연산
			int temp = calc(exp[index-2]-'0', exp[index]-'0', exp[index-1]);
			makeResult(calc(nowResult, temp, exp[index-3]), index+2, true);
		}
	}
	
	private static int calc(int n1, int n2, char oper) {
		if(oper == '+') return n1+n2;
		else if(oper == '-') return n1-n2;
		else return n1*n2;
	}
}
