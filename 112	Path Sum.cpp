//
//  112	Path Sum.cpp
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
    bool hasPathSum(TreeNode *root, int sum) {
        if (root == NULL) {
            return false;
        }
        
        if (root->left == NULL && root->right ==NULL && root->val == sum) {
            //cout << "true";
            return true;
        }
        
        if (root->left) {
            //cout << "left" << sum - root->val << endl;
            if (hasPathSum(root->left, sum - root->val))
                return true;
        }
        if (root->right) {
            //cout << "right" << sum - root->val << endl;
            if (hasPathSum(root->right, sum - root->val))
                return true;
        }
        //cout << "false" << endl;
        return false;
    }
};

//以上是自己做的
//更简单直接的实现方法
//http://blog.csdn.net/linhuanmars/article/details/23654413
//http://fisherlei.blogspot.com/2013/03/leetcode-path-sum-solution.html

/*int main(int argc, const char * argv[]) {
    // insert code here...
    cout << "--------- begin test ---------" << endl;
    Solution* s = new Solution();
    TreeNode* root = new TreeNode(5);
    TreeNode* r1 = new TreeNode(4);
    TreeNode* r2 = new TreeNode(8);
    TreeNode* r3 = new TreeNode(11);
    TreeNode* r4 = new TreeNode(13);
    TreeNode* r5 = new TreeNode(4);
    TreeNode* r6 = new TreeNode(7);
    TreeNode* r7 = new TreeNode(2);
    TreeNode* r8 = new TreeNode(1);
    root->left = r1;
    root->right = r2;
    r1->left = r3;
    r2->left = r4;
    r2->right = r5;
    r3->left = r6;
    r3->right = r7;
    r5->right = r8;
    
    cout << s->hasPathSum(root, 22) << endl;
    root = NULL;
    cout << s->hasPathSum(root, 22) << endl;
    return 0;
}*/
