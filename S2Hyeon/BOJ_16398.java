import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ_16398 행성 연결
public class BOJ_16398 {
    static class Vertex implements Comparable<Vertex>{
        int no;
        int edge;
        public Vertex(int no, int edge) {
            super();
            this.no = no;
            this.edge = edge;
        }
        @Override
        public int compareTo(Vertex o) {
            return this.edge - o.edge;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] input = new int[N][N];
        boolean[] visited = new boolean[N];
        int[] minEdge = new int[N];
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }// i노드에서 j노드까지의 비용을 모두 배열에 저장

        long result = 0;
        int nodeCount= 0;
        minEdge[0] = 0;//시작점 비용 0 셋팅
        queue.offer(new Vertex(0,0));

        while(!queue.isEmpty()){

            Vertex minVertex = queue.poll();			// PQ 에서 간선비용이 최소인 정점 뽑기
            if(visited[minVertex.no]) continue;

            result += minVertex.edge;
            visited[minVertex.no] = true;
            if(++nodeCount == N) break;

            for (int i = 0; i < N; i++) {
                if (!visited[i] && input[minVertex.no][i] != 0 &&   minEdge[i] > input[minVertex.no][i] ) {
                    minEdge[i] = input[minVertex.no][i];
                    queue.offer(new Vertex(i, input[minVertex.no][i]));
                }
            }
        }
        System.out.println(result);
    }
}