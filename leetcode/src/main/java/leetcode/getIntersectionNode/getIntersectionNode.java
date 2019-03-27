package leetcode.getIntersectionNode;

import leetcode.ListNode;

/**
 * Created by fuxiao(¸¶Ğ¦) on 2019/3/20.
 */
public class getIntersectionNode {

    public static void main(String[] args) {

        ListNode head = new Solution().getIntersectionNode(
            ListNode.create("4,1,8,4,5"), ListNode.create("5,0,1,8,4,5"));
        System.out.println(head);
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int i = -1, j = -1;
        ListNode aIndex[] = new ListNode[100];
        ListNode bIndex[] = new ListNode[100];
        ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null) {
            if (a != null) {
                aIndex[++i] = a;
                a = a.next;
            }
            if (b != null) {
                bIndex[++j] = b;
                b = b.next;
            }
        }
        int n = 0;
        while (i >= 0 && j >= 0 && aIndex[i].val == bIndex[j].val) {
            n++;
            i--;
            j--;
        }
        if (n > 0) {
            return aIndex[i + 1];
        }

        return null;
    }
}