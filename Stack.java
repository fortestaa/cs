package chapter3;

public class Stack {
	Node top;
	int size;
	
	Node pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			//return item;
			return top;
		}
		return null;
	}
	
	void push(Object item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}
	
	Node peek() {
		return top;
	}

	boolean isEmpty() {
		return top == null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
}
