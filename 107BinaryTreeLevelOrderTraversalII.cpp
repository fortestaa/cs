//
//  107BinaryTreeLevelOrderTraversalII.cpp
//

#include <stdio.h>
#include <vector>
#include <iostream>
//#include <algorithm>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int> > levelOrderBottom(TreeNode *root) {
        vector<vector<int> > result;
        vector<TreeNode*> sta;
        
        if (root == NULL) {
            return result;
        }
        
        sta.push_back(root);
        
        int index = 0;
        int nextLevelCnt = 1;
        
        while (index < sta.size()) {
            int currLevelCnt = nextLevelCnt;
            nextLevelCnt = 0;
            vector<int> level;
            
            for (int i = index; i < index + currLevelCnt; i++) {
                root = sta[i];
                level.push_back(root->val);
                if (root->left) {
                    sta.push_back(root->left);
                    nextLevelCnt++;
                }
                if (root->right) {
                    sta.push_back(root->right);
                    nextLevelCnt++;
                }
            }
            result.push_back(level);
            index += currLevelCnt;
        }
        
        //std::reverse(result.begin(), result.back());
        vector<vector<int> > rst;
        
        int len = result.size();
        for (int i = 0; i < len; i++) {
            rst.push_back(result[len - i - 1]);
        }
        return rst;
    }
};

/*int main(int argc, const char * argv[]) {
    // insert code here...
    cout << "--------- begin test ---------" << endl;
    Solution* s = new Solution();
    TreeNode* root = new TreeNode(3);
    TreeNode* r1 = new TreeNode(9);
    TreeNode* r2 = new TreeNode(20);
    TreeNode* r3 = new TreeNode(15);
    TreeNode* r4 = new TreeNode(7);
    root->left = r1;
    root->right = r2;
    r2->left = r3;
    r2->right = r4;
    
    vector<vector<int> > result = s->levelOrderBottom(root);
    
    for (int i = 0; i < result.size(); i++) {
        cout << '[';
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << ',';
        }
        cout << ']' << endl;
    }
    cout << endl;
    return 0;
}*/
