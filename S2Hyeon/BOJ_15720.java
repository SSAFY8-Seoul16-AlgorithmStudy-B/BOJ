import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ_15720 카우버거
public class BOJ_15720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());   // 버거의 개수
        int C = Integer.parseInt(st.nextToken());   // 사이드 메뉴의 개수
        int D = Integer.parseInt(st.nextToken());   // 음료의 개수
        int before = 0; // 할인 전 가격
        double after = 0;   // 할인 후 가격
        double discount = 0.1;  // 할인율

        // 가장 비싼 것을 우선적으로 할인받아야하므로 우선순위 큐를 이용하여 입력받으면서 내림차순 정렬
        PriorityQueue<Integer> hamburger = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> sideMenu = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> drink = new PriorityQueue<>(Collections.reverseOrder());

        // 각 햄버거 가격
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++) {
            int price = Integer.parseInt(st.nextToken());
            hamburger.offer(price);
            before += price;
        }

        // 각 사이드 메뉴의 가격
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            int price = Integer.parseInt(st.nextToken());
            sideMenu.offer(price);
            before += price;
        }

        // 각 음료의 가격
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < D; i++) {
            int price = Integer.parseInt(st.nextToken());
            drink.offer(price);
            before += price;
        }

        // 세트 메뉴 구성을 할 수 있을 때까지 반복
        while(!hamburger.isEmpty() && !sideMenu.isEmpty() && !drink.isEmpty()) {
            int temp = 0;
            temp += hamburger.poll() + sideMenu.poll() + drink.poll();  // 세트 메뉴 가격 합산
            after += temp * (1 - discount); // 할인 적용하여 할인 후 가격에 합산
        }

        // 세트 메뉴 구성 이후 나머지는 원가로 합산
        while(!hamburger.isEmpty())
            after += hamburger.poll();
        while(!sideMenu.isEmpty())
            after += sideMenu.poll();
        while(!drink.isEmpty())
            after += drink.poll();

        System.out.println(before);
        System.out.println((int)(after));
    }
}
