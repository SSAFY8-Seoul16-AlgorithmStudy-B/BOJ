package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_16724_함철훈 {
	//서로소 집합 생성
	static int V;
	static int[] parents;
	static void make() {
		parents = new int[V];
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot]= aRoot;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		V = N*M;//1차원으로 변환
		make();
		int count=0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				switch(str.charAt(j)) {//화살표의 방향에 존재하는 칸과 같은 집합으로 연결
				case 'D':
					if(union(M*i+j,M*(i+1)+j)) count++; //새로 이어진 경우 간선의 수 증가
					break;
				case 'L':
					if(union(M*i+j,M*i+j-1)) count++;
					break;
				case 'U':
					if(union(M*i+j,M*(i-1)+j)) count++;
					break;
				case 'R':
					if(union(M*i+j,M*i+j+1)) count++;
					break;
				default:
					break;
				}
			}
		}
		System.out.println(V-count);//전체 node의 수-간선의 수 = 서로소 집합의 수
		
		
	}

}
