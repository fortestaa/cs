//
//  19RemoveNthNodeFromEndofList.cpp
//  test
//

#include <stdio.h>
using namespace std;
//need consideration
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        //assert(head);
        ListNode* pre, *cur;
        pre = head;
        cur = head;
        int step = 0;
        while (step < n && cur != NULL) {
            cur = cur->next;
            step++;
        }
        if (step == n && cur == NULL) {
            head = head->next;
            delete pre;
            return head;
        }
        while (cur->next != NULL) {
            pre = pre->next;
            cur = cur->next;
        }
        ListNode* tmp = pre->next;
        pre->next = tmp->next;
        delete tmp;
        return head;
    }
};
//http://fisherlei.blogspot.com/2012/12/leetcode-remove-nth-node-from-end-of.html

/*class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        if (n == 1) {
            return head->next;
        }
        
        ListNode* ln = head;
        for (int i = 1; i <= n - 1; i++) {
            ln = ln->next;
        }
        ln->next = ln->next->next;
        return head;
    }
};*/
