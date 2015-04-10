//
//  104MaximumDepthofBinaryTree.cpp
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
    int maxDepth(TreeNode *root) {
        if (root == NULL) {
            return 0;
        }
        int l = maxDepth(root->left);
        int r = maxDepth(root->right);
        return l > r ? l + 1 : r + 1;
    }
};
//http://blog.csdn.net/ithomer/article/details/8799795
//more solutions
