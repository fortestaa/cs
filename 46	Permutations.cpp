//
//  46	Permutations.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;


class Solution {
private:
    void DFS(vector<int> &num, vector<int> &visited, vector<vector<int>> &result) {
        if (num.size() == visited.size()) {
            result.push_back(visited);
            return;
        }
        vector<int>::iterator isVisted;
        for (int i = 0; i < num.size(); i++) {
            isVisted = find(visited.begin(), visited.end(), num[i]);    // check if visited
            if (isVisted == visited.end()) {    // not visited
                visited.push_back(num[i]);
                DFS(num, visited, result);
                visited.pop_back();
            }
        }
    }
    
public:
    vector<vector<int> > permute(vector<int> &num) {
        vector<vector<int>> result;
        if (num.empty()) {
            return result;
        }
        vector<int> visited;
        DFS(num, visited, result);
        return result;
    }
    
    vector<vector<int>>permute2(vector<int> &num) {
        vector<vector<int>> result;
        sort(num.begin(), num.end());   // sort
        // 直接调用STL中的next_permutation
        do {
            result.push_back(num);
        } while (next_permutation(num.begin(), num.end()));
        return result;
    }
    
    // Memory Limit Exceeded
    vector<vector<int>>permute3(vector<int> &num) {
        vector<vector<int>> result;
        sort(num.begin(), num.end());   // sort
        vector<int> tmp = num;
        result.push_back(num);
        nextPermutation(num);
        while (num != tmp) {
            result.push_back(num);
            nextPermutation(num);
        }
        return result;
    }
    
private:
    void nextPermutation(vector<int> &num) {
        int count = num.size();
        if (count == 0 || count == 1) {
            return;
        }
        // From right to left, find first digit which violate the increase, call it partitionNumber
        int index;
        for (index = count - 2; index >= 0; index--) {
            if (num[index + 1] > num[index]) {
                break;
            }
        }
        int tmp;
        if (index != -1) {  // -1 indicate largest
            // From right to left,find first digit which large than partitionNumber
            // call it changeNumber
            for (int i = count - 1; i > index; i--) {
                if (num[index] < num[i]) {
                    tmp = num[index];
                    num[index] = num[i];
                    num[i] = tmp;
                    break;
                }
            }
        }
        // reverse all the digit on the right of partition index  
        for (int i = index + i, j = count - 1; i < j; i++, j--) {
            tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
    }
};

/*int main() {
    Solution sol;
    
    vector<int> num;
    num.push_back(1);
    num.push_back(2);
    num.push_back(3);
    num.push_back(4);
    
    vector<vector<int>> permutes = sol.permute(num);    // re-arrange
    
    for (int i = 0; i < permutes.size(); i++) {
        cout << '[';
        for (int j = 0; j < permutes[i].size(); j++) {
            cout << permutes[i][j];
        }
        cout << ']' << endl;
    }
    
    return 0;
}*/
