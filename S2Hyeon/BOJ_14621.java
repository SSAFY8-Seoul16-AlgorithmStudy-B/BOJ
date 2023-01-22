import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_14621 나만 안되는 연애
public class BOJ_14621 {

    // 간선리스트를 위한 Edge 클래스
    private static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        // 거리를 기준으로 오름차순 정렬
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static Edge[] edgeList; // 간선 리스트
    static char[] gender;   // 성별 저장할 배열

    // 서로소 집합
    static int[] parents;
    static int V, E;

    static void make() {
        parents = new int[V + 1];
        for(int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {
        if(parents[a] == a)
            return a;

        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;

        parents[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        make();
        gender = new char[V + 1];   // 학교 번호가 1부터 시작
        edgeList = new Edge[E];

        // 성별 배열에 성별 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= V; i++) {
            gender[i] = st.nextToken().charAt(0);
        }

        // 간선리스트 입력
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edgeList[i] = new Edge(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        // 최단거리 간선부터 찾기 위해 정렬
        Arrays.sort(edgeList);

        int result = 0;
        int count = 0;
        for(Edge edge : edgeList) {
            // 시작점과 도착점의 성별이 다르고 이어질 수 있는 간선이라면(서로 다른 집합에 있다면)
            if(gender[edge.from] != gender[edge.to] && union(edge.from, edge.to)) {
                result += edge.weight;  // 거리 합산
                if(++count == V - 1) {  // 모든 간선 연결되면 break
                    break;
                }
            }
        }
        // 모든 간선 연결되지 않았다면 - 1 출력
        if(count != V - 1) {
            System.out.println(-1);
        }
        else
            System.out.println(result);
    }
}