//
//  55	Jump Game.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <iostream>
using namespace std;

class Solution {
public:
    bool canJump(int A[], int n) {
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (i > end) {
                continue;
            }
            if (A[i] + i > end) {
                end = A[i] + i;
            }
            if (end >= n - 1) {
                return true;
            }
        }
        return false;
    }
};

/*int main() {
    Solution sol;
    
    int A[] = {2,3,1,1,4};
    sol.canJump(A, 5);
    cout << sol.canJump(A, 5) << endl;
    
    int B[] = {3,2,1,0,4};
    cout << sol.canJump(B, 5) << endl;
    
    int C[] = {2,5,0,0};
    cout << sol.canJump(C, 5) << endl;
    
    return 0;
}*/
//http://www.raychase.net/2666#jump-game
