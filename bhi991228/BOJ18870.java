import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ18870 {

	static class Num implements Comparable<Num>{
		int index;
		int value;
		int answer;
		public Num(int index, int value) {
			this.index = index;
			this.value = value;
		}
		@Override
		public int compareTo(Num o) {
			return this.value - o.value;
		}
	}
	
	static Comparator<Num> sortIdx = new Comparator<Num>() {
		@Override
		public int compare(Num o1, Num o2) {
			return o1.index - o2.index;
		}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Num> list = new ArrayList<>(N);
		
		for (int i = 0; i < N; i++) {
			list.add(new Num(i, Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		Num now, prev;
		prev = list.get(0);
		prev.answer = 0;
		
		for (int i = 1; i < N; i++) {
			now = list.get(i);
			
			if (now.value == prev.value) {
				now.answer = prev.answer;
			} else {
				now.answer = prev.answer+1;
			}
			
			prev = now;
		}
		
		Collections.sort(list, sortIdx);
		
		for (Num num : list) {
			sb.append(num.answer+" ");
		}
		
		System.out.print(sb.toString());
	}

}
