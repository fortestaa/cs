//
//  98	Validate Binary Search Tree.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <iostream>
#include <climits>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isValidBST(TreeNode *root) {
        if (root == NULL) {
            return true;
        }
        return isValidBST(root, INT_MIN, INT_MAX, false, false);
    }
    
private:
    bool isValidBST(TreeNode* node, long min, long max, bool validMin, bool validMax) {
        if (node == NULL) {
            return true;
        }
        
        // min max第一次不要使用
        // 根节点大于左子树所有节点 小于右子树所有节点
        if ((validMax && node->val >= max) || (validMin && node->val <= min)) {
            return false;
        }
        
        bool left = isValidBST(node->left, min, node->val, validMin, true);
        bool right = isValidBST(node->right, node->val, max, true, validMax);
        return left && right;
    }
};

int CreateBTree(TreeNode*& T) {
    int data;
    cin >> data;
    if (data == -1) {
        T = NULL;
    } else {
        T = new TreeNode(data);
        CreateBTree(T->left);
        CreateBTree(T->right);
    }
    return 0;
}

/*int main() {
    Solution sol;
    
    TreeNode* root = NULL;
    CreateBTree(root);
    cout << sol.isValidBST(root) << endl;
    
    return 0;
}*/
//http://blog.csdn.net/sunnyyoona/article/details/42194499
