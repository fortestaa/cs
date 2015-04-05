package chapter3;

public class Queue {
	Node first, last;

	void enqueue(Object item) {
		if (first == null) {	//if (!first)
			last = new Node(item);
			first = last;
		} else {
			last.next = new Node(item);
			last = last.next;
		}
	}
	
	Node dequeue(Node n) {
		if (first != null) {
			Object item = first.data;
			first = first.next;
			//return item;
			return first;
		}
		return null;
	}
}
