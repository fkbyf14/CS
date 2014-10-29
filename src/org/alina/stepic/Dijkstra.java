package org.alina.stepic;

import java.util.*;

/**
 * Created by dmitry.maksimov on 29.10.14.
 */
public class Dijkstra {
	static Node[] nodes;
	static int u;
	static int v;
	static PriorityQueue<Node> queue = new PriorityQueue<>();

	static class Node implements Comparable<Node> {
		int id;
		int distance = -1;
		Node prev;
		boolean inf = true;
		ArrayList<Node> friends = new ArrayList();
		ArrayList<Integer> weights = new ArrayList<>();

		public void add(Node a, int weight) {
			friends.add(a);
			weights.add(weight);
		}

		public Node(int i) {
			id = i;
		}

		@Override
		public int compareTo(Node o) {
			if (inf) {
				if (o.inf)
					return 0;
				return 1;
			}
			if (o.inf) {
				return -1;
			}
			if (distance < o.distance)
				return -1;
			if (distance > o.distance)
				return 1;
			return 0;
		}
	}

	static long dijkstra(int x) {
		if(x == v){
			return 0;
		}
		queue.addAll(Arrays.asList(nodes));
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			if (temp.id == v)
				return temp.distance;
			if (temp.inf)
				return -1;
			for (int i =0; i < temp.friends.size(); i++) {
				Node node = temp.friends.get(i);
				if ((node.inf || node.distance > temp.distance + temp.weights.get(i)) && queue.remove(node)){
					node.distance = temp.distance + temp.weights.get(i);
					node.inf = false;
					//node.prev = temp;
					queue.add(node);
				}
			}
		}
		return  -1;

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		nodes = new Node[s.nextInt()];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i);
		}

		int m = s.nextInt();  //количество рёбер

		while (m-- > 0) {
			int i = s.nextInt() - 1;
			int j = s.nextInt() - 1;
			int w = s.nextInt();
			nodes[i].add(nodes[j], w);
		}
		u = s.nextInt() - 1;
		v = s.nextInt() - 1;
		nodes[u].distance = 0;
		nodes[u].inf = false;
		long dist = dijkstra(u);
		System.out.println(dist);
	}

}
