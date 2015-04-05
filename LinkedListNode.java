package chapter2;

public class LinkedListNode {
	LinkedListNode next = null;
	int data;
	public LinkedListNode(int d) { data = d; }
	
	// creating a linked list
	void appendToTail(int d) {
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while (n.next != null) { n = n.next; }
		n.next = end;
	}
	
	// deleting a Node from a Singly Linked List
	LinkedListNode deleteNode(LinkedListNode head, int d) {
		LinkedListNode n = head;
		if (n.data == d) {
			return head.next;	// move head
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;	// head didn't change
			}
			n = n.next;
		}
		return head;
	}
	
	void setNext(LinkedListNode next) {
		this.next = next;
	}
}
