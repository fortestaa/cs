//
//  171ExcelSheetColumnNumber.cpp
//

#include <stdio.h>
#include <string>
using namespace std;

class Solution {
public:
    int titleToNumber(string s) {
        int result = 0;
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            tmp = s[i] - 'A' + 1;
            result = result * 26 + tmp;
        }
        return result;
    }
};
//http://blog.csdn.net/chivalrousli/article/details/42364149
