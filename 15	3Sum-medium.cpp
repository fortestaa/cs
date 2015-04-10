//
//  15	3Sum.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        int size = num.size();
        int sum = 0;
        vector<vector<int>> result;
        result.clear();
        sort(num.begin(), num.end());
        
        for (int i = 0; i < size; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int j = i + 1, k = size - 1;
            while (j < k) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    j++;
                    continue;
                }
                if (k < size - 1 && num[k] == num[k + 1]) {
                    k--;
                    continue;
                }
                if (num[i] + num[j] + num[k] < 0) {
                    j++;
                } else if (num[i] + num[j] + num[k] > 0) {
                    k--;
                } else {
                    vector<int> v;
                    v.push_back(num[i]);
                    v.push_back(num[j]);
                    v.push_back(num[k]);
                    result.push_back(v);
                    j++;
                }
            }
        }
        return result;
    }
};
//http://blog.csdn.net/xshalk/article/details/8148422

/*int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
    cout << "begin:" << endl;
    vector<int> a;
    a.push_back(-1);
    a.push_back(0);
    a.push_back(1);
    a.push_back(2);
    a.push_back(-1);
    a.push_back(4);
    vector<vector<int>> rst = s->threeSum(a);
    for (int i = 0; i < rst.size(); i++) {
        cout << "(";
        for (int j = 0; j < rst[i].size(); j++) {
            cout << rst[i][j] << ",";
        }
        cout << ")" << endl;
    }
    return 0;
}*/
