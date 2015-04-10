//
//  118	Pascal's Triangle.cpp
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        vector<vector<int>> result;
        if (numRows <= 0) {
            return result;
        }
        
        for (int i = 0; i < numRows; i++) {
            vector<int> v;
            
            v.push_back(1);
            if (numRows > 1 && i != 1) {
                for (int j = 1; j < i; j++) {
                    v.push_back(result[i-1][j-1] + result[i-1][j]);
                }
            }
            if (i > 0) {
                v.push_back(1);
            }
            
            result.push_back(v);
        }
        return result;
    }
};

/*int main(int argc, const char * argv[]) {
    // insert code here...
    cout << "--------- begin test ---------" << endl;
    Solution* s = new Solution();
    vector<vector<int>> result ;//= s->generate(5);
    result = s->generate(5);
    
    for (int i = 0; i < result.size(); i++) {
        cout << "[";
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << ",";
        }
        cout << "]";
    }
    cout << endl;
    return 0;
}*/
