package class01;

public class Code06_BSAwesome {

	/**
	 * 无序数组中(正负零) 任意两个相邻的数不相等 找出至少一个局部最小 [0]<[1], [n-1]<[n-2], [i]<[i-1]&[i]<[i+1]
	 */
	public static int getLessIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1; // no exist
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = left + ((right - left) >> 1);
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return left;
	}

}
