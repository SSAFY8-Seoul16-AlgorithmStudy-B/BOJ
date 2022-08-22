import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17471 {

	static int N;				//구역 개수
	static int[] population;	//구역 별 인구 수
	static boolean[][] map;		//인접 행렬
	static boolean[] isUnitA;	//선거구 A인지 여부
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		map = new boolean[N][N];
		isUnitA = new boolean[N];
		visited = new boolean[N];
		
		//자기 자신 구역은 인접한 것으로 표시
		for (int i = 0; i < N; i++) {
			map[i][i] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < n; j++) {
				map[i][Integer.parseInt(st.nextToken())-1] = true;
			}
		}
		
		//두 선거구 부분집합 생성
		makeSubset(0);
		
		System.out.println(answer < Integer.MAX_VALUE ? answer : -1);
	}

	private static void makeSubset(int cnt){
		if (cnt == N) {
			int gap = checkGap();
			if (gap > -1) answer = Math.min(answer, gap);
			return;
		}
		
		isUnitA[cnt] = true;
		makeSubset(cnt+1);
		
		isUnitA[cnt] = false;
		makeSubset(cnt+1);
	}

	private static int checkGap() {
		ArrayList<Integer> unitA = new ArrayList<Integer>();
		ArrayList<Integer> unitB = new ArrayList<Integer>();
		int sumA = 0, sumB = 0;
		
		for (int i = 0; i < N; i++) {
			if (isUnitA[i]) unitA.add(i);
			else unitB.add(i);
		}
		
		//한 선거구에 적어도 하나의 구역이 포함되지 않으면
		if (unitA.size() == 0 || unitA.size() == N) return -1;
		
		//같은 선거구끼리 인접되어 있는지 체크
		//선거구 A 체크
		for (int i = 0; i < unitA.size(); i++) {
			int area = unitA.get(i);
			
			for (int j = i+1; j < unitA.size(); j++) {
				int dest = unitA.get(j);
				if (map[area][dest]) continue;
				
				//바로 연결되지 않을 땐 같은 선거구를 통해 갈 수 있는지 체크
				Arrays.fill(visited, false);
				visited[area] = true;
				adjCheck(area);
				if (!visited[dest]) return -1;
			}
		}
		//선거구 B 체크
		for (int i = 0; i < unitB.size(); i++) {
			int area = unitB.get(i);
			
			for (int j = i+1; j < unitB.size(); j++) {
				int dest = unitB.get(j);
				if (map[area][dest]) continue;
				
				//바로 연결되지 않을 땐 같은 선거구를 통해 갈 수 있는지 체크
				Arrays.fill(visited, false);
				visited[area] = true;
				adjCheck(area);
				if (!visited[dest]) return -1;
			}
		}
		
		//두 선거구의 인구 차이 반환
		for (Integer num : unitA) sumA += population[num];
		for (Integer num : unitB) sumB += population[num];
		
		return Math.abs(sumA - sumB);
	}
	
	private static void adjCheck(int start) {
		for (int i = 0; i < N; i++) {
			if ((isUnitA[start] == isUnitA[i]) && map[start][i] && !visited[i]) {
				//같은 선거구이고, start에서 갈 수 있는 곳이고, 아직 방문하지 않은 곳이면
				visited[i] = true;
				adjCheck(i);
			}
		}
	}
}
