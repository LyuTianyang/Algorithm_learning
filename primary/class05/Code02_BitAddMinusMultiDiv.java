package class05;

// https://leetcode.com/problems/divide-two-integers
public class Code02_BitAddMinusMultiDiv {

	public static int add(int a, int b) {
		int sum = a;
		while (b != 0) {
			//无进位相加信息
			sum = a ^ b;
			//进位信息
			b = (a & b) << 1;
			a = sum;
		}
		return sum;
	}

	//取负数:取反加1
	public static int negNum(int n) {
		return add(~n, 1);
	}

	public static int minus(int a, int b) {
		return add(a, negNum(b));
	}

	public static int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			//1&1==1 0&1==0 0&0==0
			if ((b & 1) != 0) {
				res = add(res, a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return res;
	}

	public static boolean isNeg(int n) {
		return n < 0;
	}

	public static int div(int a, int b) {
		//把a和b都转换为正数
		int x = isNeg(a) ? negNum(a) : a;
		int y = isNeg(b) ? negNum(b) : b;
		int res = 0;
		for (int i = 30; i >= 0; i = minus(i, 1)) {
			if ((x >> i) >= y) {
				// |或运算： 两个二进制数同位上只要有一个为1就为1
				res |= (1 << i);
				//找到最接近的i位后减去y<<i
				x = minus(x, y << i);
			}
		}
		//判断正负号
		return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
	}

	public static int divide(int a, int b) {
		if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
			return 1;
		} else if (b == Integer.MIN_VALUE) {
			return 0;
		} else if (a == Integer.MIN_VALUE) {
			if (b == negNum(1)) {
				return Integer.MAX_VALUE;
			} else {
				/*
				 * a/b
				 * (a+1)/b == c
				 * a - (b*c) = d
				 * d / b = e
				 * c + e
				 */
				int c = div(add(a, 1), b);
				return add(c, div(minus(a, multi(c, b)), b));
			}
		} else {
			return div(a, b);
		}
	}
	
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		System.out.println(a&b);
	}

}
