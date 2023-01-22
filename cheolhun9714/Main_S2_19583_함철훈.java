package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_S2_19583_함철훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] S = new int[2];//시작시간
		int[] E = new int[2];//끝시간
		int[] Q = new int[2];//스트리밍종료시간
		//시간 입력
		S[0] = (str.charAt(0)-'0')*10 +str.charAt(1)-'0';
		S[1] = (str.charAt(3)-'0')*10 +str.charAt(4)-'0';
		E[0] = (str.charAt(6)-'0')*10 +str.charAt(7)-'0';
		E[1] = (str.charAt(9)-'0')*10 +str.charAt(10)-'0';
		Q[0] = (str.charAt(12)-'0')*10 +str.charAt(13)-'0';
		Q[1] = (str.charAt(15)-'0')*10 +str.charAt(16)-'0';
		int answer=0;
		HashMap<String, int[]> map = new HashMap<>();
		
		while((str=br.readLine())!=null) { //입력이 없을시 종료
			int[] time = new int[2];
			time[0] = (str.charAt(0)-'0')*10 +str.charAt(1)-'0';//시(HOUR)
			time[1] = (str.charAt(3)-'0')*10 +str.charAt(4)-'0';//분(MINUTE)
			if(time[0]<S[0] || (time[0]==S[0] && time[1] <=S[1])) {//시작하기 전에 입장한 경우
				map.put(str.substring(6), time);//이름이라는 key에 시각이라는 value 저장
			}else if((time[0]>E[0] || (time[0]==E[0] && time[1] >=E[1]))&&(time[0]<Q[0] || (time[0]==Q[0] && time[1] <=Q[1]))) {//끝난 시각과 스트리밍 종료시간 사이에 채팅을 쳤을 때
				if(map.containsKey(str.substring(6))) {//입장한 사람중에 있다면 
					map.remove(str.substring(6));	//제거
					answer++;
				}
			}//스트리밍 시간 이후는 버림
		}
		System.out.println(answer);
		
	}

}
