import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge {
	int direction, value;

	Edge(int direction, int value) {
		this.direction = direction;
		this.value = value;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int melon = sc.nextInt();
		List<Edge> edges = new ArrayList<>(6);

		for (int i = 0; i < 6; i++) {
			edges.add(new Edge(sc.nextInt(), sc.nextInt()));
		}

		solution(melon, edges);
	}

	public static void solution(int melon, List<Edge> edges) {
		int bw = 0, bh = 0, bwi = 0, bhi = 0;

		for (int i = 0; i < edges.size(); i++) {
			int d = edges.get(i).direction;
			int v = edges.get(i).value;
			if (d == 1 || d == 2) {
				if (bw < v) {
					bw = v;
					bwi = i;
				}
			} else if (d == 3 || d == 4) {
				if (bh < v) {
					bh = v;
					bhi = i;
				}
			}
		}

		int low = bwi - 1;
		if (low < 0)
			low = 6 + low;
		int high = bwi + 1;
		if (6 <= high)
			high = 0;

		int sw = Math.abs(edges.get(low).value - edges.get(high).value);

		low = bhi - 1;
		if (low < 0)
			low = 6 + low;
		high = bhi + 1;
		if (6 <= high)
			high = 0;

		int sh = Math.abs(edges.get(low).value - edges.get(high).value);

		System.out.print(melon * (bw * bh - sw * sh));
	}
}
