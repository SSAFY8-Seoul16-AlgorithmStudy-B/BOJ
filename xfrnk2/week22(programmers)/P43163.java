package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P43163 {
	static int ans = Integer.MAX_VALUE;
	static String[] WA;
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = new String[] {"hot", "dot", "dog", "lot", "log", "cog"};
//		String[] words = new String[] {"hot", "dot", "dog", "lot", "log" };
		
		

		int res = solution(begin, target, words);
		System.out.println(res);
	}
	
	public static int solution(String begin, String target, String[] words) {
		Arrays.sort(words);
		WA = words;
		search(begin, target, 0, 0);
		return ans == Integer.MAX_VALUE ? 0 : ans;
		}
	
	public static void search(String now, String target, int cnt, long visit) {
        if (now == target) {
        	ans = Math.min(cnt, ans);
            return;
        }
        for (int i = 0; i < WA.length; i++) {
        	
        	int sameCnt = 0;
			for (int j = 0; j < WA[i].length(); j++) {
				// 문자열 길이만큼
				if (WA[i].charAt(j) == now.charAt(j)) sameCnt ++;
			}
			if (sameCnt == WA[i].length() - 1 && ((visit & (1 << i)) == 0)) {// 하나만 다른 경우
				search(WA[i], target, cnt + 1, visit | 1 << i);
			}
		}
       
        
    }
	}


