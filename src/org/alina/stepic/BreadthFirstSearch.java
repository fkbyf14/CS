package org.alina.stepic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by dmitry.maksimov on 29.10.14.
 */
public class BreadthFirstSearch {
	static Node[] nodes;
	static int u;
	static int v;
	static Queue<Node> queue = new LinkedList();

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


	}

	static int BFS(int x) {
		int counterY = 0;
		int counterX = 0;
			nodes[x].flag = 1;
			if(x==v){
				return counterY;
			}
		queue.add(null);
			queue.addAll(nodes[x].friends);
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			if(temp == null){
				counterX = queue.size();
				counterY++;
				if (counterX != 0)
					queue.add(null);
				continue;
			}
			counterX--;
			if(temp.id == v)
				return counterY;
			if(temp.flag == 1)
				continue;
			temp.flag = 1;
			for (Node friend : temp.friends) {
				queue.add(friend);
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
			nodes[i].add(nodes[j]);
			nodes[j].add(nodes[i]);
		}
		 u = s.nextInt() - 1;
		v = s.nextInt() - 1;
		System.out.println(BFS(u));
	}

}