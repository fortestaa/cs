//
//  16	3Sum Closest.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int> &num, int target) {
        std::sort(num.begin(), num.end());
        int len = num.size();
        int minV = INT_MAX, record;
        for (int i = 0; i < len; i++) {
            int start = i + 1, end = len - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum == target) {
                    minV = 0;
                    record = sum;
                    break;
                }
                if (sum < target) {
                    if (target - sum < minV) {
                        minV = target - sum;
                        record = sum;
                    }
                    start++;
                } else {
                    if (sum - target < minV) {
                        minV = sum - target;
                        record = sum;
                    }
                    end--;
                }
            }
            while (i < len - 1 && num[i] == num[i + 1]) {
                i++;
            }
        }
        return record;
    }
};
//http://fisherlei.blogspot.com/2013/01/leetcode-3sum-closest-solution.html

/*int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
    cout << "begin:" << endl;
    vector<int> a;
    a.push_back(-1);
    a.push_back(2);
    a.push_back(1);
    a.push_back(4);
    cout << s->threeSumClosest(a, 1) << endl;
    return 0;
}*/
