package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ_1238_파티 {
	static ArrayList<ArrayList<Node>> list;
	static int[] cost;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.get(x).add(new Node(y, c));
		}

		for (int i = 1; i <= N; i++) {

			int a = sol(i, X, N);
			int b = sol(X, i, N);
			max = Math.max(a + b, max);
		}
		System.out.println(max);
	}

	static int sol(int start, int end, int N) {
		cost = new int[N + 1];
		for (int j = 1; j <= N; j++) {
			cost[j] = Integer.MAX_VALUE;
		}
		cost[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.add(new Node(start, 0));
		boolean[] v = new boolean[N + 1];
		int res = 0;
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			if (v[n.idx])
				continue;
			v[n.idx] = true;
			if (n.idx == end) {
				res = n.cost;
				break;
			}

			for (Node next : list.get(n.idx)) {
				if (cost[next.idx] > n.cost + next.cost) {
					cost[next.idx] = n.cost + next.cost;
					pq.add(new Node(next.idx, cost[next.idx]));
				}
			}
		}
		return res;
	}

	static class Node {
		int idx;
		int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}


