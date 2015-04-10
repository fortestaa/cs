//
//  9PalindromeNumber.cpp
//  test
//

#include <stdio.h>

#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int num = x;
        int result = 0;
        
        while(num != 0) {
            //if (result * 10 + num % 10 > numeric_limits<int>::max())  //error
            if (result > (INT_MAX - num % 10) / 10)
                return 0;
            result = result * 10 + num % 10;
            num /= 10;
        }
        
        
        if (x == result) {
            return true;
        } else {
            return false;
        }
    }
    
};

//http://fisherlei.blogspot.com/2012/12/leetcode-palindrome-number.html

/*
 int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
     cout << s->isPalindrome(1) << endl;
     cout << s->isPalindrome(31) << endl;
     cout << s->isPalindrome(131) << endl;
     return 0;
 }*/
