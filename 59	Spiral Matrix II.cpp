//
//  59	Spiral Matrix II.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        int max = n * n;
        int beginX = 0, endX = n - 1;
        int beginY = 0, endY = n - 1;
        int A[n][n];
        int index = 0;
        
        while (index < max) {
            // right
            for (int i = beginY; i <= endY; i++) {
                A[beginX][i] = index + 1;
                index++;
            }
            beginX++;
            if (beginX > endX) {
                break;
            }
            
            // down
            for (int i = beginX; i <= endX; i++) {
                A[i][endY] = index + 1;
                index++;
            }
            endY--;
            if (endY < beginY) {
                break;
            }
            
            // left
            for (int i = endY; i >= beginY; i--) {
                A[endX][i] = index + 1;
                index++;
            }
            endX--;
            if (endX < beginX) {
                break;
            }
            
            // up
            for (int i = endX; i >= beginX; i--) {
                A[i][beginY] = index + 1;
                index++;
            }
            beginY++;
            if (beginY > endY) {
                break;
            }
        }
        
        vector<vector<int>> result;
        for (int i = 0; i < n; i++) {
            vector<int> tmp;
            for (int j = 0; j < n; j++) {
                tmp.push_back(A[i][j]);
            }
            result.push_back(tmp);
        }
        return result;
    }
};

/*int main() {
    Solution sol;
    
    vector<vector<int>> rst = sol.generateMatrix(3);
    for (int i = 0; i < rst.size(); i++) {
        cout << "[ ";
        for (int j = 0; j < rst[i].size(); j++) {
            cout << rst[i][j] << ", ";
        }
        cout << "]" << endl;
    }
    return 0;
}*/
