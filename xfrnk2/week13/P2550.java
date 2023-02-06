import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	/*
5
2 4 1 5 3
4 5 1 3 2	
	
	1 3 2 4 0
	 */
	static class Bulb {
		int num, idx;

		public Bulb(int num, int idx) {
			super();
			this.num = num;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return String.format("Bulb [num=%s, idx=%s]", num, idx);
		}
		
	}
	
    static List<Integer> group = new ArrayList<>(); 
 
	
	public static int binarySearch(int num) {
		int l = 0, h = group.size() - 1, mid = 0;	
		while (l <= h) {

			mid = (l + h) / 2;
			//System.out.println("mid : " + mid);
			if (group.get(mid) < num) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return l;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] bulb = new int[N];
		int[] input = new int[N];
		
		Map<Integer, Integer> idxMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int cur = sc.nextInt();
			idxMap.put(cur, i);
			input[i] = cur;
		}
		for (int i = 0; i < N; i++) {
			bulb[i] = idxMap.get(sc.nextInt());
		}
		
		Bulb[] order = new Bulb[N];
		
        for(int i = 0; i < N; i++) { 
            if(group.size() == 0 || group.get(group.size() - 1) < bulb[i]) {
                group.add(bulb[i]);
                order[i] = new Bulb(bulb[i], group.size() - 1);
        
            } else {
            	
                int idx = binarySearch(bulb[i]);
        
                group.set(idx, bulb[i]);
                order[i] = new Bulb(bulb[i], idx);
            }
        } 
        
        
        int idx = group.size() - 1;
        for(int i = N - 1; i >= 0; i--) {
        	if(order[i].idx == idx) {
            	
                group.set(idx--, input[order[i].num]);
            }
        }
 
        Collections.sort(group);
        StringBuilder sb = new StringBuilder();
        sb.append(group.size() + "\n");
        for(int i = 0; i < group.size(); i++) {
            sb.append(group.get(i) + " ");
        }
        System.out.println(sb.toString());
	}

}
