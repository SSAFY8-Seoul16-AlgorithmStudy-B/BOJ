import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<CARD> list;
	static ArrayList<String> COLOR;
	static ArrayList<Integer> NUMBER;
	static int NO[];
	static int ANSWER,MAX;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ANSWER = Integer.MIN_VALUE;
		MAX = Integer.MIN_VALUE;
		list = new ArrayList<>();
		COLOR = new ArrayList<>();
		NUMBER = new ArrayList<>();
		NO = new int[10];
		

		for (int i = 0; i < 5; i++) {
			String c = sc.next();
			int n = sc.nextInt();

			list.add(new CARD(c, n));
		}


		Collections.sort(list);
		
		//printList();
		


		for(int i=0; i<5; i++) {
			CARD chk = list.get(i);
			

			NO[chk.no] += 1;
			

			MAX = Math.max(MAX, chk.no);
			

			if(!NUMBER.contains(chk.no))
				NUMBER.add(chk.no);
			
			
			if(!COLOR.contains(chk.color))
				COLOR.add(chk.color);
		}
		
		
		
		if(COLOR.size()==1) {
			ANSWER = Math.max(ANSWER, (MAX+600));
		}
		
		if(NUMBER.size()==5) {
			int n=Math.abs(NUMBER.get(0)-NUMBER.get(4));
			
		
			if(n==4 && COLOR.size()==1) {
				ANSWER = Math.max(ANSWER, (MAX+900));
			}
				
		
			if(n==4) {
				ANSWER = Math.max(ANSWER, (MAX+500));
			}	
		}
		
		if(NUMBER.size()==2) {
		
			if(NO[NUMBER.get(0)]==4) {
				ANSWER = Math.max(ANSWER, (NUMBER.get(0)+800));
			}else if(NO[NUMBER.get(1)]==4) {
				ANSWER = Math.max(ANSWER, (NUMBER.get(1)+800));
			}
			
		
			if(NO[NUMBER.get(0)]==3 && NO[NUMBER.get(1)]==2) {
				ANSWER = Math.max(ANSWER, ((NUMBER.get(0)*10)+NUMBER.get(1)+700));
			}else if(NO[NUMBER.get(0)]==2 && NO[NUMBER.get(1)]==3) {
				ANSWER = Math.max(ANSWER, ((NUMBER.get(1)*10)+NUMBER.get(0)+700));
			}
		}else if(NUMBER.size()==3) {
		
			if(NO[NUMBER.get(0)]==3) {
				ANSWER = Math.max(ANSWER, (NUMBER.get(0)+400));
			}else if(NO[NUMBER.get(1)]==3) {
				ANSWER = Math.max(ANSWER, (NUMBER.get(1)+400));
			}else if(NO[NUMBER.get(2)]==3) {
				ANSWER = Math.max(ANSWER, (NUMBER.get(2)+400));
			}
				
		
			if(NO[NUMBER.get(0)]==2 && NO[NUMBER.get(1)]==2) {
				ANSWER=Math.max(ANSWER, ((NUMBER.get(1)*10)+NUMBER.get(0)+300));
			}else if(NO[NUMBER.get(0)]==2 && NO[NUMBER.get(2)]==2) {
				ANSWER=Math.max(ANSWER, ((NUMBER.get(2)*10)+NUMBER.get(0)+300));
			}else if(NO[NUMBER.get(1)]==2 && NO[NUMBER.get(2)]==2) {
				ANSWER=Math.max(ANSWER, ((NUMBER.get(2)*10)+NUMBER.get(1)+300));
			}
				
		}else if(NUMBER.size()==4) {
			for(int i=0; i<NUMBER.size(); i++) {
				if(NO[NUMBER.get(i)]==2) {
					ANSWER=Math.max(ANSWER, ((NUMBER.get(i)+200)));
					break;
				}
			}
		}
		
		

		if(ANSWER==Integer.MIN_VALUE) {
			ANSWER = MAX +100;
		}			
	
		System.out.println(ANSWER);
	}

	private static void printList() {
		for(int i=0; i<list.size();i++) {
			CARD c1 = list.get(i);
			System.out.println(c1.color+", "+c1.no);
		}
	}
}

class CARD implements Comparable<CARD> {
	String color;
	int no;

	CARD(String color, int no) {
		this.color = color;
		this.no = no;
	}
	

	@Override
	public int compareTo(CARD c) {
		return (this.no-c.no);
	}

}