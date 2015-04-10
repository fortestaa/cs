//
//  34	Search for a Range.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<int> searchRange(int A[], int n, int target) {
        vector<int> result;
        if (n <= 0) {
            return result;
        }
        
        // min pos of target
        int left = searchStartRange(A, n, target);
        
        // max pos of target
        int right = searchEndRange(A, n, target);
        
        result.push_back(left);
        result.push_back(right);
        return result;
    }
    
private:
    // min pos of target
    int searchStartRange(int A[], int n, int target) {
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) { // target is mid
                if (mid - 1 >= 0 && A[mid - 1] == target) { // if left of mid-element == target
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else if (A[mid] < target) {   // target is in right half
                start = mid + 1;
            } else {    // target is in left half
                end = mid - 1;
            }
        }
        return -1;
    }
    
    // max pos of target
    int searchEndRange(int A[], int n, int target) {
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) { // target is mid
                if (mid + 1 < n && A[mid + 1] == target) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else if (A[mid] < target) {   // target in right half
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return  -1;
    }
};
//http://blog.csdn.net/sunnyyoona/article/details/43084477

/*int main() {
    Solution solution;
    int A[] = {1};
    int n = 1;
    int target = 0;
    vector<int> result = solution.searchRange(A, n, target);
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << endl;
    }
    return 0;
}*/
