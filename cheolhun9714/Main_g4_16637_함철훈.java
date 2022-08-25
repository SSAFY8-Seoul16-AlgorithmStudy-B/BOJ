package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_g4_16637_함철훈 {
	static int[] numbers;
	static String str;
	static int length;
	static int answer=Integer.MIN_VALUE,temp_answer=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		str = br.readLine();
		length = str.length();
		numbers = new int[length+1];
		for(int i=0; i<=(length+1)/2;i++) {
			comb(length+1,2*i,0,2); //(str.length+1)C0, 2, 4, 6... (str.length+1)/2	
		}
		System.out.println(answer);
		
	}

	private static void comb(int n, int r, int cnt, int start) {
		if(r==cnt) {
//			System.out.println(Arrays.toString(numbers));
			calculate(numbers,r);
			if(answer< temp_answer) answer = temp_answer;
			temp_answer =0;
			return;
		}
		//cnt :뽑힌 괄호의 수, i:괄호의 위치 -> 홀수 번째(여는괄호)에 짝수의 수가 오는 것은 불가. 반대도 마찬가지
		//cnt가 짝수일 때 i는 홀수여야함
		//cnt가 홀수일 때 i는 짝수여야함
		
		for(int i=start; i<n;i++) { 
			if(cnt==0 && i%2==0) {
				numbers[0] = i;
				comb(n,r,1,i+1);
			}else if((cnt%2==1 && i%2==1&&numbers[cnt-1]==i-3)||(cnt%2==0&&i%2==0))
				//(숫자)괄호의 경우 제외		
			{
				numbers[cnt]=i;
				comb(n,r,cnt+1,i+1);
			}
		}
	}
	
	private static void calculate(int[] bracket, int r) {
		temp_answer += str.charAt(0)-'0'; 
		char op;
		if(r==0) {						// 괄호가 없으니 쭉 계산
			for(int i=1; i<length;i++) {
				op = str.charAt(i++);//연산자를 받고 i를 더해주어 숫자를 바로 받음
				switch(op) {
				case '+':
					temp_answer+=str.charAt(i)-'0';
					break;
				case '-':
					temp_answer-=str.charAt(i)-'0';
					break;
				case '*':
					temp_answer*=str.charAt(i)-'0';
					break;
				default:
					break;
				}
			}
		}else {	//괄호가 존재할 경우
			int bracket_answer=0;
			for(int i=0; i<r;i++) {				
				for(int j =1; j<length;j++) {	
					if(j==bracket[i]-1) {
						bracket_answer=str.charAt(j+1)-'0';
						op = str.charAt(j+2);
						switch(op) {
						case '+':
							bracket_answer+=str.charAt(j+3)-'0';
							break;
						case '-':
							bracket_answer-=str.charAt(j+3)-'0';
							break;
						case '*':
							bracket_answer*=str.charAt(j+3)-'0';
							break;
						default:
							break;
						}
						op = str.charAt(j);
						switch(op) {
						case '+':
							temp_answer+=bracket_answer;
							break;
						case '-':
							temp_answer-=bracket_answer;
							break;
						case '*':
							temp_answer*=bracket_answer;
							break;
						default:
							break;
						}
						j+=3;
						i+=2;
						continue;
					}
					// 괄호부분이 아니라면?
					op = str.charAt(j++);//연산자를 받고 i를 더해주어 숫자를 바로 받음
					switch(op) {
					case '+':
						temp_answer+=str.charAt(j)-'0';
						break;
					case '-':
						temp_answer-=str.charAt(j)-'0';
						break;
					case '*':
						temp_answer*=str.charAt(j)-'0';
						break;
					default:
						break;
					}
				}
			}
//			System.out.println(temp_answer);
			
		}
	}
}
