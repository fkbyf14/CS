package org.alina.stepic;
import java.util.*;

public class StrongConnectCompGraph {

	static List<Node> start = new ArrayList<>();
	static List<Node> finish = new ArrayList<>();

	static Node[] nodes1;

	static int counter = 0;
	static int result = 0;

	static class Node {
		int flag = 0;
		int id;
		int start;
		int end;
		ArrayList<Node> friends = new ArrayList();

		public void add(Node a) {
			if (!friends.contains(a) && a.id != id) {
				friends.add(a);
			}
		}

		public Node(int i) {
			id = i;
		}

		public String toString() {
			return "flag=" + flag + ",id=" + id + ",start=" + start + ",end=" + end;
		}


	}

	static void DFS(Node[] nodes, int x) {
		if (nodes[x].flag == 0) {
			nodes[x].flag = 1;
			nodes[x].start = counter++;
		} else {
			return;
		}

		for (Node z : nodes[x].friends) {
			if (z.flag != 2)
				DFS(nodes, z.id);
		}

		nodes[x].flag = 2;
		nodes[x].end = counter++;
	}

	static Node[][] cutDrains() {
		Node[][] resultArr;
		boolean loop = true;
		List<Integer> listForDel = new ArrayList<>();
		while (loop) {
			loop = false;
			for (int i = 0; i < start.size(); i++) {
				Node temp = start.get(i);
				if (temp.friends.size() == 0) {
					for (Node node : finish.get(i).friends)
						start.get(node.id).friends.remove(temp);
					//finish.remove(i);
					//start.remove(i);
					result++;
					listForDel.add(i);
					loop = true;
				}
			}
			for (int i = finish.size() - 1; i >= 0; i--) {
				int size = listForDel.size();
				if (size == 0)
					break;
				if (i == listForDel.get(size - 1)) {
					finish.remove(i);
					start.remove(i);
					listForDel.remove(size - 1);
				} else {
					finish.get(i).id -= size;
					start.get(i).id -= size;
				}

			}
			listForDel.clear();
		}
		resultArr = new Node[2][finish.size()];
		resultArr[0] = finish.toArray(resultArr[0]);
		resultArr[1] = start.toArray(resultArr[1]);

		return resultArr;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			start.add(new Node(i));
			finish.add(new Node(i));
		}

		int m = s.nextInt();  //количество рёбер

		if (m == 0) {
			System.out.println(n);
			return;
		}
		while (m-- > 0) {
			int i = s.nextInt() - 1;
			int j = s.nextInt() - 1;
			start.get(i).add(start.get(j));
			finish.get(j).add(finish.get(i));

		}

		Node[][] temp = cutDrains();
		nodes1 = temp[0];
		Node[] nodes2 = temp[1];

		//System.out.println(Arrays.toString(nodes1));
		for (Node z : nodes1) {
			if (z.flag == 0) {
				DFS(nodes1, z.id);
			}
		}
		Arrays.sort(nodes1, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return -o1.end + o2.end;
			}
		});
		//System.out.println(Arrays.toString(nodes1));

		for (int i = 0; i < nodes1.length; i++) {
			nodes2[nodes1[i].id].id = i;
		}
		Arrays.sort(nodes2, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return +o1.id - o2.id;
			}
		});
		//System.out.println(Arrays.toString(nodes2));

		for (Node z : nodes2) {
			if (z.flag == 0) {
				DFS(nodes2, z.id);
				result++;
			}
		}
		System.out.println(result);
//----------------------------------------------
	}
}


