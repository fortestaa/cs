//
//  62	Unique Paths.cpp
//  leetcode_medium
//

/*
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 
 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 
 How many possible unique paths are there?
 
 Note: m and n will be at most 100.
 */
#include <stdio.h>
#include <iostream>
using namespace std;

class Solution {
public:
    /*
     设s[i][j] 为从起点到（i,j）位置处的路径数。
     通过分析得到：第一行，第一列都为1
     到其他位置处（i,j）：到达位置（i,j）只能从上面或者左面过来，因此决定到位置（i,j）的路径数由到达上面位置（i-1,j）的路径数和到达左面位置（i,j-1）的路径所决定的。
     状态转移方程：
     s[i][j] = s[i-1][j] + s[i][j-1]
     时间复杂度：O(n^2)  空间复杂度：O(n^2)
     */
    int uniquePaths1(int m, int n) {
        int s[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    s[i][j] = 1;
                } else {
                    s[i][j] = s[i][j - 1] + s[i - 1][j];
                }
            }
        }
        return s[m - 1][n - 1];
    }
    
    /*
     使用空间轮转的思路，节省空间。
     状态转移方程：
     s[j] = s[j] + s[j-1]
     时间复杂度：O(n^2)  空间复杂度：O(n)
     */
    int uniquePaths(int m, int n) {
        int s[n];
        for (int i = 0; i < n; i++) {
            s[i] = 1;   // 1 for first line
        }
        
        for (int i = 1; i < m; i++) {   // from 2nd line
            for (int j = 1; j < n; j++) {   // (i, j)
                s[j] = s[j] + s[j - 1];
            }
        }
        return s[n - 1];
    }
};

/*int main() {
    Solution s;
    cout << s.uniquePaths(3, 4) << endl;
}*/
//http://blog.csdn.net/sunnyyoona/article/details/43458319
