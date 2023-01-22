import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1043 거짓말
public class BOJ_1043 {
    static int[] parent;

    static void init(int length) {
        parent = new int[length + 1];
        for(int i = 1; i <= length; i++) {
            parent[i] = i;
        }
    }

    static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        parent[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 사람 수
        int M = Integer.parseInt(st.nextToken());   // 파티의 수
        int[][] input = new int[M][];   // 입력받을 파티 정보
        int count = M;  // 정답을 출력할 파티 개수
        int know = 0;   // 진실을 아는사람의 루트 번호. 기본값은 무의미한 값인 0
        init(N);

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());   // 진실을 아는 사람 수
        if(t != 0) {    // 진실을 아는 사람이 한명이라도 있다면
            // 슬라이딩 윈도우 방식으로 진실을 아는 사람들을 union
            int a = Integer.parseInt(st.nextToken());
            know = a;
            for(int i = 0; i < t - 1; i++) {
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
                a = b;
            }
        }

        // 파티 정보 입력받으면서 각 파티를 같은 집합으로 union
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 각 파티 인원 수

            // 슬라이딩 윈도우 방식으로 같은 파티 사람들을 union
            input[i] = new int[n];
            int a = Integer.parseInt(st.nextToken());
            input[i][0] = a;
            for(int j = 1; j < n; j++) {
                int b = Integer.parseInt(st.nextToken());
                input[i][j] = b;
                union(a, b);
                a = b;
            }
        }

        // 진실을 아는 사람이 파티 내에 존재하는지 검사
        for(int i = 0; i < M; i++) {
            boolean check = false;
            for(int j = 0, end = input[i].length; j < end; j++) {
                // 파티 구성원이 진실을 아는 사람과 같은 루트를 가진다면
                if(find(input[i][j]) == find(know)) {
                    check = true;   // 해당 파티는 모두 진실을 아는 사람이 된다.
                    break;
                }
            }
            if(check) { // 진실을 아는 사람이 있다면 -1
                count--;
            }
        }
        System.out.println(count);
    }

}
