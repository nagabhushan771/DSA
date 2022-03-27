package dsa.LL;

public class Application {

	public static void main(String[] args) {
		LinkedListOwn ll = new LinkedListOwn();
		
//		ll.deleteNthNode(9);
//		ll.deleteFirst();
//		ll.deleteLast();
//		ll.insertAfterNnodes(2, 4);
//		ll.printList();
//		ll.insertLast(2);
//		ll.printList();
//		ll.insertFirst(1);
//		ll.printList();
//		ll.deleteFirst();
//		ll.printList();
//		ll.insertLast(5);
//		ll.printList();
//		ll.insertAfterNnodes(2, 4);
//		ll.printList();
//		ll.deleteLast();
//		ll.printList();
//		ll.insertAfterNnodes(2, 3);
//		ll.printList();
//		ll.insertAfterValue(2, 9);
//		ll.printList();
//		ll.deleteNthNode(3);
//		ll.printList();
//		ll.deleteNthNode(2);
//		ll.printList();
//		ll.deleteNthNode(1);
//		ll.printList();
//		Node node = ll.head.next;
//		ll.deleteOnReference(node);
//		ll.printList();
//		ll.deleteByValue(5);
//		ll.printList();
//		ll.replaceData(11, 3);
//		ll.printList();
//		ll.insertAfterNnodes(6, 4);
//		ll.printList();
//		System.out.println("after reversing");
//		ll.head = ll.reverse(ll.head);
//		ll.printList();
		ll.insertLast(1);
		ll.insertLast(2);
		ll.insertLast(3);
		ll.insertLast(4);
		ll.insertLast(5);
		ll.printList();
		ll.head = ll.reverseBetween(ll.head, 2, 4);
		ll.printList();
	}

}
