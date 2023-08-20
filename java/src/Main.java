import java.io.*;
import java.util.*;
class Main {
	static Queue<Node> rq,bq;
	static boolean[][] vr,vb;
	static char[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		rq= new LinkedList<>();
		bq= new LinkedList<>();
		vr=new boolean[N][M];
		vb = new boolean[N][M];
		arr = new char[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=s.charAt(j);
				if(arr[i][j]=='R') {
					rq.add(new Node(i,j,0,0));
					vr[i][j]=true;
					arr[i][j]='.';
				}
				if(arr[i][j]=='B') {
					bq.add(new Node(i,j,0,0));
					vb[i][j]=true;
					arr[i][j]='.';
				}
			}
		}
		bfs();
		if(res==11) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
	}
	static int[] dx = new int[] {-1,0,1,0};
	static int[] dy = new int[] {0,1,0,-1};
	static int res = 11;
	static void bfs() {
		
		while(!rq.isEmpty()) {
			Node rn = rq.poll();
			Node bn = bq.poll();
//			System.out.println("red : "+ rn.x+" "+rn.y + " "+rn.cnt+" "+rn.c);
//			System.out.println("blu : "+ bn.x+" "+bn.y );
			if(rn.cnt>10) return;
			for(int c=0;c<4;c++) {
					int rnx = rn.x+dx[c];
					int rny = rn.y+dy[c];
					int bnx = bn.x+dx[c];
					int bny = bn.y+dy[c];
					int rc=0;
					int bc=0;
//					System.out.println(c);
					while(true) {
						if(arr[bnx][bny]=='O') {
//							System.out.println("파란공 꼴인" +bnx + " "+bny+" "+c);
							break;
						}
					if(arr[rnx][rny]=='O') {
						int k=0;
						while(true) {
							if(arr[bnx][bny]=='O') {
								k=1;
								break;
							}
							else if(arr[bnx][bny]=='#') {
								break;
							}
							bnx+=dx[c];
							bny+=dy[c];
						}
						if(k==1) {
							k=0;
							break;
						}
						res=Math.min(rn.cnt+1, res);
						return;
					}
					if(arr[rnx][rny]!='.'&&arr[bnx][bny]!='.') {
						rnx-=dx[c];
						rny-=dy[c];
						bnx-=dx[c];
						bny-=dy[c];
						
//						System.out.println("sss"+rnx+" "+rny+" "+bnx+" "+bny);
						if(rnx==bnx&&rny==bny) {
							if(rc<bc) {
								bnx-=dx[c];
								bny-=dy[c];
							}else {
								rnx-=dx[c];
								rny-=dy[c];
							}
						}
						
						vr[rnx][rny]=true;
						vb[bnx][bny]=true;
						rq.add(new Node(rnx,rny,rn.cnt+1,c));
						bq.add(new Node(bnx,bny,bn.cnt+1,c));
//						System.out.println("input : "+rnx+" "+rny+" "+bnx+" "+bny);
						break;
					}
					if(arr[rnx][rny]!='#') {
						rnx+=dx[c];
						rny+=dy[c];
						rc++;
					}
					if(arr[bnx][bny]!='#') {
						bnx+=dx[c];
						bny+=dy[c];
						bc++;
					}
				}
					
				
			}
			
		}
	}
	
	static class Node{
		private int x;
		private int y;
		private int cnt;
		private int c;
		public Node(int x,int y,int cnt,int c) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
			this.c=c;
		}
	}
}