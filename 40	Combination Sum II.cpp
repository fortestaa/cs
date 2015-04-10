//
//  40	Combination Sum II.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

/*
 基本思路是先排好序，然后每次递归中把剩下的元素一一加到结果集合中，并且把目标减去加入的元素，然后把剩下元素（包括当前加入的元素）放到下一层递归中解决子问题。以start记录我们选到了第几个值，并且一直往后选，这样可以避免选到重复的子集。
 这一题和上一题：[LeetCode]39.Combination Sum 差不多一样的思路，只要稍作修改就行。只要在for循环中加一个判断条件即可：
 if(i > start && candidates[i] == candidates[i-1]){
 continue;
 }//if
 这个判断的目的是排除同一层次相同元素的出现。例如：下面例题中有两个1，在第一次递归中不能都出现1，可以的是第一次递归出现1，第二次递归也可以出现一个1
*/
class Solution {
public:
    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
        vector<int> path;
        vector<vector<int>> result;
        int size = num.size();
        if (size <= 0) {
            return result;
        }
        sort(num.begin(), num.end());   // sort
        DFS(num, target, 0, path, result);  // recursive call
        return result;
    }
    
private:
    void DFS(vector<int> &candidates, int target, int start, vector<int> &path, vector<vector<int>> &result) {
        int len = candidates.size();
        if (target == 0) {  // sum = target ---- found
            result.push_back(path);
            return;
        }
        for (int i = start; i < len; ++i) {
            if (i > start && candidates[i] == candidates[i - 1]) {  // no same elements in the same layer
                continue;
            }
            if (target < candidates[i]) {   // prune
                return;
            }
            path.push_back(candidates[i]);
            DFS(candidates, target - candidates[i], i + 1, path, result);
            path.pop_back();
        }
    }
};
//http://blog.csdn.net/sunnyyoona/article/details/43197927

/*int main() {
    Solution sol;
    
    vector<int> vec;
    vec.push_back(10);
    vec.push_back(1);
    vec.push_back(2);
    vec.push_back(7);
    vec.push_back(6);
    vec.push_back(1);
    vec.push_back(5);
    vector<vector<int>> result = sol.combinationSum2(vec, 8);
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << ' ';
        }
        cout << endl;
    }
    
    return 0;
}*/
