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
		
		//�� ���� ���� ���� list�� ��ȯ
		for (int i = 0; i < 10; i++) {
			numbersList.add(i, numbers[i]);
		}
		
		//���� min, max ����
		for (int i = 1; i < 10; i++) if (numbers[i] != 0) min = Math.min(min, i);
		for (int i = 9; i >= 1; i--) if (numbers[i] != 0) max = Math.max(max, i);
		
		//���� ���� ���� üũ
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
			//���ڰ� ���ӵǴ� ���
			
			if (R == 5 || B == 5 || Y == 5|| G == 5) {
				//���� ���� ���� ���
				answer = Math.max(answer, 900+max);
			}else {
				//���� ���� ������ ���� ���
				answer = Math.max(answer, 500+max);
			}
		} else {
			//���ڰ� ���ӵ��� �ʴ� ���
			
			if (numbersList.contains(4)) {
				//���� 4���� ���� ���
				answer = Math.max(answer, 800+numbersList.indexOf(4));
			}else if (numbersList.contains(3)) {
				if (numbersList.contains(2)) {
					//���� 3���� ���� ������ 2���� ���� ���
					answer = Math.max(answer, 700+(numbersList.indexOf(3)*10)+numbersList.indexOf(2));
				}else {
					//���� 3���� ���� �������� �ٸ� ���
					answer = Math.max(answer, 400+numbersList.indexOf(3));
				}
			}else if (numbersList.contains(2)) {
				if (Collections.frequency(numbersList, 2) > 1) {
					//���� 2���� ���� ������ �� 2���� ���� ���
					answer = Math.max(answer, 300+(numbersList.lastIndexOf(2)*10)+numbersList.indexOf(2));
				}else {
					//���� 2���� ���� �������� �ٸ� ���
					answer = Math.max(answer, 200+numbersList.indexOf(2));
				}
			}else {
				answer = Math.max(answer, 100+max);
			}
			
			if (R == 5 || B == 5 || Y == 5|| G == 5) {
				//���� ���� ���� ���
				answer = Math.max(answer, 600+max);
			}
			
		}
		
		System.out.println(answer);
	}

}
