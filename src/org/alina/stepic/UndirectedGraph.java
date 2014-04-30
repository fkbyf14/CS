package org.alina.stepic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dmitry.maksimov on 24.04.14.
 */
public class UndirectedGraph {
	static Node[] nodes;
	static int x;
	static int y;
	static boolean isAgreed = false;


	static class Node {
		int flag = 0;
		int id;
		ArrayList<Node> friends = new ArrayList();

		public void add(Node a) {
			friends.add(a);
		}

		public Node(int i) {
			id = i;
		}

		/*boolean containsNode(Node n) {
			return friends.contains(n);
		}*/
	}

	static void DFS(int x) {
		if (nodes[x].flag == 0) {
			nodes[x].flag = 1;
		} else {
			return;
		}
		if (x == y) {
			System.out.println("True");
			isAgreed = true;
		}
		for (Node z : nodes[x].friends) {
			if (z.flag != 2) {
				DFS(z.id);
			}
			if (isAgreed) {
				return;
			}
		}
		/*for (int z = 0; z < nodes[x].friends.size(); z++) {
			if (nodes[z].flag != 2 && nodes[x].containsNode(nodes[z])) {
				DFS(z);
			}*/

		nodes[x].flag = 2;
		if(x == UndirectedGraph.x&&!isAgreed){

			System.out.println("False");
		}
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
			nodes[j].add(nodes[i]);

		}
		x = s.nextInt()-1;
		y = s.nextInt()-1;
		DFS(x);
	}
}

