//
//  27RemoveElement.cpp
//  test
//

#include <stdio.h>

class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        if (n == 0) {
            return NULL;
        }
        
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != elem) {
                A[num++] = A[i];
            }
        }
        return num;
    }
};
