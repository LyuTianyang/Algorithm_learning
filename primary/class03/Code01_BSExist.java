package class03;

import java.util.Arrays;

public class Code01_BSExist {

	public static boolean find(int[] arr, int num) {
		if (arr == null || arr.length == 0) return false;
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = l + (r-l)/2;
			if (num == arr[mid]) {
				return true;
			} else if (num < arr[mid]) {
				r = mid - 1;
			} else if (num > arr[mid]) {
				l = mid + 1;
			}
		}
		return false;
	}

	// for test
	public static boolean test(int[] sortedArr, int num) {
		for (int cur : sortedArr) {
			if (cur == num) {
				return true;
			}
		}
		return false;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 10;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			Arrays.sort(arr);
			int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
			if (test(arr, value) != find(arr, value)) {
				System.out.println("Wrong");
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
}
