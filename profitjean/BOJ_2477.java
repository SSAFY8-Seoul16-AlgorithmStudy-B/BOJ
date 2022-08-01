package July;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int width = 0;
		int height = 0;
		
		int width_idx = 0;
		int height_idx = 0;
		int max_width = 0;
		int max_height = 0;
		
		int square = 0;
		int min_square =0;
		
		int [][] map = new int[6][2];
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			// 공백기준으로 받아오기. 한줄로 쭈루룩
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < map.length; i++) {
			if (map[i][0]==1 || map[i][0]==2) {
				if (max_width <= map[i][1]) {
					max_width = map[i][1];
					width_idx = i;
				}
			} else if (map[i][0] ==3 || map[i][0] == 4) {
				if (max_height <= map[i][1]) {
					max_height = map[i][1];
					height_idx = i;
				}
			}
		}
		
		square = max_height * max_width;
		min_square = map[(width_idx+3)%6][1] * map[(height_idx+3)%6][1];
		System.out.println((square-min_square)*k);
		
		
		
	}
}
