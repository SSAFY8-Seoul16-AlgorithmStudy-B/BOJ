import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15685 {
	
	static int[][] map = new int[100][100];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static ArrayList<Point> dragonCurve = new ArrayList<>();
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());
			
			Point start = new Point(x, y);
			Point end = new Point(x+dx[dir], y+dy[dir]);
			
			dragonCurve.clear();
			dragonCurve.add(start);
			dragonCurve.add(end);
			
			//해당 세대가 될 때까지 순차적으로 선분 생성
			makeCurve(gen);
			
			//curveList에 담긴 선분을 꼭지점으로 포함하는 칸을 찾아 표시
			for (Point p : dragonCurve) {
				int whichPoint = -1;
				//현재 p를 꼭짓점으로 가지고 있는 4개의 칸
				for (int r = p.y-1; r <= p.y; r++) {
					for (int c = p.x-1; c <= p.x; c++) {
						whichPoint++;
						if (r < 0 || r >= 100 || c < 0 || c >= 100) continue;	//배열 범위를 벗어나면 continue;
						map[r][c] |= 1 << whichPoint;	//그 칸의 네 꼭짓점 중 whichPoint은 드래곤커브의 일부인 것으로 비트마스킹 표시
					}
				}
			}
		}
		
		//15(1111)인 칸 개수 세기
		int answer = 0;
		for (int[] line : map) {
			for (int n : line) {
				if(n == 15) answer++;
			}
		}
		
		System.out.println(answer);
	}

	private static void makeCurve(int gen) {
		if (gen == 0) return;
		else makeCurve(--gen);
		
		int lastIndex = dragonCurve.size()-1;
		Point lastPoint = dragonCurve.get(lastIndex);
		Point nowPoint;
		int newX, newY;
		
		for (int i = lastIndex-1; i >= 0; i--) {
			nowPoint = dragonCurve.get(i);
			newX = lastPoint.x - (nowPoint.y - lastPoint.y);
			newY = lastPoint.y + (nowPoint.x - lastPoint.x);
			dragonCurve.add(new Point(newX, newY));
		}
	}

}
