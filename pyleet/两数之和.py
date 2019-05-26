from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        if numbers is None: return []
        map = {}
        for i, v in enumerate(numbers):
            if v not in map:
                map[v] = i + 1
            if target - v in map and map[target - v] is not i:
                return [map[target - v], map[v]]

        return []


r = Solution().twoSum([2, 3, 4], 6)
print(r)
