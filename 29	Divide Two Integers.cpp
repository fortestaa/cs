//
//  29	Divide Two Integers.cpp
//  leetcode_medium

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

/* 
 Divide two integers without using multiplication, division and mod operator.
 
 If it is overflow, return MAX_INT.
 */

class Solution {
public:
    int divide(int dividend, int divisor) {
        int sign = 1;
        
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        unsigned long long tmp = abs((long long)dividend);
        unsigned long long tmp2 = abs((long long)divisor);
        
        unsigned long c = 1;
        while (tmp > tmp2) {
            tmp2 = tmp2 << 1;
            c = c << 1;
        }
        
        int res = 0;
        while (tmp >= abs((long long)divisor)) {
            while (tmp >= tmp2) {
                tmp -= tmp2;
                res += c;
            }
            tmp2 = tmp2 >> 1;
            c = c >> 1;
        }
        
        if (dividend < 0 && divisor < 0) {
            return res;
        } else if (dividend > 0 && divisor > 0) {
            return res;
        } else {
            return -res;
        }
    }
};

//http://yucoding.blogspot.com/2013/01/leetcode-question-28-divide-two-integers.html
//http://www.cnblogs.com/TenosDoIt/p/3795342.html
//http://blog.csdn.net/kenden23/article/details/16986763
