package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P19583 {

	public static int convertStringTimeToMinute(String time) {
		String[] timeStr = time.split(":");
		int hour = Integer.parseInt(timeStr[0]);
		int minute = Integer.parseInt(timeStr[1]);
		return hour * 60 + minute;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int startTime = convertStringTimeToMinute(st.nextToken());
		int endTime = convertStringTimeToMinute(st.nextToken());
		int streamingEndTime = convertStringTimeToMinute(st.nextToken());

		Map<String, Boolean> record = new HashMap<>();
		String line = null;
		int ans = 0;

		while ((line = in.readLine()) != null) {
			String[] input = line.split(" ");
			int minute = convertStringTimeToMinute(input[0]);
			String name = input[1];
			if (minute <= startTime) {
				record.put(name, true);
				continue;
			}
			if (endTime <= minute && minute <= streamingEndTime) {
				if (record.containsKey(name) && record.get(name)) {
					ans++;
					record.put(name, false);
				}
			}
		}

		System.out.println(ans);
	}

}
