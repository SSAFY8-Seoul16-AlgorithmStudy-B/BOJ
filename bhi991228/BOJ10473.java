import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10473 {

	static class Pos {
		double x, y;
		public Pos(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Pos start = new Pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Pos end = new Pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		
		int N = Integer.parseInt(br.readLine());
		int V = N+1;							//대포들 + 도착점
		double[][] adjArr = new double[V][V];	//인접 행렬
		Pos[] vertexArr = new Pos[V];			//정점 위치 정보
		vertexArr[V-1] = end;					//v-1번 v == 도착점
		
		//나머지 v 입력받기
		for (int i = 0; i < V-1; i++) {
			st = new StringTokenizer(br.readLine());
			vertexArr[i] = new Pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}
		
		/*인접 행렬 채우기*/
		//대포 이동 가능한 v들
		for (int i = 0; i < V-1; i++) {
			for (int j = i+1; j < V; j++) {
				double dist = Math.sqrt(Math.pow(Math.abs(vertexArr[i].x - vertexArr[j].x), 2) 
										+ Math.pow(Math.abs(vertexArr[i].y - vertexArr[j].y), 2));
				double time1 = dist/5;						//걸어갈 때 소요 시간
				double time2 = 2 + (Math.abs(dist-50)/5);	//대포를 썼을 때 소요 시간
				double weight = Math.min(time1, time2);
				adjArr[i][j] = weight;
				adjArr[j][i] = weight;
			}
		}
		
		/*다익스트라*/
		//시작점->모든 정점 비용을 수직거리 기준으로 초기화
		boolean[] visited = new boolean[V];
		double[] cost = new double[V];
		for (int i = 0; i < V; i++) {
			double dist = Math.sqrt(Math.pow(Math.abs(start.x - vertexArr[i].x), 2) 
									+ Math.pow(Math.abs(start.y - vertexArr[i].y), 2));
			cost[i] = dist/5;
		}
		
		while(true) {
			//한 번도 방문하지 않은 정점들 중 가장 가까운 정점 찾기
			int minIdx = -1;
			double minCost = Double.MAX_VALUE;
			
			for (int i = 0; i < V; i++) {
				if (!visited[i] && minCost > cost[i]) {
					minIdx = i;
					minCost = cost[i];
				}
			}
			
			//도착점까지 거리가 확정된 상태이니 break
			if (minIdx == V-1) break;
			
			visited[minIdx] = true;
			for (int i = 0; i < V; i++) {
				if (!visited[i] && cost[i] > cost[minIdx] + adjArr[minIdx][i]) {
					cost[i] = cost[minIdx] + adjArr[minIdx][i];
				}
			}
		}
		
		System.out.println(cost[V-1]);
	}

}
