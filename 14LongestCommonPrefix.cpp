//
//  14LongestCommonPrefix.cpp
//  test
//

#include <stdio.h>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        string prefix;
        
        if (strs.size() == 0) {
            return prefix;
        }
        
        int k = 0;
        while (1) {
            if (k == strs[0].size())
                break;
            
            char p = strs[0][k];
            int i = 1;
            for (; i < strs.size(); i++) {
                if (k == strs[i].size()) {
                    break;
                }
                if (p != strs[i][k]) {
                    break;
                }
            }
            
            if (i != strs.size())
                break;
            prefix.append(1, p);
            k++;
        }
        
        return prefix;
    }
};
//http://fisherlei.blogspot.com/2012/12/leetcode-longest-common-prefix.html
/*
int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
    string arr[4] = {"aaaa","aaii","aabb","acc"};
    vector<string> v(arr, arr + 4);
    cout << s->longestCommonPrefix(v) << endl;
    
    string a[3] = {"aaa","aa","aaa"};
    vector<string> v3(a, a + 3);
    cout << s->longestCommonPrefix(v3) << endl;
    
    string ar[1] = {"a"};
    vector<string> vv(ar, ar + 1);
    cout << s->longestCommonPrefix(vv) << endl;
    return 0;
}*/
