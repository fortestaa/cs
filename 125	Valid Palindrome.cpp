//
//  125	Valid Palindrome.cpp
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {
        if (s.size() == 0) {
            return true;
        }
        
        int start = 0;
        int end = s.size() - 1;
        std::transform(s.begin(), s.end(), s.begin(), ::tolower);
        //cout << s;
        
        while (start < end) {
            while (start < end && !isalphanum(s[start])) {
                start++;
            }
            while (start < end && !isalphanum(s[end])) {
                end--;
            }
            if (s[start] != s[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
    
    bool isalphanum(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (isdigit(c)) {
            return true;
        }
        return false;
    }
};
//http://fisherlei.blogspot.com/2013/02/leetcode-valid-palindrome-solution.html
//http://blog.csdn.net/linhuanmars/article/details/22775045

/*int main(int argc, const char * argv[]) {
    // insert code here...
    cout << "--------- begin test ---------" << endl;
    Solution* s = new Solution();
    
    cout << s->isPalindrome("1a2") << endl;
    return 0;
}*/
