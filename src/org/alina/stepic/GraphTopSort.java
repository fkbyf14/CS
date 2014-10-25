package org.alina.stepic;

import java.util.*;

/**
 * Created by dmitry.maksimov on 22.10.14.
 */
public class GraphTopSort {
	static Node[] nodes;
	static int counter = 0;


	static class Node {
		int flag = 0;
		int id;
		ArrayList<Node> friends = new ArrayList();
		int timeExit;

		public void add(Node a) {
			friends.add(a);
		}

		public Node(int i) {
			id = i;
		}

		public String toString() {
			return "flag=" + flag + ",id=" + id;
		}
	}


	static void DFS(int x) {
		++counter;
		if (nodes[x].flag == 0) {
			nodes[x].flag = 1;
		} else {
			return;
		}
		for (Node z : nodes[x].friends) {
			if (z.flag != 2) {
				DFS(z.id);
				z.timeExit = ++counter;
			}
		}
		nodes[x].flag = 2;
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
			nodes[i].add(nodes[j]);
		}
		for (Node z : nodes) {
			if (z.flag == 0) {
				DFS(z.id);
				z.timeExit = ++counter;
			}
		}
		//Arrays.sort(nodes, new MyComparator());
		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.timeExit - o1.timeExit;
			}
		});
		for (Node node : nodes) {
			System.out.print(node.id + 1 + " ");
		}
	}
//
//	static class MyComparator implements Comparator<Node> {
//		@Override
//		public int compare(Node o1, Node o2) {
//			return o2.timeExit - o1.timeExit;
//		}
//	}
}
