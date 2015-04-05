package Chapter7_Stack;

import java.util.Stack;

/**
 * 39. Min Stack
 * https://leetcode.com/problems/min-stack/
 * 
 * Question:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 	push(x) – Push element x onto stack.
 * 	pop() – Removes the element on top of the stack.
 * 	top() – Get the top element.
 * 	getMin() – Retrieve the minimum element in the stack.
 * 
 * Hints:
 * Consider space-time tradeoff. How would you keep track of the minimums using extra space?
 * Make sure to consider duplicate elements. 
 */

/**
 * O(n) runtime, O(n) space – Extra stack:
 * Consider using an extra stack to keep track of the current minimum value.
 * During the push operation we choose the new element or the current minimum, whichever that is smaller to push onto the min stack.
 * For the pop operation, we would pop from both stacks. getMin() is then reflected by the top element of min stack.
 */
/**
 * O(n) runtime, O(n) space – Minor space optimization:
 * If a new element is larger than the current minimum, we do not need to push it on to the min stack.
 * When we perform the pop operation, check if the popped element is the same as the current minimum. If it is, pop it off the min stack too.
 */
public class Min_Stack {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}
	
	public void pop() {
		if (stack.pop().equals(minStack.peek()))	minStack.pop();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}
}