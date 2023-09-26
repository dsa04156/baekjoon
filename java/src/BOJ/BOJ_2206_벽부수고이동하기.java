package BOJ;
import java.io.*;
import java.util.*;
class BOJ_2206_벽부수고이동하기 {
	static int dx[] = new int[] {-1,0,1,0};
	static int dy[] = new int[] {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				char a = s.charAt(j);
				arr[i][j]=a-'0';
			}
		}
		if(N==1&&M==1) {
			answer=1;
		}
		else {
			bfs(N,M,arr);
		}
		if(answer==Integer.MAX_VALUE) answer=-1;
		System.out.println(answer);
		
	}
	static int answer=Integer.MAX_VALUE;
	static void bfs(int N,int M,int[][] arr) {
		Queue<Node> q = new LinkedList<>();
		boolean[][][] v= new boolean[N][M][2];
		v[0][0][0]=true;
		q.add(new Node(0,0,1,1));
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int c=0;c<4;c++) {
				int nx = n.x+dx[c];
				int ny = n.y+dy[c];
				if(nx==N-1&&ny==M-1) {
					answer = Math.min(answer, n.cnt+1);
					return;
				}
				
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				
				if(arr[nx][ny]==0&&!v[nx][ny][n.w]) {
					v[nx][ny][n.w]=true;
					q.add(new Node(nx,ny,n.w,n.cnt+1));
						}
				else if(n.w==1&&arr[nx][ny]==1&&!v[nx][ny][n.w]){
					v[nx][ny][1]=true;
					q.add(new Node(nx,ny,0,n.cnt+1));
				}
			}
		}
	}
	static class Node{
		private int x;
		private int y;
		private int w;
		private int cnt;
		public Node(int x,int y,int w,int cnt) {
			this.x=x;
			this.y=y;
			this.w=w;
			this.cnt=cnt;
	
		}
	}
}