package org.alina.stepic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by dmitry.maksimov on 21.10.14.
 */
public class GraphLoop {
	static Node[] nodes;
	static int x;
	static int y;
	static int counter = 0;


	static class Node {
		int flag = 0;
		int id;
		ArrayList<Node> friends = new ArrayList();

		//public void add(Node a) {
			//friends.add(a);
		//}
		public void add(Node a) {
			if (!friends.contains(a)) {
				friends.add(a);
			}
		}

		public Node(int i) {
			id = i;
		}

		public String toString() {
			return "flag=" + flag + ",id=" + id;
		}
	}

	static Set<Integer> a = new HashSet<>();

	static int DFS(int x) {
		if (!a.add(x))
			return 1;
		if (nodes[x].flag == 0) {
			nodes[x].flag = 1;
		} else {
			return 0;
		}
		for (Node z : nodes[x].friends) {
			if (z.flag != 2) {
				if (DFS(z.id)== 1)
					return 1;
				a.remove(z.id);
			} else {
				if (!a.add(z.id))
					return 1;
			}
		}
		nodes[x].flag = 2;
		return 0;
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
		boolean x = false;
		for (Node z : nodes) {
			if (z.flag == 0 && DFS(z.id) == 1) {
				System.out.println(1);
				x = true;
				break;
			}
			a.clear();
		}
		if (!x)
			System.out.println(0);
	}
}
