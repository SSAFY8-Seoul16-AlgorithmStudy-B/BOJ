import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ19583 {

	static int startTime;
	static int endTime;
	static int finalTime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String chat;
		Map<String, Integer> check = new HashMap<String, Integer>();
		int nowTime = 0;	//0 대기시간~방송 시작 직후, 1 방송중, 2 방송 종료 직후~스트리밍 종료 직후, 3 스트리밍 종료 이후
		int answer = 0;
		
		//방송 시작, 방송 종료, 스트리밍 종료 시간 입력
		String[] temp;
		temp = st.nextToken().split(":");
		startTime = (Integer.parseInt(temp[0])*60)+Integer.parseInt(temp[1]);
		temp = st.nextToken().split(":");
		endTime = (Integer.parseInt(temp[0])*60)+Integer.parseInt(temp[1]);
		temp = st.nextToken().split(":");
		finalTime = (Integer.parseInt(temp[0])*60)+Integer.parseInt(temp[1]);
		
		while((chat = br.readLine()) != null) {
			st = new StringTokenizer(chat);
			String[] now = st.nextToken().split(":");
			String name = st.nextToken();
			
			//이 채팅의 시간대 확인
			nowTime = checkTime(now);
			
			if (nowTime == 0) {
				//대기시간~방송 시작 직후
				if (!check.containsKey(name)) {
					check.put(name, 1);
				}
				
			} else if (nowTime == 2) {
				//방송 끝 직후 ~ 스트리밍 끝 직후
				if (check.containsKey(name) && check.get(name) == 1) {
					check.replace(name, 2);
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static int checkTime(String[] nowStr) {
		int now = (Integer.parseInt(nowStr[0])*60) + Integer.parseInt(nowStr[1]);
		
		if (now > finalTime) {
			return 3;
		} else if (now >= endTime) {
			return 2;
		} else if (now > startTime) {
			return 1;
		} else {
			return 0;
		}
 	}
}
