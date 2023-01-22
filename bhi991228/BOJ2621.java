import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2621 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int R = 0, B = 0, Y = 0, G = 0;
		int[] numbers = new int[10];
		ArrayList<Integer> numbersList = new ArrayList<Integer>(10);
		int max = 0, min = 10;
		boolean isContinue = true;
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String color = st.nextToken();
			if (color.equals("R")) R++;
			else if (color.equals("B")) B++;
			else if (color.equals("Y")) Y++;
			else if (color.equals("G")) G++;
			
			numbers[Integer.parseInt(st.nextToken())]++;
		}
		
		//각 숫자 개수 정보 list로 변환
		for (int i = 0; i < 10; i++) {
			numbersList.add(i, numbers[i]);
		}
		
		//숫자 min, max 설정
		for (int i = 1; i < 10; i++) if (numbers[i] != 0) min = Math.min(min, i);
		for (int i = 9; i >= 1; i--) if (numbers[i] != 0) max = Math.max(max, i);
		
		//숫자 연속 여부 체크
		for (int i = min; i < min+5; i++) {
			if (i > 9) {
				isContinue = false;
				break;
			}
			
			if (numbers[i] != 1) {
				isContinue = false;
				break;
			}
		}
		
		if (isContinue) {
			//숫자가 연속되는 경우
			
			if (R == 5 || B == 5 || Y == 5|| G == 5) {
				//색이 전부 같은 경우
				answer = Math.max(answer, 900+max);
			}else {
				//색이 전부 같지는 않은 경우
				answer = Math.max(answer, 500+max);
			}
		} else {
			//숫자가 연속되지 않는 경우
			
			if (numbersList.contains(4)) {
				//숫자 4개가 같은 경우
				answer = Math.max(answer, 800+numbersList.indexOf(4));
			}else if (numbersList.contains(3)) {
				if (numbersList.contains(2)) {
					//숫자 3개가 같고 나머지 2개도 같은 경우
					answer = Math.max(answer, 700+(numbersList.indexOf(3)*10)+numbersList.indexOf(2));
				}else {
					//숫자 3개가 같고 나머지는 다른 경우
					answer = Math.max(answer, 400+numbersList.indexOf(3));
				}
			}else if (numbersList.contains(2)) {
				if (Collections.frequency(numbersList, 2) > 1) {
					//숫자 2개가 같고 나머지 중 2개도 같은 경우
					answer = Math.max(answer, 300+(numbersList.lastIndexOf(2)*10)+numbersList.indexOf(2));
				}else {
					//숫자 2개가 같고 나머지는 다른 경우
					answer = Math.max(answer, 200+numbersList.indexOf(2));
				}
			}else {
				answer = Math.max(answer, 100+max);
			}
			
			if (R == 5 || B == 5 || Y == 5|| G == 5) {
				//색이 전부 같은 경우
				answer = Math.max(answer, 600+max);
			}
			
		}
		
		System.out.println(answer);
	}

}
