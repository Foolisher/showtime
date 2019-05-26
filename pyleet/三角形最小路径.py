from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        for m in reversed(range(len(triangle) - 1)):
            for j in range(len(triangle[m])):
                triangle[m][j] += min(triangle[m + 1][j], triangle[m + 1][j + 1])
        return triangle[0][0]


rst = Solution().minimumTotal(
    [
        [2],
        [3, 4],
        [6, 5, 7],
        [4, 1, 8, 3]
    ]
)

print(rst)
