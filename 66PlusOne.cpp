//
//  66PlusOne.cpp
//  test
//
//

#include <stdio.h>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        int carry = 1, sum = 0;
        vector<int> result(digits.size(), 0);
        for (int i = digits.size() - 1; i >= 0; i--) {
            sum = carry + digits[i];
            carry = sum / 10;
            result[i] = sum % 10;
        }
        
        if (carry > 0) {
            result.insert(result.begin(), carry);
        }
        return result;
    }
};

//http://fisherlei.blogspot.com/2012/12/leetcode-plus-one.html
