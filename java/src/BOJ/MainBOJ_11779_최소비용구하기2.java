package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class MainBOJ_11779_최소비용구하기2 {
	static ArrayList<ArrayList<Node>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(x).add(new Node(y, cost, "", 1));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int[] cost = new int[n + 1];
		for (int i = 1; i < cost.length; i++) {
			cost[i] = Integer.MAX_VALUE;
		}
		for (ArrayList<Node> nodes : list) {
			for (int j = 0; j < nodes.size(); j++) {
				nodes.get(j).s += start;
			}
		}
		cost[start] = 0;
		dijkstra(start, end, cost);
	}

	static void dijkstra(int start, int end, int[] cost) {

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.add(new Node(start, cost[start], start + "", 1));
		StringBuilder sb = new StringBuilder();
		boolean[] v = new boolean[cost.length];
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			if (v[n.idx]) {
				continue;
			}
			v[n.idx] = true;

			if (n.idx == end) {
				System.out.println(cost[end]);
				System.out.println(n.cnt);
				System.out.println(n.s);
			}
			for (Node next : list.get(n.idx)) {
				if (!v[next.idx] && cost[next.idx] > n.cost + next.cost) {
					cost[next.idx] = n.cost + next.cost;
					pq.add(new Node(next.idx, cost[next.idx], n.s + " " + next.idx, n.cnt + 1));
				}
			}
		}
	}

	static class Node {
		int idx;
		int cost;
		String s;
		int cnt;

		Node(int idx, int cost, String s, int cnt) {
			this.idx = idx;
			this.cost = cost;
			this.cnt = cnt;
			this.s = s;
		}

		public String toString() {
			return "{" + idx + ", " + cost + ", " + s + "}";
		}
	}
}


