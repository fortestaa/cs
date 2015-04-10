//
//  43	Multiply Strings.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <iostream>
#include <cstring>
using namespace std;

class Solution {
public:
    string multiply(string num1, string num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        
        if (len1 <= 0 || len2 <= 0) {
            return "";
        }
        
        int sum = 0;
        int len3 = len1 + len2;
        char result[len3];
        
        memset(result, '0', sizeof(result[0]) * (len3 + 1));
        for (int i = len1 - 1, m = 0; i >= 0; --i, ++m) {
            for (int j = len2 - 1, n = 0; j >= 0; --j, ++n) {
                sum = (num1[i] - '0') * (num2[j] - '0') + result[m + n] - '0';
                result[m + n] = sum % 10 + '0';
                result[m + n + 1] += sum / 10;
            }
        }
        
        while (result[len3] == '0' && len3 > 0) {
            --len3;
        }
        result[len3 + 1] = '\0';
        int temp;
        for (int i = 0, j = len3; i < j; ++i, --j) {
            temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }
        return string(result);
    }
};
//http://blog.csdn.net/sunnyyoona/article/details/43228569

/*int main() {
    Solution sol;
    string num1("0");
    string num2("123");
    cout << sol.multiply(num1, num2) << endl;
    return 0;
}*/
