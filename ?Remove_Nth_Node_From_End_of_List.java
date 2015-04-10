package easy;

public class Remove_Nth_Node_From_End_of_List {
	/* Dummy head and Runner's technique */
	/* https://github.com/FreeTymeKiyan/LeetCode-Sol-Res/blob/master/Easy/RemoveNthNodeFromEnd.java */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode p1 = pre;
		ListNode p2 = pre;
		int i = 0;
		while (i < n) {
			p2 = p2.next;
			i++;
		}
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		p1.next = p1.next.next;
		return pre.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
