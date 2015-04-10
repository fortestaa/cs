//
//  35	Search Insert Position.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int searchInsert(int A[], int n, int target) {
        if (n <= 0) {
            return -1;
        }
        int start = 0, end = n - 1;
        // binary search
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (A[mid] == target) { // target found;
                return mid;
            } else if (A[mid] > target) {   // target in left half
                end = mid - 1;
            } else {    // target in right half
                start = mid + 1;
            }
        }
        return start; // target not found - insertion pos; end + 1
    }
};
//http://blog.csdn.net/sunnyyoona/article/details/43085449

/*int main() {
    Solution sol;
    int A[] = {1, 3, 5, 6};
    cout << sol.searchInsert(A, 4, 5) << endl;
    cout << sol.searchInsert(A, 4, 2) << endl;
    cout << sol.searchInsert(A, 4, 7) << endl;
    cout << sol.searchInsert(A, 4, 0) << endl;
    int B[] = {1};
    cout << sol.searchInsert(B, 1, 0) << endl;
    int C[] = {1, 3};
    cout << sol.searchInsert(C, 2, 2) << endl;
    return 0;
}*/
