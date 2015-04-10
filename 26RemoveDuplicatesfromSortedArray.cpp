//
//  26RemoveDuplicatesfromSortedArray.cpp
//  test
//

#include <stdio.h>

class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if (n == 0) {
            return NULL;
        }
        int num = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] != A[i - 1]) {
                A[num++] = A[i];
            }
        }
        return num;
    }
};
//http://blog.csdn.net/havenoidea/article/details/12871613
    
    //Output Limit Exceeded
/*
    int removeDuplicates(int A[], int n) {
        if (n == 0) {
            return 0;
        }
        int cnt = 1;
        int item = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] == item) {
                continue;
            }
            cnt++;
            item = A[i];
        }
        return cnt;
    }
};*/
