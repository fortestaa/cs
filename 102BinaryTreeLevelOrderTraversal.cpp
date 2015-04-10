//
//  102BinaryTreeLevelOrderTraversal.cpp
//

#include <stdio.h>
#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int> > levelOrder(TreeNode *root) {
        vector<vector<int>> result;
        vector<TreeNode*> sta;
        
        if (root == NULL) {
            return result;
        }
        
        sta.push_back(root);
        
        int nextLevCnt = 1;
        int index = 0;
        while (index < sta.size()) {
            int curLevCnt = nextLevCnt;
            nextLevCnt = 0;
            vector<int> level;
            for (int i = index; i < index + curLevCnt; i++) {
                root = sta[i];
                level.push_back(root->val);
                if (root->left != NULL) {
                    sta.push_back(root->left);
                    nextLevCnt++;
                }
                if (root->right != NULL) {
                    sta.push_back(root->right);
                    nextLevCnt++;
                }
            }
            result.push_back(level);
            index += curLevCnt;
        }
        return result;
    }
};
//http://fisherlei.blogspot.com/2013/01/leetcode-binary-tree-level-order.html

/*
 int main(int argc, const char * argv[]) {
    // insert code here...
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
    
    vector<vector<int> > result = s->levelOrder(root);
    
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
