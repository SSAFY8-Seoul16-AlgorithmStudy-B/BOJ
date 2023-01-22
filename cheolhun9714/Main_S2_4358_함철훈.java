package boj;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main_S2_4358_함철훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		String input;
		int count=0;
		while((input = br.readLine())!=null) {
			if(map.containsKey(input)) {
				map.put(input, map.get(input)+1);
			}else {
				map.put(input, 1);
			}
			count++;
		}
		ArrayList<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		
		StringBuilder answer = new StringBuilder();
		for(String key:keySet) {
			answer.append(key).append(" ");
			answer.append(String.format("%.4f",(double)map.get(key)*100/(count))).append("\n");
		}
		System.out.println(answer);
		
	}
}


