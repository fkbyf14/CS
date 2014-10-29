package org.alina.stepic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dmitry.maksimov on 29.10.14.
 */
public class BellmanFord {
	static Node[] nodes;



	static class Node {

		int id;

		long distance = Integer.MAX_VALUE;

		ArrayList<Node> friends = new ArrayList();
		ArrayList<Integer> weights = new ArrayList<>();
		public void add(Node a, int weight) {
			friends.add(a);
			weights.add(weight);
		}

		public Node(int i) {
			id = i;
		}


	}
	static int bellmanFord(int x) {
		boolean relax ;
		for (int i = 0; i <= nodes.length; i++) {
			relax = false;
			for (Node temp : nodes) {
				for (int j = 0; j < temp.friends.size(); j++) {
					Node node = temp.friends.get(j);

					if ( node.distance > temp.distance + temp.weights.get(j)) {
						node.distance = temp.distance + temp.weights.get(j);
						relax = true;
					}
				}
			}

			if (!relax){
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		nodes = new Node[s.nextInt()];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i);
			nodes[i].distance = i;
		}

		int m = s.nextInt();  //количество рёбер

		while (m-- > 0) {
			int i = s.nextInt() - 1;
			int j = s.nextInt() - 1;
			int w = s.nextInt();
			nodes[i].add(nodes[j], w);
		}
		nodes[0].distance = 0;
		System.out.println(bellmanFord(nodes[0].id));
	}
}
