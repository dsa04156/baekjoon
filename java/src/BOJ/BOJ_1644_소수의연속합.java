import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1644_소수의연속합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] v= new boolean[N+1];
		if(N==1) {
			System.out.println(0);
			return;
		}
		v[0]=true; v[1]=true;
		for(int i=2;i*i<=N;i++) {
			if(!v[i]) {
				for(int j=2*i;j<=N;j+=i) v[j]=true;
			}
		}
		for(int i=1;i<=N;i++) {
			if(!v[i]) list.add(i);
		}
		int start=0;
		int end =0;
		int sum=list.get(start);
		int res=0;
		
		while(end<list.size()&&start<=end) {
			if(sum==N) {
				res++;
				sum-=list.get(start);
				start++;
			}
			else if(sum<N) {
				end++;
				if(end>=list.size()) break;
				sum+=list.get(end);
			}
			else {
				sum-=list.get(start);
				start++;
			}
		}
		System.out.println(res);
	}
}
