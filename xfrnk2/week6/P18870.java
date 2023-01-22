import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[] input = new long[N];

		HashMap<Long, Long> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}
		List<Long> listToSort = new ArrayList<>();
		for (Long elem : input) {
			listToSort.add(elem);
		}

		Set<Long> set = new HashSet<>(listToSort);
		listToSort = new ArrayList<>(set);
		Collections.sort(listToSort, null);

		long idx = 0;

		for (Long elem : listToSort) {
			map.put(elem, idx++);
		}

		StringBuilder sb = new StringBuilder();
		for (Long elem : input) {
			sb.append(map.get(elem) + " ");
		}
		System.out.println(sb.toString());

	}

}
