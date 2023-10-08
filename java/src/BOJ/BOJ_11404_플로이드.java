package BOJ;
import java.io.*;
import java.util.*;
class BOJ_11404_플로이드 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j]= 987654321;
			}
		}
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(arr[x][y]==987654321) {
				arr[x][y]=cost;
			}else {
				arr[x][y] = Math.min(arr[x][y],cost);
			}
			
		}
		
		for(int k=1;k<=n;k++) {
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(arr[i][j]>=arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i][j]>=987654321) {
					System.out.print(0+" ");
				}
				else {
				if(i==j) {
					System.out.print(0 + " ");
				}else {
					System.out.print(arr[i][j]+ " ");
				}
				}
			}
			System.out.println();
		}
		
		
	}
	
}