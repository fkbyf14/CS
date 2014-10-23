package org.alina.stepic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dmitry.maksimov on 23.10.14.
 */
public class StrongConnectCompGraph {
	static Node[] nodes;
	static int x;
	static int y;
	static boolean isAgreed = false;

	static int counter = 0;


	static class Node {
		int flag = 0;
		int id;
		ArrayList<Node> friends = new ArrayList();

		public void add(Node a) {
			if (!friends.contains(a)) {
				friends.add(a);
			}
		}

		public Node(int i) {
			id = i;
		}


	}

	static void DFS(int x) {
		if (nodes[x].flag == 0) {
			nodes[x].flag = 1;
		} else {
			return;
		}
		if (x == y) {
			counter++;
			isAgreed = true;
		}
		for (Node z : nodes[x].friends) {
			if (z.flag != 2) {
				DFS(z.id);
			}
		}
		if (isAgreed) {
			return;
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

			x = s.nextInt()-1;
			y = s.nextInt()-1;
		}
//		for (Node z:nodes) {
//			if (z.flag == 0) {
//				DFS(z.id);
//				counter++;
//			}
//		}
		DFS(x);
		System.out.println(counter);
	}
}
