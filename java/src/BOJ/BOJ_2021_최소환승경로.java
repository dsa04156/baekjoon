package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2021_최소환승경로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,L;
	static boolean[] visitedStat;
	static boolean[] visitedLine;
	static ArrayList<List<Integer>> stat; //각 역에 어떤 노석을 포함하였는지
	static ArrayList<List<Integer>> line; // 노선에 어떤역이 들어있는지
	public static void main(String[] args) throws NumberFormatException, IOException {
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		visitedLine = new boolean[L+1];
		visitedStat = new boolean[N+1];
		stat = new ArrayList<>();
		line = new ArrayList<>();
		for(int i=0;i<N+1;i++) {
			stat.add(new ArrayList<>());
		}
		for(int i=0;i<L+1;i++) {
			line.add(new ArrayList<>());
		}
		
		int k=0;
		for(int i=0;i<L;i++) {
			st=new StringTokenizer(br.readLine());
			while(true) {			
				k= Integer.parseInt(st.nextToken());
				if(k==-1) break;
				line.get(i).add(k);
				stat.get(k).add(i);
				
			}
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int answer = go(start,end);

		System.out.println(answer);
		
	}
	static int go(int start,int end) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		visitedStat[start] = true;
		for(int i=0;i<stat.get(start).size();i++) {
			q.add(new Node(stat.get(start).get(i),start,0));
			visitedLine[stat.get(start).get(i)]=true;
		}
		while(!q.isEmpty()){
			Node n = q.poll();
			if(n.curStat == end) {
				return n.cnt;
			}
			for(int nextStation : line.get(n.curLine)) {
				if(!visitedStat[nextStation]) {
					visitedStat[nextStation]= true;
					q.add(new Node(n.curLine,nextStation,n.cnt));
					
					for(int nextLine : stat.get(nextStation)) {
						if(!visitedLine[nextLine]) {
							visitedLine[nextLine]=true;
							q.add(new Node(nextLine,nextStation,n.cnt+1));
						}
					}
				}
			}
		}
		return -1;
		
	}
	static class Node implements Comparable<Node>{
		int curLine, curStat,cnt;

		public Node(int curLine, int curStat, int cnt) {
			super();
			this.curLine = curLine;
			this.curStat = curStat;
			this.cnt = cnt;
		}
		public int compareTo(Node o) {
			return cnt - o.cnt;
		}
		
	}
}

