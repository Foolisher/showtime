# Definition for a binary tree node.
from pyleet.common import TreeNode


class Solution:
    def longestUnivaluePath(self, root: TreeNode) -> int:
        self.max = 0
        if not root: return 0
        self.dfs(root)
        return self.max

    def dfs(self, root: TreeNode) -> int:
        if not root: return 0

        l, r = 0, 0
        if root.left and root.left.val == root.val:
            l = self.dfs(root.left) + 1

        if root.right and root.right.val == root.val:
            r = self.dfs(root.right) + 1

        if l == 0 and r == 0:
            self.max = max(self.max, max(self.dfs(root.left), self.dfs(root.left)))
            return 0
        else:
            self.max = max(self.max, l + r)

            return l + r


a = Solution().longestUnivaluePath(TreeNode(0).init([5, 4, 5, 1, 1, 5]))
a = Solution().longestUnivaluePath(TreeNode(0).init([5, 4, 5, 1, 1, 5]))
print(a)
