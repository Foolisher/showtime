from pyleet.common import ListNode


class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        if head is None: return None;
        h = ListNode(0)
        h.next = head
        pre, curr = h, h.next
        while curr:
            if curr.val is val:
                pre.next = curr.next
                curr = curr.next
            else:
                pre, curr = pre.next, curr.next

        return h.next


a = [ListNode(i) for o, i in enumerate([1, 2, 6, 6, 6, 3, 4, 5, 6,6,6])]

for i, n in enumerate(a):
    if i < len(a) - 1:
        n.next = a[i + 1]

rst = Solution().removeElements(a[0], 6)
print(rst)
