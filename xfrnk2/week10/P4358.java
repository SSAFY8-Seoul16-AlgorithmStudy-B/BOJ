import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	static int total = 0;
	static List<Res> result = new ArrayList<>();

	static class Node {
		int cnt;
		Node[] child;

		public Node() {
			cnt = 0;
			child = new Node[96]; // 128 - 32(" ")
		}
	}

	static class Res {
		String str;
		float rate;

		public Res(String str, float f) {
			super();
			this.str = str;
			this.rate = f;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		Node root = new Node();
		while (true) {
			str = in.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			total++;
			add(root, str, 0, str.length());
		}
		search(root, new StringBuilder());

		Collections.sort(result, new Comparator<Res>() {
			@Override
			public int compare(Res o1, Res o2) {
				return o1.str.compareTo(o2.str);
			}
		});
		for (Res elem : result) {
			out.write(String.format("%s %.4f\n", elem.str, elem.rate));
		}
		out.flush();
		out.close();

	}

	private static void add(Node node, String str, int idx, int strSize) {
		if (idx == strSize) {
			node.cnt++;
			return;
		}
		int cur = str.charAt(idx) - 32;
		if (node.child[cur] == null) {
			node.child[cur] = new Node();
			add(node.child[cur], str, idx + 1, strSize);
			return;
		}
		add(node.child[cur], str, idx + 1, strSize);
	}

	private static void search(Node node, StringBuilder sb) {
		if (node.cnt != 0) { // 트리 내에서 문자열을 찾은 경우
			result.add(new Res(sb.toString(), (float) ((float) node.cnt / (float) total) * 100));
		}

		for (int j = 0; j < 96; j++) {
			int i = j + 32;
			if (node.child[j] != null) {
				sb.append((char) (j + 32));
				search(node.child[j], sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}

	}

}
