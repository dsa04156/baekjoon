package algo;

import java.util.LinkedList;
import java.util.Queue;

public class KAKAO_QueSum_Fail {
	static int cnt;
	static int c;
	public static void main(String[] args) {
		cnt=0;
		solution(new int[] {3, 2, 7, 2},new int[] {4, 6, 5, 1});
	}
	 public static int solution(int[] queue1, int[] queue2) {
		 int sum=0;
		 Queue<Integer> q1 = new LinkedList<>();
		 Queue<Integer> q2 = new LinkedList<>();
		 
		 	for(int i=0;i<queue1.length;i++) {
		 		sum+=queue1[i];
		 		q1.add(queue1[i]);
		 	}
		 	
		 	for(int i=0;i<queue2.length;i++) {
		 		sum+=queue2[i];
		 		q2.add(queue2[i]);
		 	}
		 	sum/=2;
		 	c=q1.size()*q2.size()*5;
		 	rec(q1,q2,sum);
	        int answer = cnt;
	        
	        System.out.println(answer);
	        return answer;
	    }
	 
	 static void rec(Queue<Integer> q1, Queue<Integer> q2, int sum) {
		 if(cnt>c)
			 return;
		 int sum1 = 0;
		 int sum2 = 0;
		 int a =0;
		 for(int i=0;i<q1.size();i++) {
			 a=q1.poll();
			 sum1+=a;
			 q1.add(a);
		 }
		 for(int i=0;i<q2.size();i++) {
			 a=q2.poll();
			 sum2+=a;
			 q2.add(a);
		 }
	
		 if(sum1==sum2) {
			 return;
		 }
		 else if(sum1>sum2) {
			 q2.add(q1.poll());
			 cnt++;
			 rec(q1,q2,sum);
		 }
		 else if(sum1<sum2) {
			 q1.add(q2.poll());
			 cnt++;
			 rec(q1,q2,sum);
		 }

	 }
}
