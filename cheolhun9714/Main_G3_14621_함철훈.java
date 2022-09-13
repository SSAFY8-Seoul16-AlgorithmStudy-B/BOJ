package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G3_14621_함철훈 {
	static int N;
	static int parents[];
	
//	서로소 집합 생성
	static void make() {
		parents = new int[N+1];
		for(int i=1; i<=N;i++) {
			parents[i] = i;
		}
	}
	
//	서로소 집합 부모 찾기
	static int find(int a) {
		if(parents[a] ==a) return a;
		return parents[a] = find(parents[a]);
	}
	
//	서로소 집합 union
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[] gender = new char[N+1];
		String str = br.readLine();
		for(int i=1; i<=N;i++) {
			gender[i] = str.charAt(2*i-2);
		}
		
		LinkedList<int[]> cost = new LinkedList<>();
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(gender[x]==gender[y]) continue; // M, M 일 때와 W, W 일 경우 연결하지 않음
			cost.add(new int[] {x,y,weight});// M , W가 연결되었다면 cost에 추가
		}
		
		make();
		Collections.sort(cost,new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2]; //cost 낮은 순으로 정렬
			}
		});
		int answer=0, count=0;
		for(int i=0; i<cost.size();i++) {			
			if(union(cost.get(i)[0],cost.get(i)[1])) {
				answer+=cost.get(i)[2];	//연결되지 않아 있어 서로소 였을 경우 가중치만큼 +
				count++;
			}
		}
		System.out.println(count==N-1? answer:-1); // 간선의 수가 N-1일 경우 모두 연결 되었으므로 정답 출력, 아닐시 -1출력
	}
}
