package class06;

import java.util.HashMap;

//测试链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
public class Code05_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// 有一棵树，先序结果是pre[L1...R1], 中序结果是in[L2...R2] 建出整棵树返回头结点
	public static TreeNode buildTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length != in.length) {
			return null;
		}
		return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	public static TreeNode helper(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
		if(L1 > R1) {
			return null;
		}
		TreeNode head = new TreeNode(pre[L1]);
		if(L1 == R1) {
			return head;
		}
		//找到head结点在中序遍历中的位置, 返回下标
		int find = L2;
		while(in[find] != pre[L1]) {
			find++;
		}
		head.left = helper(pre, L1+1, (L1+1)+(find-1)-L2, in, L2, find-1);
		head.right = helper(pre, (L1+1)+(find-1)-L2+1, R1, in, find+1, R2);
		return head;
	}
	
	public static TreeNode buildTree2(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length != in.length) {
			return null;
		}
		HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			valueIndexMap.put(in[i], i);
		}
		return g(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
	}

	// 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
	// 请建出整棵树返回头节点
	public static TreeNode g(int[] pre, int L1, int R1, int[] in, int L2, int R2,
			HashMap<Integer, Integer> valueIndexMap) {
		if (L1 > R1) {
			return null;
		}
		TreeNode head = new TreeNode(pre[L1]);
		if (L1 == R1) {
			return head;
		}
		int find = valueIndexMap.get(pre[L1]);
		head.left = g(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, valueIndexMap);
		head.right = g(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, valueIndexMap);
		return head;
	}

}
