//
//  70ClimbingStairs.cpp
//

#include <stdio.h>
#include <vector>
using namespace std;

class Solution {
public:
    //Time Limit Exceeded
    /*
    int climbStairs(int n) {
        return climbStairsRecur(n);
    }
    
    int climbStairsRecur(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairsRecur(n - 1) + climbStairsRecur(n - 2);
    }*/
    
    /*int climbStairs(int n) {
        vector<int> res(n + 1);
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }*/
    //http://blog.csdn.net/kenden23/article/details/17377869
    
    int climbStairs(int n) {
        int fn_2 = 1, fn_1 = 2;
        if (n == 1) {
            return fn_2;
        }
        if (n == 2) {
            return fn_1;
        }
        int fn;
        for (int i = 3; i <= n; i++) {
            fn = fn_2 + fn_1;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
    //http://fisherlei.blogspot.com/2013/01/leetcode-climbing-stairs-solution.html
};
