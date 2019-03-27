package leetcode.oddEvenList;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/3/19.
 */
public class oddEvenList {
    public static void main(String[] args) {
        ListNode head = null;
//        String[] split = "1,2,3,4,5".split(",");
        String[] split = "2,1,3,5,6,4,7".split(",");
        for (String s : split) {
            if (head == null) {
                head = new ListNode(Integer.valueOf(s));
            } else {
                ListNode iter = head;
                while (iter.next != null) {
                    iter = iter.next;
                }
                iter.next = new ListNode(Integer.valueOf(s));
            }
        }

        head = new Solution().oddEvenList(head);
        ListNode iter = head;
        while (true) {
            System.out.print(iter.val + " -> ");
            if (iter.next == null) {
                System.out.print("NULL");
                break;
            }
            iter = iter.next;
        }
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode[] deserialize(String[] arr) {
        ListNode[] nodes = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new ListNode(Integer.valueOf(arr[i]));
        }
        return nodes;
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode it = head;
        ListNode head2 = head.next;
        while (true) {
            ListNode next1 = it.next;
            ListNode next2 = next1 != null ? next1.next : null;
            ListNode next3 = next2 != null ? next2.next : null;
            if (next3 == null) {
                it.next = next2;
                if (next1 != null) {
                    next1.next = null;
                }
                break;
            }
            it.next = next2;
            next1.next = next3;
            it = next2;
        }
        while (it.next != null) {
            it = it.next;
        }
        it.next = head2;

        return head;
    }
}