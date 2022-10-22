import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, E, ans = 0;
	static ArrayList<Integer>[] nodes;
	static ArrayList<Integer>[] tree;
	static int[] weights;
	static int[] dp;
	static boolean[] visit;
	static List<Integer> order = new ArrayList<>();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		E = N - 1;
		nodes = new ArrayList[N+1];
		tree = new ArrayList[N+1];
		weights = new int[N+1];
		visit = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
			nodes[i] = new ArrayList<Integer>(2);
			tree[i] = new ArrayList<Integer>(2);
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			nodes[from].add(to);
			nodes[to].add(from);
		}
		
		makeTree(1, Integer.MAX_VALUE);
		int notSelectedChoice = dfs(1, false);
		int selectedChoice = dfs(1, true);
		
		visit[1] = notSelectedChoice < selectedChoice;
		StringBuilder sb = new StringBuilder();
		sb.append(Math.max(selectedChoice, notSelectedChoice) + "\n");
		search(1, visit[1]);
		Collections.sort(order);
		for (Integer i : order) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString());
	}
	
	public static void makeTree (int cur, int parent) {
		for (int child : nodes[cur]) {
			if (child != parent) {
				tree[cur].add(child);
				makeTree(child, cur);
			}
		}
	}
	
	public static int dfs(int cur, boolean selected) {
		int res = 0;
		if (selected) { // 선택했다면
			
			for (int child : tree[cur]) {
				res += dfs(child, false);				
			}
			return res + weights[cur];
		} 
		// 선택하지 않았다면, 이후 선택할지 선택하지 않을지 분기 필요
			
			for (int child : tree[cur]) {
				int notSelectedChoice = dfs(child, false);
				int selectedChoice = dfs(child, true);
				
				visit[child] = notSelectedChoice < selectedChoice;
				res += Math.max(notSelectedChoice, selectedChoice);
			}
		return res;
		
	}	
	
	public static void search(int cur, boolean selected) {
		if (selected) {
			order.add(cur);
			for (int child : tree[cur]) {
				search(child, false);
			}
			return;
		} 
		for (int child : tree[cur]) {
			search(child, visit[child]);
		}
	}

	
}