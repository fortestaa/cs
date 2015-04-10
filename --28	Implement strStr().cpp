//
//  28	Implement strStr().cpp
//  test
//

#include <stdio.h>
#include <iostream>
using namespace std;

class Solution {
public:
    int strStr(char *haystack, char *needle) {
        if (haystack == NULL || needle == NULL) {
            return -1;
        }
        int hlen = strlen(haystack);
        int nlen = strlen(needle);
        if (hlen < nlen) {
            return -1;
        }
        for (int i = 0; i < hlen - nlen + 1; i++) {
            int j = 0;
            char* p = &haystack[i];
            for (; j < nlen; j++) {
                if (*p != needle[j]) {
                    break;
                }
                p++;
            }
            if (j == nlen) {
                return i;
            }
        }
        return -1;
    }
};

//http://fisherlei.blogspot.com/2012/12/leetcode-implement-strstr.html

/*int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
    char haystack[7] = "aaaaa1";
    char needle[4] = "aa1";
    cout << s->strStr(haystack, needle) << endl;

    return 0;
}*/
