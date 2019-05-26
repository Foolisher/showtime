# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from pyleet.common import TreeNode, deserializeTree


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.change(root)

    def change(self, node: TreeNode):
        if not node: return
        if node.right and node.left:
            mostLeftRight = self.findLeftMostLeft(node.left)
            mostLeftRight.right = node.right
            node.right = node.left
            node.left = None
        if not node.right:
            node.right = node.left
            node.left = None
        self.change(node.right)

    def findLeftMostLeft(self, node: TreeNode):
        if node.right:
            return self.findLeftMostLeft(node.right)
        else:
            return node


print(Solution().flatten(deserializeTree('[1,2]')))
print(Solution().flatten(deserializeTree('[1,2,5,3,4,null,6]')))
