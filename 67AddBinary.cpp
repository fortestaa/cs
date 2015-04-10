//
//  67AddBinary.cpp
//  test
//
//  Created by AmyJiang on 15/2/4.
//  Copyright (c) 2015年 AmyJiang. All rights reserved.
//

#include <stdio.h>
#include <string>
#include <iostream>
using namespace std;

class Solution {
public:
    /*string addBinary(string a, string b) {
        string result;
        int maxL = a.size() > b.size() ? a.size() : b.size();
        std::reverse(a.begin(), a.end());
        std::reverse(b.begin(), b.end());
        int carry = 0;
        for (int i = 0; i < maxL; i++) {
            int ai = i < a.size() ? a[i] - '0' : 0;
            int bi = i < b.size() ? b[i] - '0' : 0;
            int val = (ai + bi + carry) % 2;
            carry = (ai + bi + carry) / 2;
            result.insert(result.begin(), val + '0');
        }
        if (carry == 1) {
            result.insert(result.begin(), '1');
        }
        return result;
    }*/
    
    string addBinary(string a, string b) {
        int carry = 0;
        string result;
        for (int i = a.size() - 1, j = b.size() - 1; i >= 0 || j >=0; i--, j--) {
            int ai = i >= 0 ? a[i] - '0' : 0;
            int bj = j >= 0 ? b[j] - '0' : 0;
            //cout << ai << ' ' << bj << endl;
            int val = (ai + bj + carry) % 2;
            carry = (ai + bj + carry) / 2;
            result.insert(result.begin(), val + '0');
        }
        if (carry == 1) {
            result.insert(result.begin(), '1');
        }
        return result;
    }
};

//http://fisherlei.blogspot.com/2013/01/leetcode-add-binary.html
