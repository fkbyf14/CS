package org.alina.stepic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dmitry.maksimov on 24.04.14.
 */
public class UndirectedGraph {
	static Node[] nodes;


	static class Node {
		int flag = 0;
		static ArrayList<Node> friends = new ArrayList();

		public void add(Node a) {
			friends.add(a);
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
		}
		int i = s.nextInt();
		int j = s.nextInt();
		nodes[i].flag=1;
		//if(friends.)
	}

}