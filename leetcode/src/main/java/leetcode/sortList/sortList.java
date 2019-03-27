package leetcode.sortList;

import leetcode.ListNode;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/3/21.
 */
public class sortList {

    public static void main(String[] args) {
        System.out.println(
//            new Solution().sortList(ListNode.create("4,2,1,3"))
            new Solution().sortList(ListNode.create("-1,5,3,4,0"))
        );
    }

}


class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode it = head;
        ListNode head0 = head;

//        while (true) {
//            if (it.next != null && it.next.val < it.val) {
//                ListNode next = it.next;
//            }
//        }

        return head0;
    }
}