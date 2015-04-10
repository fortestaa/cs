//
//  83RemoveDuplicatesfromSortedList.cpp

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
    ListNode *deleteDuplicates(ListNode *head) {
        if (head == NULL || head->next == NULL) {   //NULL consideration
            return head;
        }
        ListNode *pre = head, *cur = head->next;
        while (cur) {
            if (cur->val == pre->val) {
                pre->next = cur->next;
                cur = cur->next;
            } else {    //order attention!
                pre = cur;
                cur = cur->next;
            }
        }
        return head;
    }
};
//http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-list/

/*int main(int argc, const char * argv[]) {
    // insert code here...
    Solution* s = new Solution();
    ListNode* a1 = new ListNode(1);
    ListNode* a2 = new ListNode(1);
    ListNode* a3 = new ListNode(2);
    a1->next = a2;
    a2->next = a3;
    ListNode* rst = s->deleteDuplicates(a1);
    while (rst) {
        cout << rst->val << '->';
        rst = rst->next;
    }
    cout << endl;
 
    ListNode* b1 = new ListNode(1);
    ListNode* b2 = new ListNode(1);
    ListNode* b3 = new ListNode(2);
    ListNode* b4 = new ListNode(3);
    ListNode* b5 = new ListNode(3);
    b1->next = b2;
    b2->next = b3;
    b3->next = b4;
    b4->next = b5;
    ListNode* rr = s->deleteDuplicates(b1);
    while (rr) {
        cout << rr->val << ' ';
        rr = rr->next;
    }
    cout << endl;
    return 0;
}*/
