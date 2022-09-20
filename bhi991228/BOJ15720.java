import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ15720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int burger = Integer.parseInt(st.nextToken());
		int side = Integer.parseInt(st.nextToken());
		int drink = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> burgers = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> sides = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> drinks = new PriorityQueue<>(Collections.reverseOrder());
		int oriCost = 0, disCost = 0;
		int temp = 0;
		int setNum = 0;
		setNum = Math.min(burger, side);
		setNum = Math.min(setNum, drink);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < burger; i++) {
			temp = Integer.parseInt(st.nextToken());
			oriCost += temp;
			burgers.add(temp);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < side; i++) {
			temp = Integer.parseInt(st.nextToken());
			oriCost += temp;
			sides.add(temp);
		}
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < drink; i++) {
			temp = Integer.parseInt(st.nextToken());
			oriCost += temp;
			drinks.add(temp);
		}
		
		for (int i = 0; i < setNum; i++) {
			disCost += (burgers.poll() + sides.poll() + drinks.poll());
		}
		
		System.out.println(oriCost);
		System.out.println(((int)(disCost*0.9))+(oriCost-disCost));
	}
}
