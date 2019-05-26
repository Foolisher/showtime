from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices: return 0
        minv, maxv = 1 << 31, 0
        for v in prices:
            maxv = max(maxv, v - minv)
            minv = min(v, minv)
        return maxv


print(Solution().maxProfit([7, 1, 5, 3, 6, 4]))
