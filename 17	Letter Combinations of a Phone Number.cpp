//
//  17	Letter Combinations of a Phone Number.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <vector>
#include <string>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> result;
        
        string trans[] = {"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        string seq;
        Generater(trans, digits, 0, seq, result);
        return result;
    }
    
    void Generater(string trans[], string& digits, int deep, string& seq, vector<string>& result) {
        if (deep == digits.size()) {
            result.push_back(seq);
            return;
        }
        int curDig = digits[deep] - '0';
        for (int i = 0; i < trans[curDig].size(); i++) {
            seq.push_back(trans[curDig][i]);
            Generater(trans, digits, deep + 1, seq, result);
            seq.resize(seq.size() - 1);
        }
    }
};
//http://fisherlei.blogspot.com/2012/12/leetcode-letter-combinations-of-phone.html

/*int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
    cout << "begin:" << endl;
    vector<string> rst = s->letterCombinations("23");
    for (int i = 0; i < rst.size(); i++) {
        cout << rst[i] << endl;
    }
    return 0;
}*/
