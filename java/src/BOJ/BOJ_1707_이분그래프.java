package BOJ;
import java.io.*;
import java.util.*;
class BOJ_1707_이분그래프 {
	static ArrayList<ArrayList<Integer>> list;
	static int[] color;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=k;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			for(int i=0;i<=v;i++) {
				list.add(new ArrayList<>());
			}
			color = new int[v+1];
			for(int i=0;i<e;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.get(x).add(y);
				list.get(y).add(x);
			}
			int c = 1;
			res = true;
			for(int i=1;i<=v;i++) {
				if(!res) break;
				if(color[i]==0) {
					dfs(i,c);
				}
			}
			System.out.println(res ? "YES":"NO");
			
		}
	}
	static boolean res;
	static void dfs(int x,int c) {
		color[x]=c;
		for(int i : list.get(x)) {
			if(color[i]==c) {
				res = false;
				return;
			}
			
			if(color[i]==0) {
				dfs(i,-c);
			}
			}
	}
	
}