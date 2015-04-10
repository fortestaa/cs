//
//  53	Maximum Subarray.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <iostream>
using namespace std;

class Solution {
public:
    int maxSubArray(int A[], int n) {
        return Divide(A, 0, n - 1);
    }
    
private:
    int Divide(int A[], int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return A[left];
        }
        
        int mid = (right + left) / 2;
        int sum = 0;
        int leftMax = A[mid];
        for (int i = mid; i >= left; --i) {
            sum += A[i];
            leftMax = max(sum, leftMax);
        }
        
        sum = 0;
        int rightMax = A[mid + 1];
        for (int i = mid + 1; i <= right; i++) {
            sum += A[i];
            rightMax = max(sum, rightMax);
        }
        
        int aMax = Divide(A, left, mid);
        int bMax = Divide(A, mid + 1, right);
        int cMax = leftMax + rightMax;
        return max(max(aMax, bMax), cMax);
    }
};

/*int main() {
    Solution sol;
    
    int A[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    cout << sol.maxSubArray(A, 9) << endl;
    
    return 0;
}*/
//http://blog.csdn.net/sunnyyoona/article/details/43200983
