//
//  36	Valid Sudoku.cpp
//  test
//

#include <stdio.h>
#include <vector>
using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char> > &board) {
        int i, j, k;
        bool used[9];   // is 1-9 used
        for (i = 0; i < 9; i++) {
            // check lines
            memset(used, false, 9);
            for (j = 0; j < 9; j++) {
                if (!check(board[i][j], used)) {    // rule not matched
                    return false;
                }
            }
            
            // check columns
            memset(used, false, 9);
            for (j = 0; j < 9; j++) {
                if (!check(board[j][i], used)) {    // rule not matched
                    return false;
                }
            }
        }
        
        // check 9 grids
        for (k = 0; k < 3; k++) {
            memset(used, false, 9);
            for (i = k * 3; i < 3 * k + 3; i++) {
                for (j = 0; j < 3; j++) {
                    if (!check(board[i][j], used)) {    // rule not matched
                        return false;
                    }
                }
            }
            memset(used, false, 9);
            for (i = k * 3; i < 3 * k + 3; i++) {
                for (j = 3; j < 6; j++) {
                    if (!check(board[i][j], used)) {    // rule not matched
                        return false;
                    }
                }
            }
            memset(used, false, 9);
            for (i = k * 3; i < 3 * k + 3; i++) {
                for (j = 6; j < 9; j++) {
                    if (!check(board[i][j], used)) {    // rule not matched
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
private:
    bool check(char c, bool used[9]) {
        if (c == '.') {
            return true;
        }
        if (used[c - '1']) {    // char c used
            return false;
        } else {    // char c not used
            used[c - '1'] = true;
            return true;
        }
    }
};
//http://blog.csdn.net/sunnyyoona/article/details/18550743

