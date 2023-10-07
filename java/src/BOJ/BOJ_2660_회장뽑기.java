package BOJ;
import java.io.*;
import java.util.*;
class BOJ_2660_회장뽑기 {
	static int N;
	static int map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				map[i][j]=200;
			}
		}
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x==-1&&y==-1) break;
			map[x][y]=1;
			map[y][x]=1;
		}
		int[] point = new int[N+1];
		for(int k=1;k<=N;k++) {
			map[k][k]=0;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i==j) continue;
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j]=map[i][k]+map[k][j];
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			int max = Integer.MIN_VALUE;
			for(int j=1;j<=N;j++) {
				if(map[i][j]!=0) {
					max = Math.max(max, map[i][j]);
				}
			}
			min = Math.min(min, max);
			point[i]=max;
		}
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(min==point[i]) {
				cnt++;
			}
		}
		System.out.println(min + " " + cnt);
		for(int i=1;i<=N;i++) {
			if(min==point[i])
				System.out.print(i+" ");
		}
	}
	
}