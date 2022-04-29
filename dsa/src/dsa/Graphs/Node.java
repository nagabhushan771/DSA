package dsa.Graphs;

import java.util.Comparator;

public class Node implements Comparator<Node> {
	
	int vertex;
	int weight;
	
	public int getVertex() {
		return vertex;
	}



	public int getWeight() {
		return weight;
	}

	
	
	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	
	

//	@Override
//	public int compareTo(Node o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	public Node() {}

	@Override
	public int compare(Node o1, Node o2) {
		return o1.weight - o2.weight;
	}

}
