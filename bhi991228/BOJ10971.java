import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10971 {
	
	static int N;
	static int[][] map;
	static int[] citys;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		citys = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permutation(0, 0, 0);
		System.out.println(answer);
	}
	
	private static void permutation(int cnt, int flag, int sum) {
		if (cnt == N) {
			int back = map[citys[N-1]][citys[0]];
			if (back == 0) return;	//마지막 도시에서 첫 도시로 돌아올 길이 없으면 return
			
			answer = Math.min(answer, sum + back);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) continue;	//이미 방문한 도시는 무시
			
			if (cnt > 0) {	
				//이전에 방문한 도시가 있을 때
				int cost = map[citys[cnt-1]][i];						//직전에 방문한 도시->현재 가려는 도시 길의 비용
				if ((cost == 0) || (sum + cost >= answer)) continue; 	//길이 없거나 비용이 최소값이 아니게 되면 무시
				citys[cnt] = i;
				permutation(cnt+1, flag | 1 << i, sum + cost);
			}else {
				citys[cnt] = i;
				permutation(cnt+1, flag | 1 << i, sum);
			}
		}
	}
}
