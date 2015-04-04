package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle 
 * https://leetcode.com/problems/pascals-triangle-ii/
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangle2 {
	/**
     * Generate in-place within a list
     * 0, 0, 0, 0, initialized, 1, 0, 0, 0
     * i = 1, 1, 1, 0, 0
     * i = 2, 1, 2, 1, 0
     * i = 3, 1, 3, 3, 1
     */
	public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) { // repeat k times
        	for (int j = i - 1; j >= 1; j--) { // do it backwards
        		row.set(j, row.get(j - 1) + row.get(j));
        	}
        	row.add(1); // add 1 at the end
        }
        return row;
    }
	//https://github.com/FreeTymeKiyan/LeetCode-Sol-Res/blob/master/Easy/PascalsTriangle2.java

	public List<Integer> getRow0(int rowIndex) {
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if (rowIndex < 0)   return null;
        
        for (int i = 0; i <=  rowIndex; i++) {
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
        return rs.get(rowIndex);
    }
}
