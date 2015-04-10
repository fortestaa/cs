//
//  8StringtoInteger.cpp
//  test
//

#include <stdio.h>

#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    int atoi(const char *str) {
        //assert(str != NULL);
        if (str == NULL) {
            return 0;
        }
        
        while (isspace(*str)) {
            str++;  //remove ''
        }
        
        int sign = (*str == '-') ? -1 : 1;
        
        if (*str == '-' || *str == '+') {   //if can check one char
            str++;
        }
        
        int ret = 0;
        while (isdigit(*str)) {
            int digit = *str - '0';
            
            if (INT_MAX / 10 >= ret)
                ret *= 10;
            else
                return sign == -1 ? INT_MIN : INT_MAX;
            
            if (INT_MAX - digit >= ret)
                ret += digit;
            else
                return sign == -1 ? INT_MIN : INT_MAX;
            str++;
        }
        return ret * sign;
    }
};

/*
int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
    cout << s->atoi("Hello, World!\n") << endl;
    cout << s->atoi("-11") << endl;
    return 0;
}*/
