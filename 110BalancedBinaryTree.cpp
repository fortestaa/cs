//
//  110BalancedBinaryTree.cpp
//  test
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isBalanced(TreeNode *root) {
        
        if (root == NULL) {
            return true;
        }
        
        int val = getBalance(root);
        if (val == -1) {
            return false;
        }
        return true;
    }
    
    int getBalance(TreeNode* t) {
        if (t == NULL) {
            return 0;
        }
        int left = getBalance(t->left);
        if (left == -1) {
            return -1;
        }
        int right = getBalance(t->right);
        if (right == -1) {
            return -1;
        }
        if (left - right > 1 || right - left > 1) {
            return -1;
        }
        return left > right ? left + 1 : right + 1;
    }
};
//http://fisherlei.blogspot.com/2013/01/leetcode-balanced-binary-tree-solution.html

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
    
    cout << s->isBalanced(root) << endl;
    return 0;
}*/
