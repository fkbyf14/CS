package org.alina.stepic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dmitry.maksimov on 24.04.14.
 */
public class UndirectedGraph {
	static Node[] nodes;
	//static boolean[][] graph;

	static class Node {
		int flag = 0;
		static ArrayList<Node> friends = new ArrayList();

		public void add(Node a) {
			friends.add(a);
		}

		static boolean containsNode(Node n) {
			return friends.contains(n);
		}
	}


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		nodes = new Node[s.nextInt()];
		for (int i = 0; i < s.nextInt(); i++) {
			nodes[i] = new Node();
		}

		int m = s.nextInt();  //количество рёбер
		while (m-- > 0) {
			int i = s.nextInt();
			int j = s.nextInt();
			nodes[i].add(nodes[j]);
			nodes[j].add(nodes[i]);
			//graph[i][j] = true;
		}
		int x = s.nextInt();
		int y = s.nextInt();

	static String DFS(int x) {
		if (nodes[x].flag == 0) {
			nodes[x].flag = 1;
		} else {
			return "";
		}
		if (x == y) {
			System.out.println("True");
		}
		for (int z = 0; z < nodes[x].friends.size(); z++) {
			if (nodes[z].flag != 2 && nodes[x].containsNode(nodes[z])) {
				DFS(z);
			}
			nodes[x].flag = 2;
		}

	}
}
}

