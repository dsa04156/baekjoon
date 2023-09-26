package BOJ;
import java.io.*;
import java.util.*;
class BOJ_2573_빙산 {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int[][] arr;
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr = new int[N][M];
		q = new LinkedList<>();

		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=stoi(st.nextToken());
				if(arr[i][j]!=0) {
					q.add(new Node(i,j,0));
				}
			}
		}
		bfs();
	}
	static Queue<Node> q;

	static int dx[] = new int[] {-1,0,1,0};
	static int dy[] = new int[] {0,1,0,-1};
	static boolean check() {
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0) {
					cnt++;
				}
			}
		}
		if(cnt==N*M) {
			return false;
		}
		return true;
	}
	static void bfs() {
		int[][] brr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				brr[i][j]=arr[i][j];
			}
		}
		int year=0;
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			if(year!=n.year) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						arr[i][j]=brr[i][j];
					}
				}
				if(!check()) {
					System.out.println(0);
					return;
				}
				year=n.year;
				v=new boolean[N][M];
				int k=0;
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(arr[i][j]!=0&&!v[i][j]) {
							v[i][j]=true;
							dfs(i,j);
							k++;
						}
					}
				}
				if(k>1) {
					System.out.println(n.year);
					return;
				}
				
			}
			int cnt=0;
			for(int c=0;c<4;c++) {
				int nx = n.x+dx[c];
				int ny = n.y+dy[c];
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(arr[nx][ny]==0) {
					cnt++;
				}
			}
			brr[n.x][n.y]-=cnt;
			if(brr[n.x][n.y]<0) brr[n.x][n.y]=0;
			q.add(new Node(n.x,n.y,n.year+1));
		}
		
	}
	static boolean[][] v;
	static void dfs(int x,int y) {
		for(int c=0;c<4;c++) {
			int nx=x+dx[c];
			int ny=y+dy[c];
			if(nx<0||ny<0||nx>=N||ny>=M) continue;
			if(v[nx][ny]) continue;
			if(arr[nx][ny]!=0) {
				v[nx][ny]=true;
				dfs(nx,ny);
			}
		}
		return;
	}
	
	static class Node{
		int x;
		int y;
		int year;
		public Node(int x,int y,int year) {
			this.x=x;
			this.y=y;
			this.year=year;
		}
	}
}