package leetcode;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/3/20.
 */
public class ListNode {
    public int      val;
    public ListNode next;

    public static ListNode create(String str) {
        ListNode head = null;
        for (String s : str.replace(" ", "").split(",")) {
            if (head == null) {
                head = new ListNode(Integer.parseInt(s));
            } else {
                ListNode tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = new ListNode(Integer.parseInt(s));
            }
        }
        return head;
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }
}