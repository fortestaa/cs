//
//  31	Next Permutation.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    void nextPermutation(vector<int> &num) {
        int count = num.size();
        if (count == 0 || count == 1) {
            return;
        }
        
        // From right to left, find first digit which violate the increase
        // call it partitionNumber
        int index;
        for (index = count - 2; index >= 0; index--) {
            if (num[index + 1] > num[index]) {
                break;
            }
        }
        int tmp;
        if (index != -1) {  // -1 indicates largest
            // From right to left, find first digit which larger than partitionNumber
            // call it changeNumber
            for (int i = count - 1; i > index; i--) {
                if (num[index] < num[i]) {
                    //swap the partition index and changeNumber
                    tmp = num[index];
                    num[index] = num[i];
                    num[i] = tmp;
                    break;
                }
            }
        }
        
        // reverse all the digit on the right of partition index
        for (int i = index + 1, j = count - 1; i < j; i++, j--) {
            tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
    }
};

//http://blog.csdn.net/m6830098/article/details/17291259
//http://blog.csdn.net/sunnyyoona/article/details/42775329

/*int main() {
    Solution solution;
    vector<int> num;
    num.push_back(1);
    num.push_back(1);
    num.push_back(5);
    // re-arrange
    solution.nextPermutation(num);
    for (int i = 0; i < num.size(); i++) {
        cout << num[i] << ' ';
    }
    cout << endl;
    return 0;
}*/
