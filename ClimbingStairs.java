package easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		int p = 1, q = 1;
		for (int i = 2; i <= n; i++) {
			int temp = q;
			q += p;
			p = temp;
		}
		return q;
	}
	
	// mine
	public int climbStairs0(int n) {
		int i = 1, j = 1;
		for (int k = 1; k < n; k++) {
			int tmp = i;
			i = j;
			j += tmp;
		}
		return j;
	}
	
	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		System.out.println(c.climbStairs(5));
	}
}
