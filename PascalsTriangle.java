package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle https://leetcode.com/problems/pascals-triangle/
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if (numRows == 0)   return rs;
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            if (i > 0) {
                if (i != 1) {
                    for (int j = 1; j < i; j++) {
                        tmp.add(rs.get(i - 1).get(j - 1) + rs.get(i - 1).get(j));
                    }
                }
                tmp.add(1);
            }
            rs.add(tmp);
        }
        return rs;
    }

	public static void main(String[] args) {
		PascalsTriangle p = new PascalsTriangle();
		List<List<Integer>> rs = p.generate(5);
		for (int i = 0; i < rs.size(); i++) {
			System.out.println(rs.get(i));
		}
	}
}
