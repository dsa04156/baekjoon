package BOJ;
import java.io.*;
import java.util.*;
class BOJ_21318_피아노체조 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i+1]=Integer.parseInt(st.nextToken());
		}
		int Q = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		int cnt=1;
		for(int i=1;i<N;i++) {
			if(arr[i]>arr[i+1]) {
				dp[i]=dp[i-1]+1;
			}
			else {
				dp[i]=dp[i-1];
			}
		}
		dp[N]=dp[N-1];
		for(int t=0;t<Q;t++) {
			st= new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(dp[y]!=dp[y-1]) {
				System.out.println(dp[y]-1-dp[x-1]);
			}else {
				System.out.println(dp[y]-dp[x-1]);
			}
			
			
		}
		
		
	}
}