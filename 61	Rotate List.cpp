//
//  61	Rotate List.cpp
//  leetcode_medium
//
/*-------------------------------------------------------------------------------
 Given a list, rotate the list to the right by k places, where k is non-negative.
 
 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 -------------------------------------------------------------------------------*/

#include <stdio.h>
#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        if (head == NULL || k <= 0) {
            return head;
        }
        
        int count = 1;
        ListNode *pre = head, *cur;
        
        while (pre->next != NULL) {
            count++;
            pre = pre->next;
        }
        pre->next = head;
        k = k % count;
        int index = 1;
        pre = cur = head;
        while (index <= (count - k)) {
            pre = cur;
            cur = cur->next;
            index++;
        }
        pre->next = NULL;
        head = cur;
        return head;
    }
};

/*class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        if (head == NULL || k == 0)
            return head;
        int len = 1;
        ListNode* p = head;
        while (p->next) { // 求长度
            len++;
            p = p->next;
        }
        k = len - k % len;
        p->next = head; // 首尾相连
        for(int step = 0; step < k; step++) {
            p = p->next; //接着往后跑
        }
        head = p->next; // 新的首节点
        p->next = NULL; // 断开环
        return head;
    }
};
 
 int main() {
    Solution sol;
    
    ListNode *l1, *l2, *l3, *l4, *l5;
    l1 = new ListNode(1);
    l2 = new ListNode(2);
    l3 = new ListNode(3);
    l4 = new ListNode(4);
    l5 = new ListNode(5);
    l1->next = l2;
    l2->next = l3;
    l3->next = l4;
    l4->next = l5;
    l5->next = NULL;
    ListNode* rst = sol.rotateRight(l1, 2);
    cout << rst->val << "->";
    while ((rst = rst->next)) {
        cout << rst->val << "->";
    }
    cout << endl;
    
    ListNode* ll = new ListNode(1);
    //ListNode* rst = sol.rotateRight(ll, 99);
    //cout << rst->val << "->";
    
    ListNode *l1, *l2, *l3;
    l1 = new ListNode(1);
    l2 = new ListNode(2);
    l3 = new ListNode(3);
    l1->next = l2;
    l2->next = l3;
    l3->next = NULL;
    rst = sol.rotateRight(l1, 2000000000);
    cout << rst->val << "->";
    while ((rst = rst->next)) {
        cout << rst->val << "->";
    }
    cout << endl;
    
    return 0;
}*/
//http://blog.csdn.net/sunnyyoona/article/details/18862475
