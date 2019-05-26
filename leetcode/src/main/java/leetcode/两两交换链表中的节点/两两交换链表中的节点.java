package leetcode.两两交换链表中的节点;

import java.util.List;

import leetcode.ListNode;

/**
 * Created by fuxiao(付笑) on 2019/5/15.
 */
public class 两两交换链表中的节点 {

    public static void main(String[] args) {
        System.out.println(new Solution().swapPairs(
            ListNode.create("1,2,3,4,5")
        ));
    }
}

//   1 -> 2 -> 3 -> 4

class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode head1 = null;

        ListNode pre = new ListNode(0);
        pre.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode a = pre.next;
            ListNode b = a.next;

            pre.next = b;
            a.next = b.next;
            b.next = a;
            pre = a;

            if (head1 == null) {
                head1 = b;
            }

        }

        return head1;


    }
}