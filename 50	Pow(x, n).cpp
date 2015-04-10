//
//  50	Pow(x, n).cpp
//  leetcode_medium
//

#include <stdio.h>
#include <iostream>
using namespace std;

/*
 x^n = x^(n/2) * x^(n/2) *x^(n%2)
 对于n是奇数时，x^n = x^（n/2）*  x^（n/2）* x
 对于n是偶数时，x^n = x^（n/2）*  x^（n/2）
 */
class Solution {
public:
    double pow(double x, int n) {
        if (n < 0) {    // negative
            return 1.0 / pows(x, -n);
        } else {    // positive
            return pows(x, n);
        }
    }
    
private:
    double pows(double x, int n) {
        // end condition
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        
        // recursive call
        double sub = pow(x, n / 2);
        return sub * sub * pow(x, n % 2);
    }
};

/*int main() {
    Solution sol;
    
    cout << sol.pow(2.5, 2) << endl;
    
    return 0;
}*/
//http://blog.csdn.net/sunnyyoona/article/details/43273933
