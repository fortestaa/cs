//
//  63	Unique Paths II.cpp
//  leetcode_medium
//

/*
 Follow up for "Unique Paths":
 
 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.
 
 Note: m and n will be at most 100.
 */

#include <stdio.h>
#include <vector>
using namespace std;

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        int s[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                for (int j = i; j < n; j++) {
                    s[j] = 0;
                    break;
                }
            } else {
                s[i] = 1;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j-1] == 1) {
                    ;
                } else {
                    s[j] = s[j] + s[j-1];
                }
            }
        }
        return s[n-1];
    }
    
    int main() {
        Solution s;
        cout << s.uniquePaths(3, 4) << endl;
    }
};
