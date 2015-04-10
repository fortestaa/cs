//
//  151ReverseWordsinaString.cpp
//

#include <stdio.h>
#include <string>
#include <iostream>
using namespace std;

class Solution {
public:
    void reverseWords(string &s) {
        string rs;
        for (int i = s.length() - 1; i >= 0; ) {
            while (i >= 0 && s[i] == ' ') {
                i--;
            }
            if (i < 0) {
                break;
            }
            if (!rs.empty()) {
                rs.push_back(' ');
            }
            string t;
            while (i >= 0 && s[i] != ' ') {
                t.push_back(s[i--]);
            }
            reverse(t.begin(), t.end());
            rs.append(t);
        }
        s = rs;
    }
    //http://blog.csdn.net/kenden23/article/details/20701069
    /*void reverseWords(string &s) {
        if (s.size() <= 0) {
            return;
        }
        
        string result;
        int len = s.size();
        cout << "len" << endl;
        
        int start = len - 1;
        int end = len - 1;
        int index = 0;
        
        while (1) {
            while (s[start] != ' ') {
                start--;
            }
            cout << start << endl;
            if (start < end || start < 0) {
                break;
            }
            for (int i = start; i <= end; i++) {
                result[index] = s[i];
                cout << result[index];
                index++;
            }
            result[index++] = ' ';
            while (s[start] == ' ') {
                start--;
            }
            end = start;
        }
        
        for (int i = 0; i < len; i++) {
            s[i] = result[i];
        }
    }*/
};

/*int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
    string str = "the sky is blue";
    cout << "before: ";
    cout << str << endl;
    s->reverseWords(str);
    cout << "after: ";
    cout << str << endl;
    return 0;
}*/
