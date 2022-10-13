package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P15720 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int B, C, D;

		B = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		D = Integer.valueOf(st.nextToken());

		String burgerInput = in.readLine();
		String sideInput = in.readLine();
		String beverageInput = in.readLine();
		solve(B, C, D, burgerInput, sideInput, beverageInput);
	}

	public static void solve(int B, int C, int D, String burger, String side, String beverage) {
		List<Integer> burgerList = new LinkedList<>();
		List<Integer> sideList = new LinkedList<>();
		List<Integer> beverageList = new LinkedList<>();
		StringTokenizer st;

		st = new StringTokenizer(burger);
		for (int i = 0; i < B; i++) {
			burgerList.add(Integer.valueOf(st.nextToken()));
		}
		st = new StringTokenizer(side);
		for (int i = 0; i < C; i++) {
			sideList.add(Integer.valueOf(st.nextToken()));
		}
		st = new StringTokenizer(beverage);
		for (int i = 0; i < D; i++) {
			beverageList.add(Integer.valueOf(st.nextToken()));
		}

		Collections.sort(burgerList, (a, b) -> b - a);
		Collections.sort(sideList, (a, b) -> b - a);
		Collections.sort(beverageList, (a, b) -> b - a);

		Queue<Integer> burgerQ = (Queue<Integer>) burgerList;
		Queue<Integer> sideQ = (Queue<Integer>) sideList;
		Queue<Integer> beverageQ = (Queue<Integer>) beverageList;

		int cnt = Math.max(Math.max(B, C), D);

		int notDiscounted = 0;
		int discounted = 0;

		for (int i = 0; i < cnt; i++) {
			boolean isDiscount = true;
			int total = 0;

			if (burgerQ.isEmpty()) {
				isDiscount = false;
			} else {
				total += burgerQ.poll();
			}

			if (sideQ.isEmpty()) {
				isDiscount = false;
			} else {
				total += sideQ.poll();
			}

			if (beverageQ.isEmpty()) {
				isDiscount = false;
			} else {
				total += beverageQ.poll();
			}

			if (isDiscount) {
				discounted += (int) total * 0.9;
				;
			} else {
				discounted += total;
			}
			notDiscounted += total;

		}
		System.out.println(notDiscounted);
		System.out.println(discounted);
	}

}
