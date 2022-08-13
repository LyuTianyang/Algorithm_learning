package class07;

public class Code03_PathSum {

	// https://leetcode.com/problems/path-sum
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static boolean isSum = false;

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		isSum = false;
		process(root, 0, sum);
		return isSum;
	}

	public static void process(TreeNode node, int preSum, int sum) {
		if (node.left == null && node.right == null) {
			if (node.val + preSum == sum) {
				isSum = true;
			}
			return;
		}
		// node是非叶节点
		preSum += node.val;
		if (node.left != null) {
			process(node.left, preSum, sum);
		}
		if (node.right != null) {
			process(node.right, preSum, sum);
		}
	}

//	public static boolean hasPathSum(TreeNode root, int sum) {
//		if (root == null) {
//			return false;
//		}
//		return process(root, sum);
//	}
//
//	public static boolean process(TreeNode root, int rest) {
//		if (root.left == null && root.right == null) {
//			return root.val == rest;
//		}
//		boolean ans = root.left != null ? process(root.left, rest - root.val) : false;
//		ans |= root.right != null ? process(root.right, rest - root.val) : false;
//		return ans;
//	}

}
