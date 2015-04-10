//
//  169	Majority Element.cpp
//

#include <stdio.h>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

class Solution {
public:
    int majorityElement(vector<int> &num) {
        int size = num.size();
        if (size == 1) {
            return num[0];
        }
        map<int, int> occurCnt;

        for (int i = 0; i < size; i++) {
            int val = num[i];
            occurCnt[val] += 1;
            if (occurCnt[val] > size / 2)
                return occurCnt[val];
        }
        return 0;
    }
};
