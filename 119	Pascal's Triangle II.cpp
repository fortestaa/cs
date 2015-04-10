//
//  119	Pascal's Triangle II.cpp
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> result;
        result.resize(rowIndex + 2);
        for (int i = 0; i < rowIndex + 2; i++) {
            result[i] = 0;
        }
        result[1] = 1;
        for (int i = 0; i < rowIndex; i++) {
            for (int j = rowIndex + 1; j > 0; j--) {
                result[j] = result[j - 1] + result[j];
            }
        }
        result.erase(result.begin());
        return result;
    }
};
//http://fisherlei.blogspot.com/2012/12/leetcode-pascals-triangle-ii.html

/*int main(int argc, const char * argv[]) {
    // insert code here...
    cout << "--------- begin test ---------" << endl;
    Solution* s = new Solution();
    vector<int> result ;//= s->generate(5);
    result = s->getRow(4);
    
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << ",";
    }
    cout << endl;
    return 0;
}*/
