package dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijxtras {

	public static void main(String[] args) {
		//Reading graph and the source
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of vertices : ");
		int vert = sc.nextInt();
		System.out.print("Enter the number of edges : ");
		int edge = sc.nextInt();
		ArrayList<ArrayList<Node>> adjList = new ArrayList<>(vert);
		for(int i = 0; i<vert; i++) {
			adjList.add(new ArrayList<Node>());
		}
		for(int i = 0; i<edge; i++) {
			System.out.print("Enter the vertex1 and vertex2 and the weight between them in the same order : ");
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			int weight = sc.nextInt();
			adjList.get(vertex1).add(new Node(vertex2, weight));
			adjList.get(vertex2).add(new Node(vertex1, weight));
		}
		
		
		int[][] dist = new int[vert][vert];
//		System.out.print("Enter the source : ");
//		int source = sc.nextInt();
		
		//fill the distance array with max Integer value except source
		for(int i = 0; i<vert; i++) {
			for(int j = 0; j<vert; j++) {
				dist[i][j] = i==j ? 0 : Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i< vert; i++)
			dijxtras(adjList, i, dist[i]);
		for(int i = 0; i<vert; i++)
			System.out.println(Arrays.toString(dist[i]));
	}

	private static void dijxtras(ArrayList<ArrayList<Node>> adjList, int source, int[] dist) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(dist.length, new Node());
		
		pq.offer(new Node(source, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			for(Node i : adjList.get(cur.getVertex())) {
				if(dist[i.getVertex()] > cur.getWeight() + i.getWeight()) {
					dist[i.getVertex()] = cur.getWeight() + i.getWeight();
					pq.offer(new Node(i.getVertex(), dist[i.getVertex()]));
				}
			}
		}
		return;
	}
	
	

}
