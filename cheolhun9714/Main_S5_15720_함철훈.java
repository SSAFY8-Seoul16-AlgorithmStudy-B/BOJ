package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_S5_15720_함철훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		Integer[] burger = new Integer[B];
		int answer_before=0;
		st = new StringTokenizer(br.readLine());
		
		//메뉴들의 총액을 구하기 위해 더해줌
		for(int i=0; i<B; i++) {
			burger[i]= Integer.parseInt(st.nextToken());
			answer_before+=burger[i];
		}
		Integer[] side = new Integer[C];
		st = new StringTokenizer(br.readLine());
		
		//메뉴들의 총액을 구하기 위해 더해줌
		for(int i=0; i<C; i++) {
			side[i]= Integer.parseInt(st.nextToken());
			answer_before+=side[i];
		}
		Integer[] drink = new Integer[D];
		st = new StringTokenizer(br.readLine());

		//메뉴들의 총액을 구하기 위해 더해줌
		for(int i=0; i<D; i++) {
			drink[i]= Integer.parseInt(st.nextToken());
			answer_before+=drink[i];
		}
		//가격 차이 비교를 위한 값 복사
		int answer_after=answer_before;
		
		//할인을 최대로 받아야하므로 내림차순으로 정렬하여 앞부터 할인 받자!
		Arrays.sort(burger,Collections.reverseOrder());
		Arrays.sort(side,Collections.reverseOrder());
		Arrays.sort(drink,Collections.reverseOrder());
		
		//종류가 가장 적은 메뉴의 수만큼 할인이 진행되므로 가장 가짓수가 적은 것 찾기
		int temp = Math.min(B, C);
		int min = Math.min(temp, D);
		
		//그 수만큼 세가지 메뉴 다 10%할인
		for(int i=0; i<min; i++) {
			answer_after-=(burger[i]+side[i]+drink[i])*0.1;
		}
		System.out.println(answer_before);
		System.out.println(answer_after);
	}

}
