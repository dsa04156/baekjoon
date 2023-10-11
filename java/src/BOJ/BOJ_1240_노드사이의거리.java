package BOJ;
import java.io.*;
import java.util.*;
class BOJ_1240_노드사이의거리 { 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[][] map = new int[n+1][n+1];
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				map[i][j]=92345678;
			}
		}
		int[] item = new int[n+1];
		for(int i=1;i<=n;i++) {
			int t = Integer.parseInt(st.nextToken());
			item[i]=t;
		}
		for(int i=0;i<r;i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			map[a][b]=l;
			map[b][a]=l;
		}
		for(int k=1;k<=n;k++) {
			map[k][k]=0;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j]=map[i][k]+map[k][j];
					}
				}
			}
		}
		int res = -1;
		for(int i=1;i<=n;i++) {
			int cnt=0;
			for(int j=1;j<=n;j++) {
				if(map[i][j]<=m) {
					cnt+=item[j];
				}
			}
			res = Math.max(cnt, res);
		}
		System.out.println(res);
	}
	
}