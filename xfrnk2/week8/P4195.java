package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class P4195 {
	static int N;
	static int[] parents;
	static int[] friendCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(in.readLine());
			Map<String, Integer> map = new HashMap<>();

			parents = new int[N * 2];
			friendCnt = new int[N * 2];
			for (int i = 0, end = N * 2; i < end; i++) {
				friendCnt[i] = 1;
				parents[i] = i;
			}

			int index = 0;

			for (int i = 0; i < N; i++) {

				String[] input = in.readLine().split(" ");
				if (!map.containsKey(input[0])) {
					map.put(input[0], index++);
				}
				if (!map.containsKey(input[1])) {
					map.put(input[1], index++);
				}

				out.write(union(map.get(input[0]), map.get(input[1])) + "\n");

			}

		}
		out.flush();
	}

	public static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	public static int union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		if (aR != bR) {
			parents[bR] = aR;
			friendCnt[aR] += friendCnt[bR];
			friendCnt[bR] = 1;
		}
		return friendCnt[aR];
	}

}
