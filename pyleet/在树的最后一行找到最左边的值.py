# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from pyleet.common import TreeNode, deserializeTree


class Solution:
    def findBottomLeftValue(self, root: TreeNode) -> int:
        if not root:
            return 0
        self.max_left_level = 1
        self.max_left_v = None
        if root and (not root.right and not root.left):
            return root.val
        self.dfs(root, 1, True)
        return self.max_left_v

    def dfs(self, root: TreeNode, level: int, isLeft: bool):
        if not root: return

        if isLeft or not root.left:
            if level > self.max_left_level:
                self.max_left_level = level
                self.max_left_v = root.val

        self.dfs(root.left, level + 1, True)
        self.dfs(root.right, level + 1, False)


print(Solution().findBottomLeftValue(deserializeTree('[1,2,3,4,null,5,6,null,null,7')))
