import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2644 {

	static int N;				//전체 사람 수
	static int p1, p2;			//촌수 계산할 사람들
	static int[][] relation;	//관계 정보
	static boolean[] visited;	//방문 여부
	static int answer = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());	
		st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());		
		p2 = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());	//관계 개수
		int parent, child;
		relation = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		//관계 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			parent = Integer.parseInt(st.nextToken());
			child = Integer.parseInt(st.nextToken());
			
			relation[parent][child] = 1;
			relation[child][parent] = 1;
		}
		
		dfs(p1, 0);
		System.out.println(answer);
	}
	
	private static void dfs(int nowPerson, int cnt) {
		if (relation[nowPerson][p2] == 1) {		//촌수 계산할 사람과 닿으면
			answer = cnt+1;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i])	continue;			//이미 지나간 사람이면 무시
			
			if (relation[nowPerson][i] == 1) {	//부모 관계
				visited[i] = true;
				dfs(i, cnt+1);
				visited[i] = false;
				
				if (answer != -1) return;		//답이 나왔으면 종료
			}
		}
	}
}
