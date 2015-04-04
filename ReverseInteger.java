package easy;

public class ReverseInteger {
	private static final int MAXDIV10 = Integer.MAX_VALUE / 10;

	public int reverse(int x) {
		int ret = 0;
		while (x != 0) {
			if (Math.abs(ret) > MAXDIV10 || Math.abs(ret) == MAXDIV10 && x % 10 > 8)
				return 0;
			ret = ret * 10 + x % 10;
			x = x / 10;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(123));
		System.out.println(ri.reverse(-123));
	}
}
