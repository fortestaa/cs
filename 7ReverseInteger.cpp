//
//  7ReverseInteger.cpp
//  test
//
//

#include <stdio.h>
#include <iostream>
#include <string>
#include <cmath>
using namespace std;

class Solution {
public:
    //注意数组越界问题
    /*一般来说整数的处理问题要注意的有两点，一点是符号，另一点是整数越界问题http://blog.csdn.net/linhuanmars/article/details/20024837*/
    int reverse(int x) {
        if (x <= numeric_limits<int>::min())
            return 0;
        int num = abs(x);
        int result = 0;
        
        while(num != 0) {
            //if (result * 10 + num % 10 > numeric_limits<int>::max())  //error
            if (result > (numeric_limits<int>::max() - num % 10) / 10)
                return 0;
            result = result * 10 + num % 10;
            num /= 10;
        }
        return x > 0 ? result : -result;
    }
    
    //不可行，无法确定数组越界
    /*
    int reverse(int x) {
        int result;
        if (x > 0) {
            result = reversep(x);
        } else {
            result = reversep(-x);
            result = -result;
        }
        return result;
    }
    
    int reversep(int x) {
        if (x >= numeric_limits<int>::max()) {
            return 0;
        }
        string xx = to_string(x);
        string str;
        for (int i = 0; i < xx.size(); i++) {
            str.append(1, xx[xx.size() - i - 1]);
        }
        
        //return stoi(str);
        return atoi(str.c_str());
    }*/
};
