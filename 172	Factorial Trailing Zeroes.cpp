//
//  172	Factorial Trailing Zeroes.cpp
//

#include <stdio.h>
#include <iostream>
using namespace std;

/*
 朴素解法：
首先求出n!，然后计算末尾0的个数。（重复÷10，直到余数非0）
该解法在输入的数字稍大时就会导致阶乘得数溢出，不足取。
*/

/*
 O（logn）解法：
 考虑n!的质数因子。
 后缀0总是由质因子2和质因子5相乘得来的。如果我们可以计数2和5的个数，问题就解决了。考虑下面的例子：
 n = 5时 5!的质因子中 (2 * 2 * 2 * 3 * 5)包含一个5和三个2。因而后缀0的个数是1。
 n = 11时 11!的质因子中(2^8 * 3^4 * 5^2 * 7)包含两个5和三个2。于是后缀0的个数就是2。
 我们很容易观察到质因子中2的个数总是大于等于5的个数。因此只要计数5的个数就可以了。那么怎样计算n!的质因子中所有5的个数呢？
 观察15! = 有3个5(来自其中的5, 10, 15)， 所以计算n/5就可以。但是25! = 有6个5(有5个5来自其中的5, 10, 15, 20, 25， 另外还有1个5来自25=(5*5)的另外一个5），所以除了计算n/5， 还要计算n/5/5, n/5/5/5, n/5/5/5/5, …, n/5/5/5,,,/5直到商为0。
*/

class Solution {
public:
    int trailingZeroes(int n) {
        int count_five = 0;
        while (n > 0) {
            int k = n / 5;
            count_five += k;
            n = k;
        }
        return count_five;
    }
};

//http://blog.csdn.net/sunnyyoona/article/details/43610439

/*int main() {
    Solution s;
    cout << "begin:" << endl;
    cout << s.trailingZeroes(10) << endl;
    cout << "succeed!" << endl;
    return 0;
}*/
