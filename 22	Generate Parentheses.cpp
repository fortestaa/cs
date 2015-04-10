//
//  22	Generate Parentheses.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    void CombinationPar(vector<string>& result, string& sample, int n, int leftnum, int rightnum) {
        if (leftnum + rightnum == 2 * n) {
            result.push_back(sample);
            return;
        }
        if (leftnum < n) {
            sample.push_back('(');
            CombinationPar(result, sample, n, leftnum + 1, rightnum);
            sample.resize(sample.size() - 1);
        }
        if (rightnum < leftnum) {
            sample.push_back(')');
            CombinationPar(result, sample, n, leftnum, rightnum + 1);
            sample.resize(sample.size() - 1);
        }
    }
    
    vector<string> generateParenthesis(int n) {
        vector<string> result;
        string sample;
        if (n != 0) {
            CombinationPar(result, sample, n, 0, 0);
        }
        return result;
    }
};
//http://fisherlei.blogspot.com/2012/12/leetcode-generate-parentheses.html

/*int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
    vector<string> rst = s->generateParenthesis(3);
    for (int i = 0; i < rst.size(); i++) {
        cout << rst[i] << endl;
    }
    return 0;
}*/
