package leetcode.链表反转;

import leetcode.ListNode;

/**
 * Created by fuxiao(付笑) on 2019/5/15.
 */
public class 链表反转 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseList(ListNode.create("1,2,3,4,5")));
    }
}

class Solution {
    ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode a = head;
        while (a != null) {
            ListNode b = a.next;
            a.next = pre;
            pre = a;
            a = b;
        }

        return pre;


    }
}