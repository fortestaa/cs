//
//  48	Rotate Image.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    // 对于n * n 的2维矩阵: A[i][j] -> A[j][n-1-i]
    void rotate(vector<vector<int> > &matrix) {
        int i, j;
        int n = matrix.size();
        vector<vector<int>> tempMatrix = matrix;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                tempMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                matrix[i][j] = tempMatrix[i][j];
            }
        }
    }
};

/*int main() {
    Solution sol;
    
    vector<int> row1 = {1, 2, 3};
    vector<int> row2 = {4, 5, 6};
    vector<int> row3 = {7, 8, 9};
    vector<vector<int>> matrix;
    matrix.push_back(row1);
    matrix.push_back(row2);
    matrix.push_back(row3);
    sol.rotate(matrix);
    int n = matrix.size();
    for (int i = 0; i < n; i++) {
        for (int j = 0 ; j < n; j++) {
            cout << matrix[i][j] << ' ';
        }
        cout << endl;
    }
    
    return 0;
}*/
//http://blog.csdn.net/sunnyyoona/article/details/18566587
