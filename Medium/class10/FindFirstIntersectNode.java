package class10;

import class10.Code01_FindFirstIntersectNode.Node;

public class FindFirstIntersectNode {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}

	// 找到链表第一个入环节点，如果无环，返回null
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node slow = head.next;
		Node fast = head.next.next;
		while (slow != fast) {
			if (fast.next == null || fast.next.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	// 如果两个链表都无环，返回第一个相交节点，如果不想交，返回null
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n1 = 0;
		while (cur1 != null) {
			n1++;
			cur1 = cur1.next;
		}
		int n2 = 0;
		while (cur2 != null) {
			n2++;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		}
		cur1 = n1 > n2 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		int difference = Math.abs(n1 - n2);
		while(difference != 0) {
			difference--;
			cur1 = cur1.next;
		}
		while(cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	// 两个有环链表，返回第一个相交节点，如果不想交返回null
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = head1;
		Node cur2 = head2;
		if(loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n1 = 0;
			while (cur1 != loop1) {
				n1++;
				cur1 = cur1.next;
			}
			int n2 = 0;
			while (cur2 != loop2) {
				n2++;
				cur2 = cur2.next;
			}
			cur1 = n1 > n2 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			int difference = Math.abs(n1 - n2);
			while(difference != 0) {
				difference--;
				cur1 = cur1.next;
			}
			while(cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}else {
			cur1 = loop1.next;
			while(cur1 != loop1) {
				if(cur1 == loop2) {
					return cur1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
}
