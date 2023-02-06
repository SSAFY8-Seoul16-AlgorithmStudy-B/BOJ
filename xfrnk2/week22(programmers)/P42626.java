package programmers;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P42626 {

	public static void main(String[] args) {
		int[] scoville = new int[] {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		int ans = solution(scoville, K);
		System.out.println(ans);
	}
	
    public static int solution(int[] scoville, int K) {
    	Set<Integer> set = new HashSet<>();
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	for (int elem : scoville) {
			if (elem < K) set.add(elem);
			pq.add(elem);
		}
    	int answer = 0;
    	
    	while(0 != set.size() && 2 <= pq.size()) {
    		Integer n1 = pq.poll();
    		Integer n2 = pq.poll();
    		
    		int temp = n1 + n2 * 2;
    		set.remove(n1);
    		set.remove(n2);
    		if (temp < K) {
    			set.add(temp);
    		}
    		pq.add(temp);
    		answer ++;
    	}
    	
	    return set.isEmpty() ? answer : -1;
    }
    


}
