//
//  13RomantoInteger.cpp
//  test
//

#include <stdio.h>
#include <string>
using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        int result = 0;
        
        for (int i = 0; i < s.size(); i++) {
            if (i > 0 && value(s[i]) > value(s[i-1])) {
                result += value(s[i]) - 2 * value(s[i-1]);
            } else {
                result += value(s[i]);
            }
        }
        
        return result;
    }
    
    int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
};

//http://fisherlei.blogspot.com/2012/12/leetcode-roman-to-integer.html

