package class10;

import java.util.Stack;

public class Code03_UnRecursiveTraversalBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int v) {
			value = v;
		}
	}

	// 1. 栈顶出来记为cur
	// 2. 入栈: 头 右 左
	public static void pre(Node head) {
		System.out.print("pre-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(head);
			while (!stack.isEmpty()) {
				Node cur = stack.pop();
				System.out.print(cur.value + " ");
				if (cur.right != null) {
					stack.push(cur.right);
				}
				if (cur.left != null) {
					stack.push(cur.left);
				}
			}
		}
		System.out.println();
	}

	// 1.当前结点cur，整条左边界入栈
	// 2.栈中弹出节点打印,节点右孩子成为cur重复第一步
	// 3.栈为空就停止
	public static void in(Node cur) {
		System.out.print("in-order: ");
		if (cur != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || cur != null) {
				if (cur != null) {
					stack.push(cur);
					cur = cur.left;
				} else {
					cur = stack.pop();
					System.out.print(cur.value + " ");
					cur = cur.right;
				}
			}
		}
		System.out.println();
	}

	// 1. stack2 入栈: 头 右 左
	public static void pos1(Node head) {
		System.out.print("pos-order: ");
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while (!s1.isEmpty()) {
				Node cur = s1.pop();
				s2.push(cur);// 入栈: 头 右 左
				if (cur.left != null) {
					s1.push(cur.left);
				}
				if (cur.right != null) {
					s1.push(cur.right);
				}
			}
			// 左 右 头
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}

	public static void pos2(Node h) {
		System.out.print("pos-order: ");
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		pre(head);
		System.out.println("========");
		in(head);
		System.out.println("========");
		pos1(head);
		System.out.println("========");
		pos2(head);
		System.out.println("========");
	}

}
