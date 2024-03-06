package 공식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class 다익스트라 {

	static int[] answer;

	static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = toInt(st.nextToken());
		int E = toInt(st.nextToken());
		int K = toInt(br.readLine());
		ArrayList<ArrayList<Node>> list = new ArrayList<>();

		for (int i = 0; i < V + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = toInt(st.nextToken());
			int v = toInt(st.nextToken());
			int w = toInt(st.nextToken());
			list.get(u).add(new Node(v, w));
		}
		int[] answer = new int[V + 1];
		for (int i = 1; i < V + 1; i++)
			answer[i] = Integer.MAX_VALUE;

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost - o2.cost;
			}
		});
		pq.add(new Node(K, 0));
		boolean[] v = new boolean[V + 1];
		answer[K] = 0;
		while (!pq.isEmpty()) {
			Node n = pq.poll();

			if (v[n.idx])
				continue;
			v[n.idx] = true;
			for (Node next : list.get(n.idx)) {
				if (!v[next.idx] && answer[next.idx] > answer[n.idx] + next.cost) {
					answer[next.idx] = answer[n.idx] + next.cost;
					pq.add(new Node(next.idx, answer[next.idx]));
				}
			}

		}
		// boolean[] v = new boolean[V + 1];
		// answer[K] = 0;
		// for (int i = 0; i < V; i++) {
		// 	int nodeValue = Integer.MAX_VALUE;
		// 	int nodeIdx = 0;
		// 	for (int j = 1; j < V + 1; j++) {
		// 		if (!v[j] && answer[j] < nodeValue) {
		// 			nodeIdx = j;
		// 			nodeValue = answer[j];
		// 		}
		// 	}
		// 	v[nodeIdx] = true;
		// 	for (int j = 0; j < list.get(nodeIdx).size(); j++) {
		// 		Node adjNode = list.get(nodeIdx).get(j);
		// 		if (answer[adjNode.idx] > answer[nodeIdx] + adjNode.cost) {
		// 			answer[adjNode.idx] = answer[nodeIdx] + adjNode.cost;
		// 		}
		// 	}
		// }
		for (int i = 1; i < V + 1; i++) {
			if (answer[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(answer[i]);
		}

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


