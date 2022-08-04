package class05;

import java.util.HashSet;

public class Code01_BitMap1 {

	public static class BitMap {

		private long[] bits;

		public BitMap(int max) {
			//(max + 64) >> 6 -> (max + 64) / 2^6
			bits = new long[(max + 64) >> 6];
		}

		public void add(int num) {
			// num >> 6 -> num / 64 -> 哪个整数
			// num % 64 -> num & 63 (&该位只要有一个值为0结果为0，否则结果为1)
			//1只有32位 1L有64位
			bits[num >> 6] |= (1L << (num & 63));
		}

		public void delete(int num) {
			//改成0
			bits[num >> 6] &= ~(1L << (num & 63));
		}

		public boolean contains(int num) {
			return (bits[num >> 6] & (1l << (num & 63))) != 0;
		}

	}

	public static void main(String[] args) {
		System.out.println("Test start");
		int max = 10000;
		BitMap bitMap = new BitMap(max);
		HashSet<Integer> set = new HashSet<>();
		int testTime = 10000000;
		for (int i = 0; i < testTime; i++) {
			int num = (int) (Math.random() * (max + 1));
			double decide = Math.random();
			if (decide < 0.333) {
				bitMap.add(num);
				set.add(num);
			} else if (decide < 0.666) {
				bitMap.delete(num);
				set.remove(num);
			} else {
				if (bitMap.contains(num) != set.contains(num)) {
					System.out.println("Oops!");
					break;
				}
			}
		}
		for (int num = 0; num <= max; num++) {
			if (bitMap.contains(num) != set.contains(num)) {
				System.out.println("Oops!");
			}
		}
		System.out.println("Test end");
	}

}
