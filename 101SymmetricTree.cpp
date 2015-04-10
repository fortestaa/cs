//
//  101SymmetricTree.cpp
//

#include <stdio.h>
#include <vector>
#include <stack>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
/* 1st, recursive
class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        if (root == NULL) {
            return true;
        }
        return isSym(root->left, root->right);
    }
    
    bool isSym(TreeNode *left, TreeNode *right) {
        if (left == NULL) {
            return right == NULL;
        }
        if (right == NULL) {
            return left == NULL;
        }
        if (left->val != right->val) {
            return false;
        }
        if (!isSym(left->left, right->right)) {
            return false;
        }
        if (!isSym(left->right, right->left)) {
            return false;
        }
        return true;
    }
};
//http://fisherlei.blogspot.com/2013/01/leetcode-symmetric-tree.html
*/

class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        if (root == NULL) {
            return true;
        }
        vector<TreeNode*> visitQueue;
        visitQueue.push_back(root);
        int curLevel = 1;
        
        while (curLevel > 0) {
            int i = 0;
            while (i < curLevel) {
                TreeNode* p = visitQueue[i];
                i++;
                if (p == NULL) {
                    continue;
                }
                visitQueue.push_back(p->left);
                visitQueue.push_back(p->right);
            }
            
            int start = 0, end = curLevel - 1;
            while (start < end) {
                TreeNode* pl = visitQueue[start];
                TreeNode* pr = visitQueue[end];
                int l = pl == NULL ? -1 : pl->val;
                int r = pr == NULL ? -1 : pr->val;
                if (l != r) {
                    return false;
                }
                start++;
                end--;
            }
            visitQueue.erase(visitQueue.begin(), visitQueue.begin() + curLevel);
            curLevel = visitQueue.size();
        }
        return true;
    }
};
//vector::erase Removes from the vector either a single element (position) or a range of elements ([first,last))
//http://www.cplusplus.com/reference/vector/vector/erase/
//http://fisherlei.blogspot.com/2013/01/leetcode-symmetric-tree.html

/*
class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        if (!root || !root->left && !root->right) {
            return true;
        }
        TreeNode* t1 = root->left, *t2 = root->right;
        if (t1 && !t2 || !t1 && t2 || t1->val != t2->val) {
            return false;
        }
        
        stack<TreeNode*> s1, s2;
        s1.push(t1), s2.push(t2);
        bool flag = false;
        while (!s1.empty() && !s2.empty()) {
            if (!flag && (t1->left || t2->right)) {
                s1.push(t1), s2.push(t2);
                if (t1 && !t2 || !t1 && t2 || t1->val != t2->val) {
                    return false;
                }
                s1.push(t1), s2.push(t2);
            } else if (t1->right || t2->left) {
                t1 = t1->right, t2 = t2->left;
                if (t1 && !t2 || !t1 && t2 || t1->val != t2->val) {
                    return false;
                }
                flag = false;
            } else {
                t1 = s1.top(), t2 = s2.top();
                s1.pop(), s2.pop();
                flag = true;
            }
        }
        return s1.empty() && s2.empty();
    }
};
//Memory Limit Exceeded
//使用先序遍历
//http://blog.csdn.net/kenden23/article/details/19249357
*/

//http://blog.csdn.net/disappearedgod/article/details/24153001
