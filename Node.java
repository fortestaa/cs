package chapter4;

import java.util.LinkedList;

import chapter4.Chapter4_2.State;

public class Node {
	private static Object data;
	private static Node next;
	static State state;
	private static LinkedList<Node> adjnodes;

	Node(Object x) {
		data = x;
	}
	
	public static LinkedList<Node> getAdjacent() {
		return adjnodes;
	}
}
