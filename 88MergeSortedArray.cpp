//
//  88MergeSortedArray.cpp
//

#include <stdio.h>
#include <iostream>
using namespace std;

class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        int C[m+n];
        int k = 0;
        int i = 0, j = 0;
        for (; i < m && j < n; ) {
            if (A[i] < B[j]) {
                C[k++] = A[i];
                i++;
            } else {
                C[k++] = B[j];
                j++;
            }
        }
        
        if (i < m) {
            for (; i < m; i++) {
                C[k++] = A[i];
            }
        }
        if (j < n) {
            for (; j < n; j++) {
                C[k++] = B[j];
            }
        }
        for (int i = 0; i < m + n; i++) {
            A[i] = C[i];
            //cout << A[i] << ' ';
        }
        //cout << endl;
    }
};
