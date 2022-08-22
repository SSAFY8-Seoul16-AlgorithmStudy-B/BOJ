import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// BOJ_17281 야구
public class BOJ_17281 {
    static ArrayList<Integer> list; // 타자 리스트
    static int[][] inputs; // 이닝 별 타자 배열(1 ~ 9)
    static int N, hitterNum, max;   // 이닝 수, 타자 수, 최대 점수

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hitterNum = 9;
        inputs = new int[N][hitterNum + 1];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= hitterNum; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList<>();
        for(int i = 2; i <= 9; i++) {   // 1번 선수가 4번타자로 고정 이므로 2번선수부터 리스트에 넣는다.
            list.add(i);
        }

        Collections.sort(list); // np를 위해 오름차순 정렬
        do{
            simulate();
        }while(np(list));

        System.out.println(max);
    }

    private static boolean np(ArrayList<Integer> list) {
        int size = list.size();

        int i = size - 1;
        while(i > 0 && list.get(i - 1) >= list.get(i)) --i;

        if(i == 0) return false;

        int j = size - 1;
        while(list.get(i - 1) >= list.get(j)) --j;
        swap(list, i - 1, j);

        int k = size - 1;
        while(i < k) swap(list, i++, k--);

        return true;
    }

    private static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private static void simulate() {
        list.add(3, 1); // 1번선수를 4번타자로 추가
        int curHitter = 1;  // 현재 n번 타자
        int score = 0;  // 점수
        for(int i = 0; i < N; i++) {    // 이닝수만큼 반복
            int outCnt = 0; // 아웃카운트
            int runnerInfo = 0; // 주자 정보
            while(true) {
                if(curHitter == 10) // 9번 타자 다음은 1번타자로
                    curHitter = 1;

                int hitterScore = inputs[i][list.get(curHitter - 1)];   // 현재 타자의 결과
                curHitter++;

                if(hitterScore == 0) {  // 아웃일 때
                    outCnt++;
                    if(outCnt == 3) {   // 3아웃이면 현재 이닝 종료
                        break;
                    }
                }
                else {  // 아웃이 아닌 진루일 때
                    // 현재 주자들 진루 ex) 1루, 3루 있을 때(01010) 안타
                    // 비트 정보 : 오른쪽부터 진루할 타자, 1루, 2루, 3루, 홈
                    runnerInfo++;   // 진루할 타자 추가(1011)
                    for(int hit = 0; hit < hitterScore; hit++) {    // n루타만큼 반복
                        runnerInfo = runnerInfo << 1;   // 주자 진루(10110)
                        if(runnerInfo > 15) {   // 홈에 도착 시(10110)
                            runnerInfo -= 16;   // 2^4 = 16을 빼고(00110)
                            score++;    // 점수 추가
                        }
                    }
                }
            }
        }
        max = Math.max(max, score); // 최대값 갱신
        list.remove(3); // 리스트에서 4번타자인 1번선수 제거
    }
}
