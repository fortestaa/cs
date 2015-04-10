//
//  58LengthofLastWord.cpp
//  test
//

#include <stdio.h>
#include <iostream>
using namespace std;

class Solution {
public:
    int lengthOfLastWord(const char *s) {
        int num = 0;
        int i = strlen(s) - 1;
        
        for (; i >= 0; i--) {
            if (s[i] == ' ') {
                continue;
            }
            break;
        }
        
        for (; i >= 0 ; i--) {
            if (s[i] == ' ') {
                break;
            }
            num++;
        }
        
        return num;
    }
};

/*int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
    char str[12] = "Hello World";
    cout << s->lengthOfLastWord(str) << endl;
    return 0;
}*/

//Finding length of char array:
//http://stackoverflow.com/questions/6150258/finding-length-of-char-array

//Assigning value to char array [duplicate]
//http://stackoverflow.com/questions/14915924/assigning-value-to-char-array
