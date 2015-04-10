//
//  49	Anagrams.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <iostream>
#include <string>
#include <map>
#include <vector>
using namespace std;

class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        vector<string> res;
        if (strs.size() <= 1) {
            return res;
        }
        map<string, int> anagram;
        for (int i = 0; i < strs.size(); i++) {
            string s = strs[i];
            sort(s.begin(), s.end());
            if (anagram.find(s) == anagram.end()) {
                anagram.insert(make_pair(s, i));
            } else {
                if (anagram[s] >= 0) {
                    res.push_back(strs[anagram[s]]);
                    anagram[s] = -1;
                }
                res.push_back(strs[i]);
            }
        }
        return res;
    }
};
//http://www.cnblogs.com/AnnieKim/archive/2013/04/25/3041982.html

/*int main() {
    Solution sol;
    
        
    return 0;
}*/
