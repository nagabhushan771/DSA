package dsa.LL;

public class linkedList {
	Node head;
	
	void insertLast(int n) {
		Node new_node = new Node(n);
		if(head == null)
			head = new_node;
		else {
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
			
			temp.next = new_node;
		}
		return;
	}
	
	void insertFirst(int n) {
		Node new_node = new Node(n);
		if(head == null)
			head = new_node;
		else {
			new_node.next = head;
			head  = new_node;
		}
		return;
	}
	
	void insertAfterNnodes(int node_num, int n) {
		Node new_node = new Node(n);
		int place = node_num;
		if(head == null && node_num != 0) {
			System.out.println("There is no existing LL to insert at position "+node_num);
		} else if(head == null && node_num == 0) {
			head = new_node;
		}else {
			Node temp = head;
			while (node_num > 1 && temp.next != null) {
				temp = temp.next;
				node_num--;
			}
			if(node_num > 1) {
				System.out.println("LL is not having enough nodes to insert after node "+place);
			} else {
				new_node.next = temp.next;
				temp.next = new_node;
			}
		}
		
		return;
	}
	
	void insertAfterValue(int node_val, int val) {
		Node new_node = new Node(val);
		if(head.data == node_val) {
			new_node.next = head.next;
			head = new_node;
			return;
		}
		Node temp = head;
		while(temp!=null && temp.data != node_val) {
			temp = temp.next;
		}
		if(temp == null) {
			System.out.println("LL doesn't have the value "+ node_val);
		} else {
			new_node.next = temp.next;
			temp.next = new_node;
		}
		return;
		
	}
	
	void deleteOnReference(Node node) {
		Node temp = head;
		if(temp == node) {
			this.deleteFirst();
			return;
		}
		
		while(temp.next != null && temp.next != node) {
			temp = temp.next;
		}
		if(temp.next == null) {
			System.out.println("LL doesn't have the node specified");
			return;
		} else {
			temp.next = temp.next.next;
			return;
		}
	}
	
	void deleteFirst() {
		if(head == null) {
			System.out.println("LL doesn't exists");
		} else {
			head = head.next;
		}
	}
	
	void deleteByValue(int n) {
		Node temp = head;
		if(temp.data == n) {
			this.deleteFirst();
			return;
		}
		Node prev = temp;
		temp = temp.next;
		while(temp != null && temp.data != n) {
			prev = temp;
			temp = temp.next;
		}
		
		if(temp == null) {
			System.out.println("LL doesn't have the value "+n);
		} else {
			prev.next = temp.next;
		}
		return;
	}
	
	void deleteLast() {
		if(head == null) {
			System.out.println("LL doesn't exists");
		} else if(head.next == null) {
			head = null;
		} else {
			Node prev = head;
//			Node cur = head.next;
			while(prev.next.next != null) {
				prev = prev.next;
			}
			prev.next = null;
		}
	}
	
	void deleteNthNode(int node_num) {
		int place = node_num;
		if(head == null) {
			System.out.println("LL doesn't exists");
		} else {
			if(node_num == 1)
				this.deleteFirst();
			else {
				Node prev = head;
				Node cur = head.next;
				if(cur == null) {
					System.out.println("LL doesn't have " + node_num + " nodes");
				} else {
					while(node_num > 2 && cur.next != null) {
						prev = cur;
						cur = cur.next;
						node_num--;
					}
					if(node_num > 2) {
						System.out.println("LL doesn't have " + place + " nodes");
					} else {
						prev.next = cur.next;
					}
				}
			}
		}
	}
	
	void replaceData(int new_data, int old_data) {
		Node temp = head;
		while(temp != null && temp.data != old_data) {
			temp = temp.next;
		}
		if(temp == null) {
			System.out.println("LL doesn't have the value "+old_data);
		} else {
			temp.data = new_data;
		}
		return;
	}
	
	void reverseLinkedList() {
		Node oldHead = head;//Saving the reference of the head for traversing
		head = new Node(oldHead.data);//create new node with data of old head and assign that node to head
		oldHead = oldHead.next;//increment the oldHead reference
		while(oldHead != null) {
			this.insertFirst(oldHead.data);//go on inserting at first of the new LL until old LL exhausts
			oldHead = oldHead.next;
		}
		return;
	}
	
	Node reverse(Node head){
	    if(head == null || head.next == null)
	      return head;

	    Node revHead = reverse(head.next);
	    head.next.next = head;
	    head.next = null;
//	    this.head = revHead;
	    return revHead;
	  }
	void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("null");
		System.out.println();
	}
}
