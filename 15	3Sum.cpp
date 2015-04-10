//
//  15	3Sum.cpp
//  test
//

#include <stdio.h>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        int i = 0, j = num.size() - 1;
        vector<vector<int>> result;
        
        if (j < 3) {
            return result;
        }
        
        while (i < j) {
            int tmp = num[i] + num[j];
            int k = tmp / 2;
            if (tmp == 0) {
                //
            }
            while (1) {
                int ts = tmp + num[k];
                if (ts > 0) {
                    if (k > i) {
                        k--;
                    } else {
                        j--;
                        break;
                    }
                } else if (ts < 0) {
                    if (k < j) {
                        k++;
                    } else {
                        i++;
                        break;
                    }
                } else {
                    vector<int> v;
                    v.push_back(i);
                    v.push_back(k);
                    v.push_back(j);
                    result.push_back(v);
                    i++;
                    j--;
                    break;
                }
            }
        }
        return result;
    }
};
