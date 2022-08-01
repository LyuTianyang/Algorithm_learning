package class04;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
public class Code04_ReverseNodesInKGroup {

	/**
	 * 
	 * head = [1,2,3,4,5], k = 2
	 * output = [2,1,4,3,5]
	 * 
	 * head = [1,2,3,4,5], k = 3
	 * output = [3,2,1,4,5]
	 */
	
	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode start = head;
		ListNode end = getKGroupEnd(start, k);
		if (end == null) {
			return head;
		}
		//first group is good
		head = end;
		reverse(start, end);
		//endpoint of previous group
		ListNode lastEnd = start;
		while(lastEnd.next != null ) {
			start = lastEnd.next;
			end = getKGroupEnd(start, k);
			if (end == null) {
				return head;
			}
			reverse(start, end);
			lastEnd.next = end;
			lastEnd = start;
		}
		return head;
	}
	
	public static ListNode getKGroupEnd(ListNode start, int k) {
		while(--k != 0 && start != null) {
			start = start.next;
		}
		return start;
	}
	
	public static void reverse(ListNode start, ListNode end) {
		end = end.next;
		ListNode pre = null;
		ListNode cur = start;
		ListNode next = null;
		while(cur != end) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		start.next = end;
	}
}
