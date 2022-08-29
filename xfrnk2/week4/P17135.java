import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, ans = 0;
	static int[][] fiO;
	
	static ArrayList<Integer> archer = new ArrayList<Integer>(3);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		fiO = new int[N][M];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				fiO[i][j] = Integer.parseInt(st.nextToken());
			}
			//System.out.println(Arrays.toString(fiO[i]));
		}
		combination(0, 0);
		System.out.println(ans);
	}
	
	
	public static void combination(int cnt, int start) {
		if (cnt == 3) {
			int[][] fi = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					fi[i][j] = fiO[i][j];
				}
			}
			//System.out.println(archer);
			attack(fi);
		}
		for (int i = start; i < M; i++) {
			archer.add(i);
			combination(cnt + 1, i + 1);
			archer.remove(archer.size()-1);
		}
	}
	
	public static void attack(int[][] fi) {
		int killCount = 0;
		for (int height = N - 1; height >= 0; height --) {
			//System.out.println("height " + height);
			ArrayList<int[]> enemy = new ArrayList<int[]>();
			
			for (int k = 0; k < 3; k++) {

			int archerX = height + 1;
			int archerY = archer.get(k);
			
			int x = -1, y = -1, dis = Integer.MAX_VALUE; // enemy
			//System.out.println(archerX + " " + archerY );
			for (int i = height, iend = height - D < 0 ? -1 : height - D ; i > iend; i--) {
				for (int j = 0; j < M; j++) {
					//System.out.println(i + " " + j);
					if (fi[i][j] == 1) {
						int curDistance = Math.abs(archerX - i) + Math.abs(archerY - j);
						if (D < curDistance) continue;
						if (curDistance < dis) {
							x = i;
							y = j;
							dis = curDistance;
							continue;
							}
						if (curDistance == dis) {
							if (j < y) {
								x = i;
								y = j;
							}
						}
						}
				}
			}
			
			if (x == -1 && y == -1) {
				continue;
			}
			enemy.add(new int[] {x, y});
			
			
			}
			for (int[] target : enemy) {
				int tx = target[0], ty = target[1];
				if (fi[tx][ty] == 0) {
					continue;
				}
				fi[tx][ty] = 0;
				killCount ++;
			}
			//for (int i = 0; i < fi.length; i++) {
			//	System.out.println(Arrays.toString(fi[i]));
			//}
			//System.out.println("killcount" + killCount);
		}
		ans = Math.max(ans, killCount);
		
	}

}
