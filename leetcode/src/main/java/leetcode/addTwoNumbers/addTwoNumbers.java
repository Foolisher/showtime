package leetcode.addTwoNumbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.ListNode;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/3/22.
 */
public class addTwoNumbers {

    public static void main(String[] args) {
        System.out.println(
            new Solution().addTwoNumbers(
                ListNode.create("2,4,3"),
                ListNode.create("5,6,4")
            )
        );
    }
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> listA = new LinkedList<>();
        LinkedList<ListNode> listB = new LinkedList<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                listA.add(l1);
                l1 = l1.next;
            }
            if (l2 != null) {
                listB.add(l2);
                l2 = l2.next;
            }
        }
        ListNode head = null, p = null;
        int inc = 0;
        while (listA.size() > 0 || listB.size() > 0) {
            ListNode lastA = null;
            ListNode lastB = null;
            if (listA.size() > 0) {
                lastA = listA.removeLast();
            }
            if (listB.size() > 0) {
                lastB = listB.removeLast();
            }
            if (head == null) {
                head = new ListNode((lastA == null ? 0 : lastA.val) + (lastB == null ? 0 : lastB.val) + inc);
                inc = 0;
                p = head;
                if (p.val >= 10) {
                    inc = p.val / 10;
                    p.val %= 10;
                }
                continue;
            }

            p.next = new ListNode((lastA == null ? 0 : lastA.val) + (lastB == null ? 0 : lastB.val) + inc);
            inc = 0;
            if (p.next.val >= 10) {
                inc = p.next.val / 10;
                p.next.val %= 10;
            }
            p = p.next;

        }

        if (inc > 0) {
            p.next = new ListNode(1);
        }

        return head;

    }
}