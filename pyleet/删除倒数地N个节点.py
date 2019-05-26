# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
from pyleet.common import ListNode, createList


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        if not head: return head
        newHead = ListNode(0)
        newHead.next = head
        p = newHead
        for i in range(n):
            p = p.next
        if not p:
            return head
        pre = newHead
        while p.next:
            pre = pre.next
            p = p.next
        pre.next = pre.next.next

        return newHead.next


h = createList([1,2,3,4,5])
h1 = Solution().removeNthFromEnd(h, 2)
print(h1)

h = createList([1])
h1 = Solution().removeNthFromEnd(h, 1)
print(h1)
