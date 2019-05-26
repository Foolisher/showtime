# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
from pyleet.common import ListNode, createList


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head: return head
        newHead = ListNode(0)
        newHead.next = head
        pre = newHead
        while pre.next and pre.next.next:
            curr = pre.next
            nextTmp = curr.next.next
            pre.next = curr.next
            curr.next.next = curr
            curr.next = nextTmp
            pre = curr
        return newHead.next


h = Solution().swapPairs(createList([1, 2, 3, 4]))
print(h)
