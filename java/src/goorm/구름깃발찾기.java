package goorm;
import java.io.*;
import java.util.*;
class 구름깃발찾기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int dx[] = new int[] {-1,-1,0,1,1,1,0,-1};
		int dy[] = new int[] {0,1,1,1,0,-1,-1,-1};
		int res=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int k=0;
				if(arr[i][j]==1) continue;
				
				for(int c=0;c<8;c++) {
					int nx = i+dx[c];
					int ny = j+dy[c];
					if(nx>=N||ny>=N||nx<0||ny<0) continue;
					
					if(arr[nx][ny]==1) {
						k++;
					}
				}
				if(k==K) {
					res++;
				}
			}
		}
		System.out.println(res);
	
	}
}