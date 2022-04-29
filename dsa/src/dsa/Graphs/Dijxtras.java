package dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijxtras {

	public static void main(String[] args) {
		
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
//		int vert = 5;
//        ArrayList<ArrayList<Node> > adjList = new ArrayList<ArrayList<Node>>();
//		
//		for (int i = 0; i < vert; i++) 
//			adjList.add(new ArrayList<Node>());
//			
//		adjList.get(0).add(new Node(1, 2));
//		adjList.get(1).add(new Node(0, 2));
//		
//		adjList.get(1).add(new Node(2, 4));
//		adjList.get(2).add(new Node(1, 4));
//		
//		adjList.get(0).add(new Node(3, 1));
//		adjList.get(3).add(new Node(0, 1));
//		
//		adjList.get(3).add(new Node(2, 3));
//		adjList.get(2).add(new Node(3, 3));
//		
//		adjList.get(1).add(new Node(4, 5));
//		adjList.get(4).add(new Node(1, 5));
//		
//		adjList.get(2).add(new Node(4, 1));
//		adjList.get(4).add(new Node(2, 1));
		int[] dist = new int[vert];
		System.out.print("Enter the source : ");
		int source = sc.nextInt();
		for(int i = 0; i<vert; i++) {
			dist[i] = i==source ? 0 : Integer.MAX_VALUE;
		}
		
		dijxtras(adjList, source, dist);
		System.out.println(Arrays.toString(dist));
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
