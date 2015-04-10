//
//  18	4Sum.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int> > fourSum(vector<int> &num, int target) {
        int n = num.size();
        vector<vector<int>> result;
        sort(num.begin(), num.end());
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                int target2 = target - num[i] - num[j];
                int head = j + 1, tail = n - 1;
                while (head < tail) {
                    int tmp = num[head] + num[tail];
                    if (tmp > target2) {
                        tail--;
                    } else if (tmp < target2) {
                        head++;
                    } else {
                        result.push_back(vector<int>{num[i], num[j], num[head], num[tail]});
                        int k = head + 1;
                        while (k < tail && num[k] == num[head]) {
                            k++;
                        }
                        head = k;
                        
                        k = tail - 1;
                        while (k > head && num[k] == num[tail]) {
                            k--;
                        }
                        tail = k;
                    }
                }
            }
        }
        return result;
    }
};
//http://www.cnblogs.com/tenosdoit/p/3649607.html
//http://tech-wonderland.net/blog/summary-of-ksum-problems.html

/*int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
    cout << "begin:" << endl;
    vector<int> v = vector<int>{1, 0, -1, 0, -2, 2};
    vector<vector<int>> rst = s->fourSum(v, 0);
    for (int i = 0; i < rst.size(); i++) {
        cout << '(';
        for (int j = 0; j < rst[i].size(); j++) {
            cout << rst[i][j] << ',';
        }
        cout << ')' << endl;
    }
    return 0;
}*/
