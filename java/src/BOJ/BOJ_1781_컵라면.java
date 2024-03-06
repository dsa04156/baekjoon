package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.deadLine != o2.deadLine) {
					return o1.deadLine - o2.deadLine;
				} else {
					return o2.cup - o1.cup;
				}
			}
		});
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.add(new Node(i, a, b));
		}
		int time = 1;
		int res = 0;
		PriorityQueue<Node> pq2 = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cup - o2.cup;
			}
		});
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			if (n.deadLine >= time) {
				pq2.add(n);
				time++;
			} else {
				if (pq2.peek().cup < n.cup) {
					pq2.poll();
					pq2.add(n);
				}
			}

		}
		while (!pq2.isEmpty()) {
			res += pq2.poll().cup;
		}
		System.out.println(res);

	}

	public static class Node {
		int no;
		int deadLine;
		int cup;

		public Node(int no, int deadLine, int cup) {
			this.no = no;
			this.cup = cup;
			this.deadLine = deadLine;
		}

		public String toString() {
			return no + "번 : " + deadLine + " " + cup;
		}
	}

}
