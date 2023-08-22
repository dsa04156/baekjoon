package BOJ;
import java.io.*;
import java.util.*;
class BOJ_1005_ACMCraft {
	static int N,K,W;
	static int[] building;
	static int[] indegree;
	static int[] buildCost;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			building = new int[N+1];
			list = new ArrayList[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				building[i]=Integer.parseInt(st.nextToken());
				list[i]=new ArrayList<>();
			}
			indegree = new int[N+1];
			for(int i=1;i<=K;i++) {
				st= new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y= Integer.parseInt(st.nextToken());
				list[x].add(y);
				indegree[y]++;
				
			}
			W = Integer.parseInt(br.readLine());
			
			buildCost = new int[N+1];
			topologySort();
			System.out.println(buildCost[W]);
		
		}
	}
	static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<indegree.length;i++) {
			if(indegree[i]==0) {
				buildCost[i]=building[i];
				q.offer(i);
			}
		}
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int i=0;i<list[current].size();i++) {
				int next = list[current].get(i);
				buildCost[next] = Math.max(buildCost[current]+building[next],buildCost[next]);
				indegree[next]--;
				if(indegree[next]==0) q.offer(next);
			}
		}
		
		
	}
}