package BOJ;
import java.io.*;
import java.util.*;
class BOJ_9466_텀프로젝트 {
	static int dx[] = new int[] {-1,0,1,0};
	static int dy[] = new int[] {0,1,0,-1};
	static int n;
	static int[] arr;
	static int count=0;
	static boolean[] v;
	static boolean[] f;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			count=0;
			v=new boolean[n+1];
			f=new boolean[n+1];
			for(int i=1;i<=n;i++) {
				if(f[i]) continue;// 이미 검사한 애들은 스킵한다.
				System.out.println(i + " nownow ");
				dfs(i);
			}
			System.out.println(n-count);
		}
	}
	static void dfs(int now) {
		if(f[now]) return;
		if(v[now]) {
			f[now] = true;
			count++;
			System.out.println(now+ " "+ count);
		}
		v[now]=true;// 방문 체크
		dfs(arr[now]);
		f[now]=true;// 사이클이 아닌 애들도 검사 끝났으니까 
		v[now]=false; // 방문 체크한 거 초기화
	}
	
}