package algo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,L;
    static ArrayList<List<Integer>> station;
    static ArrayList<List<Integer>> route;
    static boolean[] visitedRoute,visitedStation;
    public static void main(String args[]) throws IOException
    {
    	st=new StringTokenizer(br.readLine());
    	station= new ArrayList<>();
    	route = new ArrayList<>();
    	N = Integer.parseInt(st.nextToken());
    	L= Integer.parseInt(st.nextToken());
    	visitedRoute = new boolean[L+1];
    	visitedStation = new boolean[N+1];
    	for(int i=0;i<=L;i++) {
    		route.add(new ArrayList<>());
    	}
    	for(int i=0;i<=N;i++) {
    		station.add(new ArrayList<>());
    	}
    	for(int i=1;i<=L;i++) {
    		int a=0;
    		st=new StringTokenizer(br.readLine());
    		while(true) {
    			a=Integer.parseInt(st.nextToken());
    			if(a==-1) break;
    			route.get(i).add(a);
    			station.get(a).add(i);
    		}
    		 
    	}
    	st=new StringTokenizer(br.readLine());
    	int start = Integer.parseInt(st.nextToken());
    	int end = Integer.parseInt(st.nextToken());
    	//System.out.println(route);
    	//System.out.println(station);
    	int res = bfs(start,end);
    	System.out.println(res);
    }
    static int bfs(int start,int end) {
    	Queue<Node> q = new LinkedList<>();
    	for(int i : station.get(start)) {
    		q.add(new Node(start,i,0));
    	}
    	
    	//System.out.println(q);
    	while(!q.isEmpty()) {
    		//System.out.println(q.toString());
    		Node n = q.poll();
    		for(int i : station.get(end)) {
    			if(n.nowRoute == i) return n.cnt;
    		}
    	
    		visitedRoute[n.nowRoute] = true;
    		visitedStation[n.nowStat] = true;
    		for(int i : route.get(n.nowRoute)) {
    			if(visitedStation[i]) continue;
    			visitedStation[i]=true;
    			for(int j : station.get(i)) {
    				if (visitedRoute[j]) continue;
					visitedRoute[j]=true;
					q.add(new Node(i,j,n.cnt+1));
					
					
    			}
    			
    			
    		}
    		
    	}
    	return -1;
    	
    }
    static class Node{
    	int nowStat, nowRoute,cnt;

		public Node(int nowStat, int nowRoute, int cnt) {
			super();
			this.nowStat = nowStat;
			this.nowRoute = nowRoute;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [nowStat=" + nowStat + ", nowRoute=" + nowRoute + ", cnt=" + cnt + "]";
		}
		
    	
    }
}


