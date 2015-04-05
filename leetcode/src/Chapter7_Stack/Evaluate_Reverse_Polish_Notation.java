package Chapter7_Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 40. Evaluate Reverse Polish Notation
 * 
 * Question:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression. Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * Example Questions Candidate Might Ask:
 * Q: Is an empty array a valid input?
 * A: No.
 * 
 * Solution:
 * The Reverse Polish Notation (RPN) is also known as the postfix notation, because each operator appears after its operands.
 * For example, the infix notation “3 + 4” is expressed as “3 4 +” in RPN.
 */
public class Evaluate_Reverse_Polish_Notation {

	/**
	 * The brute force approach:
	 * We look for the simplest RPN sequence that could be evaluated immediately, that is:
	 * Two successive operands followed by an operator such as “4 2 +”.
	 * We replace this sequence with the expression’s value and repeat until there is only one operand left.
	 * For example, [“4”, “13”, “5”, “/”, “+”] -> [“4”, “2”, “+”] -> [“6”]
	 * How would you do the replacement? You could do it in-place with the input array, but it would result in quadratic runtime as elements have to be shifted every time a replacement occurs.
	 * 
	 * A workaround is to copy the input array to a doubly linked list. The replacement is efficient and the next scan begins with the replaced value’s previous element.
	 * This results in an algorithm with linear runtime and linear space.
	 * Although this works, the implementation is complex and is far from ideal in an interview session.
	 * 
	 * The optimal approach:
	 * Observe that every time we see an operator, we need to evaluate the last two operands.
	 * Stack fits perfectly as it is a Last-In-First-Out (LIFO) data structure.
	 * We evaluate the expression left-to-right and push operands onto the stack until we encounter an operator, which we pop the top two values from the stack.
	 * We then evaluate the operator, with the values as arguments and push the result back onto the stack.
	 * For example, the infix expression “8 – ((1 + 2) * 2)” in RPN is: 8 1 2 +2 * – [p78]
	 * After the algorithm finishes, the stack contains only one value which is the RPN expression’s result; in this case, 2.
	 */
	private static final Set<String> OPERATORS = 
			new HashSet<>(Arrays.asList("+", "-", "*", "/"));
	
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (OPERATORS.contains(token)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(eval(x, y, token));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
	
	private int eval(int x, int y, String operator) {
		switch (operator) {
		case "+":	return x + y;
		case "-":	return x - y;
		case "*":	return x * y;
		default:	return x / y;
		}
	}
	
	/*
	 * Further Thoughts:
	 * The above code contains duplication. For example, if we decide to add a new operator, we would need to update the code in two places – in the set’s initialization and the switch statement. Could you refactor the code so it is more extensible?
	 * You are probably not expected to write this refactored code during an interview session.
	 * However, it will make you a stronger candidate if you could make this observation and point this out, as it shows to the interviewer that you care about clean code.
	 * In Java, create an interface called Operator and map each operator string to an implementation of the Operator interface. For other languages such as C++, each operator will be mapped to a function pointer instead.
	 */
	interface Operator {
		int eval(int x, int y);
	}
	
	private static final Map<String, Operator> OPERATORS1 =
			new HashMap<String, Operator>() {{
				put("+", new Operator() {
					public int eval(int x, int y) { return x + y; }
				});
				put("-", new Operator() {
					public int eval(int x, int y) { return x - y; }
				});
				put("*", new Operator() {
					public int eval(int x, int y) { return x * y; }
				});
				put("/", new Operator() {
					public int eval(int x, int y) { return x / y; }
				});
			}};
	
	public int evalRPN1(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (OPERATORS1.containsKey(token)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(OPERATORS1.get(token).eval(x, y));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
}