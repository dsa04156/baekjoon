
import java.util.Arrays;

public class Test_PowerSet {
	static boolean[] used; // 먼저 호출된 재귀가 가져다 쓴 카드 정보 기록된 배열
	static String[] cards; // 순열에 사용되는 재료
	static String[] result; // 순열 시뮬레이션이 저장되는 배열
	static boolean[] v;
	public static void main(String[] args) {
		cards = new String[4];
		cards[0] = "A";
		cards[1] = "B";
		cards[2] = "C";
		cards[3] = "D";
		
		v=new boolean[4];
		used = new boolean[4];
		
		perm(0);
	
	}
	public static void perm(int idx) {
		if(idx==cards.length) {
			for(int i=0;i<cards.length;i++) {
				if(v[i])
					System.out.print(cards[i]+" ");
			}
			System.out.println();
			return;
		}
		
		v[idx]=true;
		perm(idx+1);
		v[idx]=false;
		perm(idx+1);
		
	}
}

