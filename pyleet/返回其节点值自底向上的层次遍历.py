# Definition for a binary tree node.
import queue
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self):
        return self.val


class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        rst = []
        q = [root]

        while q:
            n = len(q)
            buf = []
            for i in range(n):
                node = q.pop(0)
                buf.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            rst.insert(0, buf)

        return rst


root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)

print(Solution().levelOrderBottom(
    root
))

a = []
a.append(1)
a.append(2)
print(a)