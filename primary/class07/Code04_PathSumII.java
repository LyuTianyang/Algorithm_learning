package class07;

import java.util.ArrayList;
import java.util.List;

public class Code04_PathSumII {

	// 测试链接：https://leetcode.com/problems/path-sum-ii
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		ArrayList<Integer> path = new ArrayList<>();
		process(root, path, 0, sum, ans);
		return ans;
	}

	public static void process(TreeNode node, List<Integer> path, int preSum, int sum, List<List<Integer>> ans) {
		if(node.left == null && node.right == null) {
			if(preSum + node.val == sum) {
				path.add(node.val);
				ans.add(copy(path));
				//清理掉叶节点
				path.remove(path.size()-1);
			}
			return;
		}
		//非叶节点
		preSum += node.val;
		if(node.left != null) {
			path.add(node.val);
			process(node.left,path,preSum,sum,ans);
			path.remove(path.size()-1);
		}
		if(node.right != null) {
			path.add(node.val);
			process(node.right,path,preSum,sum,ans);
			path.remove(path.size()-1);
		}
		
	}

	public static List<Integer> copy(List<Integer> path) {
		List<Integer> ans = new ArrayList<>();
		for (Integer num : path) {
			ans.add(num);
		}
		return ans;
	}

}
