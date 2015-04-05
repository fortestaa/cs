package chapter3;

/*
 * 3.1
 * Describe how you could use a single array to implement three stacks.
 * */
public class ThreeStack {
	/*
	 * Approach 1: Divide the array in three equal parts and allow the
	 * individual stack to grow in that limited space (note: “[“ means
	 * inclusive, while “(“ means exclusive of the end point). » for stack 1, we
	 * will use [0, n/3) » for stack 2, we will use [n/3, 2n/3) » for stack 3,
	 * we will use [2n/3, n) This solution is based on the assumption that we do
	 * not have any extra information about the usage of space by individual
	 * stacks and that we can’t either modify or use any extra space. With these
	 * constraints, we are left with no other choice but to divide equally.
	 */
	public class Stack {
		int stackSize = 300;
		int[] buffer = new int[stackSize * 3];
		int[] stackPointer = { 0, 0, 0 }; // stack pointers to track top elem

		void push(int stackNum, int value) {
			// Find the index of the top element in the array + 1, and increment
			// the stack pointer
			int index = stackNum * stackSize + stackPointer[stackNum];
			stackPointer[stackNum]++;
			buffer[index] = value;
		}

		int pop(int stackNum) {
			int index = stackNum * stackSize + stackPointer[stackNum];
			stackPointer[stackNum]--;
			int value = buffer[index];
			buffer[index] = 0;
			return value;
		}

		int peek(int stackNum) {
			int index = stackNum * stackSize + stackPointer[stackNum];
			return buffer[index];
		}

		boolean isEmpty(int stackNum) {
			return stackPointer[stackNum] == stackNum * stackSize;
		}
	}

	/*
	 * Approach 2: In this approach, any stack can grow as long as there is any
	 * free space in the array. We sequentially allocate space to the stacks and
	 * we link new blocks to the previous block. This means any new element in a
	 * stack keeps a pointer to the previous top element of that particular
	 * stack. In this implementation, we face a problem of unused space. For
	 * example, if a stack deletes some of its elements, the deleted elements
	 * may not necessarily appear at the end of the array. So, in that case, we
	 * would not be able to use those newly freed spaces. To overcome this
	 * deficiency, we can maintain a free list and the whole array space would
	 * be given initially to the free list. For every insertion, we would delete
	 * an entry from the free list. In case of deletion, we would simply add the
	 * index of the free cell to the free list. In this implementation we would
	 * be able to have flexibility in terms of variable space utilization but we
	 * would need to increase the space complexity.
	 */
	public class Stack2 {
		int stackSize = 300;
		int indexUsed = 0;
		int[] stackPointer = { -1, -1, -1 };
		StackNode[] buffer = new StackNode[stackSize * 3];

		void push(int stackNum, int value) {
			int lastIndex = stackPointer[stackNum];
			stackPointer[stackNum] = indexUsed;
			indexUsed++;
			buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value);
		}

		int pop(int stackNum) {
			int value = buffer[stackPointer[stackNum]].value;
			int lastIndex = stackPointer[stackNum];
			stackPointer[stackNum] = buffer[stackPointer[stackNum]].previous;
			buffer[lastIndex] = null;
			indexUsed--;
			return value;
		}

		int peek(int stack) {
			return buffer[stackPointer[stack]].value;
		}

		boolean isEmpty(int stackNum) {
			return stackPointer[stackNum] == -1;
		}

		class StackNode {
			public int previous;
			public int value;

			public StackNode(int p, int v) {
				value = v;
				previous = p;
			}
		}
	}
}
