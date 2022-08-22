import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


class Pos{
	int r, c;
	Pos(int r, int c){
		this.r = r;
		this.c = c;
	}
}
public class BOJ11559 {

	static char[][] map = new char[12][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static ArrayList<Pos> puyoList = new ArrayList<Pos>();
	static boolean isChain, existBomb;
	static char nowColor;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int firstRow = -1;
		char color;
		int answer = 0;
		
		for (int i = 0; i < 12; i++) {
			line = br.readLine();
			map[i] = line.toCharArray();
			if (firstRow == -1 && 
				(line.contains("R") || line.contains("G") || line.contains("B")
				||line.contains("P") || line.contains("Y"))) {
				firstRow = i;
			}
		}
		
		if (firstRow == -1) {
			System.out.println(answer);
			return;
		}
		
		while(true) {
			//for (int i = 0; i < 12; i++) {
			//	System.out.println(Arrays.toString(map[i]));
			//}
			existBomb = false;
			for (int i = firstRow; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						puyoList.clear();
						puyoList.add(new Pos(i, j));	//현재 위치 추가
						isChain = false;				//연쇄 여부 초기화
						nowColor = map[i][j];			//확인할 색상
						
						map[i][j] = '.';				//현재 위치 방문처리
						findPuyo(i, j);
						
						if (isChain) {
							if (!existBomb) existBomb = true; 
						}else {
							//연쇄가 아니라서 .위치 다시 color로 돌려놔야 함
							for (Pos pos : puyoList) {
								map[pos.r][pos.c] = nowColor;
							}
						}
					}
				}
			}
			
			if (existBomb) {
				answer++;
				//뿌요 아래로 떨어뜨리기
				doGravity();
			}
			else break;
		}
		
		System.out.println(answer);
	}
	
	private static void findPuyo(int r, int c) {
		int nr, nc;
		
		//터트릴 수 있는 것 찾기
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			
			if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6) continue;
			
			if (map[nr][nc] == nowColor) {
				if (!isChain) {
					//아직 연쇄임을 확신할 수 없으니 나중에 다시 color 값으로 돌릴 경우를 위해 현재 위치 저장
					puyoList.add(new Pos(nr, nc));	
					if (puyoList.size() >= 4) isChain = true;
				}
				
				map[nr][nc] = '.';
				findPuyo(nr, nc);
			}
		}
	}
	
	private static void doGravity() {
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j > 0; j--) {
				
				if(map[j][i] == '.') {
					for (int k = j-1; k >= 0; k--) {
						if(map[k][i] != '.') {
							map[j][i] = map[k][i];
							map[k][i] = '.';
							break;
						}
					}
				}
				
			}
		}
	}

}
