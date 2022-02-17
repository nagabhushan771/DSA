package dsa;

import java.util.*;
import java.io.*;

public class Add2NumbersInLL {
	public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//      int m = sc.nextInt();
//      int n = sc.nextInt();
//
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
//      for(int i = 0; i<m; i++){
//        int a = sc.nextInt();
//        ll1.insert(a);
//      }
//
//      for(int i = 0; i<n; i++){
//        int a = sc.nextInt();
//        ll2.insert(a);
//      }

		ll1.insert(4);
		ll1.insert(5);
		ll2.insert(3);
		ll2.insert(4);
		ll2.insert(5);
		ll1.printList();
		ll2.printList();
		ll1.head = ll1.reverse(ll1.head);
		ll2.head = ll2.reverse(ll2.head);
		ll1.printList();
		ll2.printList();
		int carry = 0;
		Node temp1 = ll1.head;
		Node temp2 = ll2.head;
		LinkedList res = new LinkedList();
		while (temp1 != null && temp2 != null) {
			int sum = 0;
			sum = temp1.data + temp2.data + carry;
			carry = sum / 10;
			sum %= 10;
			res.insert(sum);
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		if (temp1 != null) {
			while (temp1 != null) {
				int sum = 0;
				sum = temp1.data + carry;
				carry = sum / 10;
				sum %= 10;
				res.insert(sum);
				temp1 = temp1.next;
			}
		}
		if (temp2 != null) {
			while (temp2 != null) {
				int sum = 0;
				sum = temp2.data + carry;
				carry = sum / 10;
				sum %= 10;
				res.insert(sum);
				temp2 = temp2.next;
			}
		}
		res.head = res.reverse(res.head);
		res.printList();
		return;
	}

}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}

class LinkedList {
	Node head;

	void insertFirst(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
		return;
	}

	void insert(int data) {
		Node new_node = new Node(data);
		if (head == null)
			head = new_node;
		else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = new_node;
		}
		return;
	}

	// Node reverse(Node head){
	// if(head == null || head.next == null)
	// return head;

	// Node revHead = reverse(head.next);
	// head.next.next = head;
	// head.next = null;
	// return revHead;
	// }
	Node reverse(Node head) {
		if (head == null || head.next == null)
			return head;

		Node revHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
//	    this.head = revHead;
		return revHead;
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		return;
	}
}
