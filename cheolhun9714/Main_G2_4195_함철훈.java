package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main_G2_4195_함철훈 {
	static HashMap<String,String> map; // map을 이용한 서로소집합을 위해 생성
	static HashMap<String,Integer> map2; // 두 사람의 친구 네트워크에 존재하는 사람수 저장
	
	static String find(String a) {
		if(a.equals(map.get(a))) {
			return a;
		}
		map.replace(a, find(map.get(a)));
		return map.get(a);
	}
	
	static boolean union(String a, String b) {
		String aRoot = find(a);
		String bRoot = find(b);
		if(aRoot.equals(bRoot)) { //이미 네트워크가 이어진 경우
			System.out.println(map2.get(aRoot)); // 저장된 수 출력
			return false;
		}
		map.replace(bRoot, find(aRoot));//부모 노드를 바꾸어줌
		map2.replace(aRoot, map2.get(aRoot)+map2.get(bRoot));// 두 사람이 각각 가진 네트워크 인원 수를 더함
		System.out.println(map2.get(aRoot));//더해진 네트워크 인원수 출력
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int F =Integer.parseInt(br.readLine());
			map = new HashMap<>();
			map2 = new HashMap<>();
			for(int i=0; i<F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a=st.nextToken();
				String b=st.nextToken();
				if(!map.containsKey(a)) {
					map.put(a, a);//서로소 집합의 make 함수 대체
					map2.put(a, 1);//본인의 네트워크 인원수 1 저장
				}
				if(!map.containsKey(b)) {
					map.put(b, b);
					map2.put(b, 1);
				}
				
				union(a,b);
			}
			
		}
	}

}
