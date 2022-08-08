import java.util.Scanner;

public class Main_s3_2447_함철훈 {
	public static char[][][] map= new char[9][][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder();
		int N = sc.nextInt();
		int cnt=0;
		for(int i=1; i<N;i=i*3) {
			cnt++;
		}
		star(N);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				str.append(map[cnt][i][j]);
			}
			str.append("\n");
		}
		System.out.println(str);
		
	}
	public static void star(int N) {
		int e=1;
		map[0] = new char[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0; j<3;j++) {
				if(i==1 &&j==1)	map[0][i][j] = 32;
				else map[0][i][j] = '*';
			}
		}
		for(int i=1; e!=N; i++) {
			
			map[i] = new char[map[i-1].length*3][map[i-1].length*3];
			for(int r=0; r<map[i].length;r++) {
				for(int c=0; c<map[i].length;c++) {
					if (!(r/map[i-1].length==1 &&c/map[i-1].length==1))	map[i][r][c] = map[i-1][r%map[i-1].length][c%map[i-1].length];
					else map[i][r][c] = 32;
				}
			}
			e*=3;
		}
        return ;

	}
}
