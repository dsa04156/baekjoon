package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9372_상근이의여행 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N+1][N+1];
			boolean[] v= new boolean[N+1];
			int parents[] = new int[N+1];
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b]=1;
				arr[b][a]=1;
			}
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			min = Integer.MAX_VALUE;
			for(int i=1;i<=N;i++) {
				bfs(arr,i,v,N);
			}
			System.out.println(min-1);
		}
	}
	static int min;
	static void bfs(int[][] arr,int now, boolean[] v,int N) {
		Queue<Node> q = new LinkedList<>();
		v=new boolean[N+1];
		v[now]=true;
		q.add(new Node(now,1,v));
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.cnt==N) {
				min = Math.min(min, n.cnt);
				continue;
			}
			for(int i=1;i<=N;i++) {
				if(n.v[i]) continue;
				if(arr[n.nowPlace][i]==1) {
					if(n.v[i]) continue;
					n.v[i] = true;
					q.add(new Node(i,n.cnt+1,n.v));
					n.v[i]=false;
				}
			}
		}
		
	}
	static class Node{
		private int nowPlace;
		private int cnt;
		private boolean[] v;
		public Node(int nowPlace,int cnt,boolean[] v) {
			this.nowPlace=nowPlace;
			this.cnt=cnt;
			this.v=v;
		}
	}
}
