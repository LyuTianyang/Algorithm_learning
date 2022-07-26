package class01;

public class Code02_selectionSort {

	public static void selectSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int minValIdx = i;
			for(int j=i+1; j<n; j++) {
				minValIdx = arr[j] < arr[minValIdx] ? j : minValIdx;
			}
			swap(arr, i, minValIdx);
		}
	}

	public static void insertSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		//0 - 0
		//0 - 1
		//0 - 2
		//0 - 3
		//0 - n-1
		int N = arr.length;
		for(int end = 1; end < N; end++) {
			int newNumIdx = end;
			while(newNumIdx - 1 >= 0 && arr[newNumIdx-1] > arr[newNumIdx]) {
				swap(arr, newNumIdx-1, newNumIdx);
				newNumIdx--;
			}
		}
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 3, 5, 1, 6, 8, 1, 3, 5, 7, 5, 6 };
		printArray(arr);
		insertSort(arr);
		printArray(arr);
	}
}
