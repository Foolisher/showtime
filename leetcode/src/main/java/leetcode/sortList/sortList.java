package leetcode.sortList;

import leetcode.ListNode;

/**
 * Created by fuxiao(¸¶Ğ¦) on 2019/3/21.
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

        while (head.next != null) {
            ListNode it = head;
            while (it.val > it.next.val) {

            }
        }

        return head;
    }
}