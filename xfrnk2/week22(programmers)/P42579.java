package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class P42579 {

	static Map<String, Integer> map = new HashMap<>();
	static Map<String, PriorityQueue<Song>> songRepo = new HashMap<>();
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "classic", "pop", "pop" },
				new int[] { 500, 500, 500 }));

	}

	public static int[] solution(String[] genres, int[] plays) {
		int size = genres.length;
		List<Integer> answer = new ArrayList<>();
		Set<String> set = new HashSet<>(Arrays.asList(genres));
		for (String name : set) {
			map.put(name, 0);
		}
		for (int i = 0; i < size; i++) {
			
			map.put(genres[i], map.get(genres[i]) + plays[i]);
			if (!songRepo.containsKey(genres[i])) {
				songRepo.put(genres[i], 
						
						new PriorityQueue<Song>(new Comparator<Song>() {

							@Override
							public int compare(Song o1, Song o2) {
								int playCnt = o2.cnt - o1.cnt;
								if (playCnt == 0) {
									return o1.idx - o2.idx; 
								}
								return playCnt;
							}
							
							
						})
						);
			} 
			songRepo.get(genres[i]).add(new Song(plays[i],i));	
			
		
		}
	//	System.out.println(map);
		List<String> nameList = new ArrayList<>(map.keySet());
		nameList.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return map.get(o2) - map.get(o1);
			}

		});
	
		int ansIdx = 0;
		for (String name : nameList) {
			PriorityQueue<Song> targetRepo = songRepo.get(name);
			int pollCnt = 0;
			while (pollCnt++ < 2 && !targetRepo.isEmpty()) {
				Song cur = targetRepo.poll();
				answer.add(cur.idx);
			}
		}
	//	System.out.println(answer);
		int[] ans = new int[answer.size()];
		int ix = 0;
		for (Integer elem : answer) {
			ans[ix ++] = elem;
		}
		return ans;
	}
	
	static class Song {
		int cnt, idx;

		public Song(int cnt, int idx) {
			super();
			this.cnt = cnt;
			this.idx = idx;
		}
		
	}

}
