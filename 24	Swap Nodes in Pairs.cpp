//
//  24	Swap Nodes in Pairs.cpp
//  leetcode_medium
//

#include <stdio.h>
#include <vector>
#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *swapPairs(ListNode *head) {
        /*
         //method 1
        if (head == NULL) {
            return NULL;
        }
        
        if (head->next == NULL) {
            return head;
        }
        
        ListNode* tmp = new ListNode(-1);
        tmp->next = head;
        ListNode* pre = head->next;
        ListNode* cur = head;
        ListNode* post = tmp;
        
        while (pre != NULL) {
            ListNode* temp = pre->next;
            pre->next = cur;
            cur->next = temp;
            post->next = pre;
            post = cur;
            if (post->next == NULL) {
                break;
            }
            cur = post->next;
            pre = cur->next;
        }
        head = tmp->next;
        delete tmp;
        return head;
         */
        
        /*method2*/
        if (head == NULL || head->next == NULL) {
            return head;
        }
        ListNode* nextPair = head->next->next;
        ListNode* newHead = head->next;
        head->next->next = head;
        head->next = swapPairs(nextPair);
        return newHead;
    }
};
//http://fisherlei.blogspot.com/2013/01/leetcode-swap-nodes-in-pairs.html
