package class01;

public class Code06_PrintB {

	public static void print(int num) {
		for (int i = 31; i >= 0; i--) {
			System.out.print((num & (1 << i)) == 0 ? "0" : "1");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int num = Integer.MAX_VALUE;
		System.out.println(num);
		print(num);
	}
}
