package algo;

import java.util.Arrays;

public class Programmers_increaseX {

	public static void main(String[] args) {
		solution(10000000 ,1000 );
	}
	static long[] solution(int x, int n) {
        long[] answer = new long[n];
        int cnt=0;
        if(x>0) {
	        for(long i=x;i<=x*n;i+=x) {
	        	answer[cnt]=i;
	        	cnt++;
	        }
        }else if(x==0) {
        	return answer;
        }
        else {
        	  for(long i=x;i>=x*n;i+=x) {
  	        	answer[cnt]=i;
  	        	cnt++;
  	        }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
