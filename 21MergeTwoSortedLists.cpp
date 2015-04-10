//
//  21MergeTwoSortedLists.cpp
//  test
//

#include <stdio.h>
#include <climits>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

/*
25 / 208 test cases passed.
class Solution {
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        if (l1 == NULL)
            return l2;
        if (l2 == NULL)
            return l1;
        ListNode *head = new ListNode(-1);
        ListNode *p = head;
        while (l1 != NULL && l2 != NULL) {
            if (l1->val < l2->val) {
                p->next = l1;
                l1 = l1->next;
            } else {
                p->next = l2;
                l2 = l2->next;
            }
        }
        if (l1 != NULL) {
            p->next = l1;
        }
        if (l2 != NULL) {
            p->next = l2;
        }
        p = head->next;
        delete head;
        return p;
    }
};*/

class Solution {
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        ListNode* head = new ListNode(-1);
        ListNode* p = head;
        while (l1 != NULL || l2 != NULL) {
            int val1 = l1 == NULL ? INT_MAX : l1->val;
            int val2 = l2 == NULL ? INT_MAX : l2->val;
            if (val1 <= val2) {
                p->next = l1;
                l1 = l1->next;
            } else {
                p->next = l2;
                l2 = l2->next;
            }
            p = p->next;
        }
        p = head->next;
        delete head;
        return p;
    }
};

//http://fisherlei.blogspot.com/2013/03/leetcode-merge-two-sorted-lists-solution.html
