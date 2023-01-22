import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ_5639 이진 검색 트리
public class BOJ_5639 {
    static ArrayList<Integer> pre = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String line = br.readLine();
            if(line == null || line.length() == 0) break;
            pre.add(Integer.parseInt(line));
        }

        post(0, pre.size());
    }

    // 루트보다 큰 값이 나오기 전까지는 모두 루트 노드의 왼쪽 자식
    // 큰 값부터는 루트의 오른쪽 자식
    // start는 루트의 인덱스, end는 서브트리의 끝
    private static void post(int start, int end) {
        if(start >= end) {
            return;
        }

        int idx = start + 1;
        while(idx < end) {
            if(pre.get(start) < pre.get(idx)) { // 현재 루트의 값과 다음 값들을 비교
                break;  // 루트보다 큰 값이 나오면 break
            }
            idx++;
        }

        post(start + 1, idx);   // 왼쪽 서브 트리로
        post(idx, end);     // 오른쪽 서브 트리로
        System.out.println(pre.get(start)); // 루트 출력
    }
}
