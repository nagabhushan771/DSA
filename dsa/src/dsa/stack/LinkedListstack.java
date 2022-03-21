package dsa.stack;

import dsa.LL.Node;

public class LinkedListstack {
	Node top;
	
	LinkedListstack(){
		top = null;
	}
	
	@SuppressWarnings("unused")
	void push(int n) {
		Node new_node = new Node(n);
		if(new_node == null) {
			System.out.println("Stack Overflow");
			return;
		}
		new_node.next = top;
		top = new_node;
	}
	
	int pop() {
		if(top == null) {
			System.out.println("Stack Underflow");
			return -1;
		}
		int x = top.data;
		top = top.next;
		return x;
		
	}
	
	int peek() {
		if(top == null)
			return -1;
		return top.data;
	}
	
	boolean isEmpty() {
		return top == null;
	}
}
