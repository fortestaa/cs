//
//  111MinimumDepthofBinaryTree.cpp
//

#include <stdio.h>
#include <iostream>
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
    int minDepth(TreeNode *root) {
        if (root == NULL) {
            return 0;
        }
        
        int depth = 0;
        vector<TreeNode*> sta;
        sta.push_back(root);
        
        if (root == NULL) {
            return 0;
        }
        
        int nextLevCnt = 1;
        int index = 0;
        while (index < sta.size()) {
            depth++;
            int curLevCnt = nextLevCnt;
            nextLevCnt = 0;
            vector<int> level;
            for (int i = index; i < index + curLevCnt; i++) {
                root = sta[i];
                level.push_back(root->val);
                if (root->left == NULL && root->right == NULL) {
                    return depth;
                }
                if (root->left != NULL) {
                    sta.push_back(root->left);
                    nextLevCnt++;
                }
                if (root->right != NULL) {
                    sta.push_back(root->right);
                    nextLevCnt++;
                }
            }
            index += curLevCnt;
        }
        return depth;
    }
    
    /*int minDepth(TreeNode *root) {
        if (root == NULL) {
            return 0;
        }
        int lmin = minDepth(root->left);
        int rmin = minDepth(root->right);
        if (lmin == 0 && rmin == 0) {
            return 1;
        }
        if (lmin == 0) {
            lmin = INT_MAX;
        }
        if (rmin == 0) {
            rmin = INT_MAX;
        }
        return min(lmin, rmin) + 1;
    }*/
};
//http://fisherlei.blogspot.com/2012/12/leetcode-minimum-depth-of-binary-tree.html

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
    
    cout << s->minDepth(root) << endl;
    return 0;
}*/
