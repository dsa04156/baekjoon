import java.io.*;
import java.util.*;
class Main {
	static int N,K;
	static int res;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int []arr = new int[N+1];
		int[] dp = new int[N+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			dp[i]+=dp[i-1]+arr[i];
		}
		System.out.println(Arrays.toString(dp));
		res=0;
		System.out.println(res);
	}
	
}