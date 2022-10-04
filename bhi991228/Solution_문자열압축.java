
public class Solution_문자열압축 {

	public static int solution(String s) {
		int answer = s.length();
		
		for (int subSize = 1; subSize <= s.length()/2; subSize++) {
			String baseStr = s.substring(0, subSize);
			int startIdx = subSize;
			String answerStr = "";
			int n = 1;
			
			for (int end = s.length(); startIdx <= end; startIdx+=subSize) {
				String temp = s.substring(startIdx, (startIdx+subSize <= s.length()) ? startIdx+subSize : s.length());
				
				if (baseStr.equals(temp)) n++;
				else {
					answerStr += (n > 1) ? n : "";
					answerStr += baseStr;
					baseStr = temp;
					n = 1;
				}
			}
			
			answerStr += baseStr;
			answer = Math.min(answer, answerStr.length());
		}
		
		return answer;
	}
}
