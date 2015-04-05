package chapter3;

/*
 * 3.2
 * How would you design a stack which, in addition to push and pop, 
 * also has a function min which returns the minimum element? 
 * Push, pop and min should all operate in O(1) time.
 * */		
public class MinStack {
	/*
	 * You can implement this by having each node in the stack keep track of the minimum beneath itself. 
	 * Then, to find the min, you just look at what the top element thinks is the min.
	 * When you push an element onto the stack, the element is given the current minimum. It sets its “local min” to be the min.
	 * */
	//public class StackWithMin extends Stack<NodeWithMin>{
	public class StackWithMin extends Stack{
		public void push(int value) {
			int newMin = Math.min(value, min());
			super.push(new NodeWithMin(value, newMin));
		}
		
		public int min() {
			if (this.isEmpty()) {
				return Integer.MAX_VALUE;
			} else {
				NodeWithMin p = (NodeWithMin) peek();
				return p.min;
			}
		}
	}
	
	class NodeWithMin extends Node {
		public int value;
		public int min;
		
		public NodeWithMin(int v, int min) {
			super(v);
			value = v;
			this.min = min;
		}
	}
	
	/*
	 * There’s just one issue with this: 
	 * if we have a large stack, we waste a lot of space by keeping track of the min for every single element. Can we do better?
	 * We can (maybe) do a bit better than this by using an additional stack which keeps track of the mins.
	 * */
	public class StackWithMin2 extends Stack {	// extends Stack<Interger>
		Stack s2;	// Stack<Integer> s2;
		public StackWithMin2() {
			s2 = new Stack();	//Stack<Integer>();
		}
		public void push(int value) {
			if (value <= min()) {
				s2.push(value);
			}
			super.push(value);
		}
		public Node pop() {	// public Integer pop()
			Node value = super.pop();	//int value = (int) super.pop().data;
			int val = (int) value.data;
			if (val == min()) {
				s2.pop();
			}
			return value;
		}
		public int min() {
			if (s2.isEmpty()) {
				return Integer.MAX_VALUE;
			} else {
				return (int) s2.peek().data;	// return s2.peek();
			}
		}
	}
	/*
	 * Why might this be more space efficient? 
	 * If many elements have the same local min, then we’re keeping a lot of duplicate data. 
	 * By having the mins kept in a separate stack, we don’t have this duplicate data 
	 * (although we do use up a lot of extra space because we have a stack node instead of a single int).
	 * */
}
