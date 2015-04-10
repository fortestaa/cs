//
//  39	Combination Sum.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        vector<int> path;
        vector<vector<int>> result;
        int size = candidates.size();
        if (size < 0) {
            return result;
        }
        sort(candidates.begin(), candidates.end()); // sort
        DFS(candidates, target, 0, path, result);   // recursive call
        return result;
    }
    
private:
    void DFS(vector<int> &candidates, int target, int start, vector<int> &path, vector<vector<int>> &result) {
        int len = candidates.size();
        if (target == 0) {  // sum target found
            result.push_back(path);
        }
        for (int i = start; i < len; i++) {
            if (target < candidates[i]) {   // prune
                return;
            }
            path.push_back(candidates[i]);
            DFS(candidates, target - candidates[i], i, path, result);
            path.pop_back();
        }
    }
};

//http://blog.csdn.net/sunnyyoona/article/details/43197555

/*int main(){
    Solution solution;
    int target = 7;
    vector<int> vec;
    vec.push_back(2);
    vec.push_back(3);
    vec.push_back(6);
    vec.push_back(7);
    
    vector<vector<int> > result = solution.combinationSum(vec,target);
    // 输出
    for(int i = 0;i < result.size();++i){
        for(int j = 0;j < result[i].size();++j){
            cout<<result[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}*/
