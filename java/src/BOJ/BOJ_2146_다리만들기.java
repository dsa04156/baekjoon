package BOJ;
import java.io.*;
import java.util.*;
class BOJ_2146_다리만들기 {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int[][] map;
	static int[][] arr;
	static boolean[][] v;
	static int N;
	static int[] dx = new int[] {-1,0,1,0};
	static int[] dy = new int[] {0,1,0,-1};
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		arr= new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=stoi(st.nextToken());
			}
		}
		map = new int[N][N];
		v = new boolean[N][N];
		int cnt=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==1&&!v[i][j]) {
					map[i][j]=cnt;
					v[i][j]=true;
					makeMap(i,j,cnt);
					cnt++;
				}
			}
		}
		cnt-=1; //섬의 개수
		 list =  new ArrayList[cnt+1];
		for(int i=1;i<=cnt;i++) {
			list[i]= new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0) {
					int zc = zeroCheck(i,j);
					if(zc>0) {
						list[zc].add(new Node(i,j,zc,0));
					}
				}
			}
		}
		for(int i=1;i<=cnt;i++) {
			bfs(i);
		}
//		for(int i=1;i<list.length;i++) {
//			for(int j=0;j<list[i].size();j++) {
//				System.out.print("{"+list[i].get(j).toString()+"}, ");
//			}
//			System.out.println();
//		}
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(minDistance);
	}
	static int minDistance = Integer.MAX_VALUE;
	static void bfs(int k) {
		Queue<Node> q = new LinkedList<>();
		for(int i=0;i<list[k].size();i++) {
			q.add(list[k].get(i));
		}
		v=new boolean[N][N];
		while(!q.isEmpty()) {
			Node n = q.poll();
			v[n.x][n.y]=true;
			for(int c=0;c<4;c++) {
				int nx= n.x+dx[c];
				int ny = n.y+dy[c];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(v[nx][ny]) continue;
				if(map[nx][ny]==0) {
					v[nx][ny]=true;
					q.add(new Node(nx,ny,n.zeroCount,n.cnt+1));
				}
				if(map[nx][ny]!=0&&map[nx][ny]!=k) {
					minDistance = Math.min(minDistance, n.cnt);
					return;
				}
			}
		}
	}
	static int zeroCheck(int x,int y) {
		int zeroCnt=0;
		for(int c=0;c<4;c++) {
			int nx = x+dx[c];
			int ny = y+dy[c];
			if(nx<0||ny<0||nx>=N||ny>=N) continue;
			if(map[nx][ny]==0) zeroCnt++;
		}
		if(zeroCnt>0) {
			return map[x][y]; 
		}else {
			return -1;
		}
		
	}
	static void makeMap(int x,int y,int cnt) {
		for(int c=0;c<4;c++) {
			int nx = x+dx[c];
			int ny = y + dy[c];
			if(nx<0||ny<0||nx>=N||ny>=N) continue;;
			if(v[nx][ny]) continue;
			if(arr[nx][ny]==1) {
				v[nx][ny]=true;
				map[nx][ny]=cnt;
				makeMap(nx,ny,cnt);
			}
		}
	}
	static class Node{
		int x;
		int y;
		int zeroCount;
		int cnt;
		public Node(int x,int y,int zeroCount,int cnt){
			this.x=x;
			this.y=y;
			this.zeroCount=zeroCount;
			this.cnt=cnt;
		}
		public String toString() {
			return x + ", " + y + ", " + zeroCount+", "+cnt;
		}
	}
}