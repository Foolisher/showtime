from typing import List


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        self.n = 0
        N = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0: continue
                N += 4
                if i > 0 and grid[i - 1][j] == 1:
                    N -= 2
                if j > 0 and grid[i][j - 1] == 1:
                    N -= 2

        return N


print(
    Solution().islandPerimeter(
        [[0, 1, 0, 0],
         [1, 1, 1, 0],
         [0, 1, 0, 0],
         [1, 1, 0, 0]]
    )
)
