//
//  38	Count and Say.cpp
//

#include <stdio.h>
#include <string>
#include <iostream>
using namespace std;

class Solution {
public:
    string countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        string str("1");
        for (int i = 1; i < n; ++i) {
            NextCountAndSay(str);
        }
        return str;
    }
    
private:
    void NextCountAndSay(string & str) {
        int len = str.length();
        string tmp = "";
        for (int i = 0; i < len; i++) {
            int repeatCount = 1;
            // repeat char count
            while ((i + 1 < len) && (str[i] == str[i + 1])) {
                ++repeatCount;
                ++i;
            }
            tmp += to_string(repeatCount);
            tmp += str[i];
        }
        str = tmp;
    }
};
//http://blog.csdn.net/sunnyyoona/article/details/43192847

int main() {
    Solution sol;
    cout << sol.countAndSay(5) << endl;
    return 0;
}
