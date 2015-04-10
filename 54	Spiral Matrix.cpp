//
//  54	Spiral Matrix.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        vector<int> result;
        if (matrix.empty()) {
            return result;
        }
        
        int row = matrix.size();
        int col = matrix[0].size();
        int count = row * col;
        int index = 1;
        int beginX = 0, endX = row - 1;
        int beginY = 0, endY = col - 1;
        
        while (index <= count) {
            for (int i = beginY; i <= endY; i++) {  // right
                result.push_back(matrix[beginX][i]);
                index++;
            }
            beginX++;
            if (beginX > endX) {
                break;
            }
            
            for (int i = beginX; i <= endX; i++) {  // down
                result.push_back(matrix[i][endY]);
                index++;
            }
            endY--;
            if (endY < beginY) {
                break;
            }
            
            for (int i = endY; i >= beginY; i--) {
                result.push_back(matrix[endX][i]);  // left
                index++;
            }
            endX--;
            if (endX < beginX) {
                break;
            }
            
            for (int i = endX; i >= beginX; i--) {
                result.push_back(matrix[i][beginY]);    // up
                index++;
            }
            beginY++;
            if (beginY > endY) {
                break;
            }
        }
        return result;
    }
};

/*int main() {
    Solution sol;
    
    vector<vector<int>> matrix = {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};
    vector<int> result = sol.spiralOrder(matrix);
    
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << ' ';
    }
    cout << endl;
    
    matrix = {{3}, { 2 }};
    result = sol.spiralOrder(matrix);
    
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << ' ';
    }
    cout << endl;
    
    return 0;
}*/
//http://blog.csdn.net/sunnyyoona/article/details/43525181
