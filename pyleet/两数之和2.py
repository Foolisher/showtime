from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums) < 2: return []
        i, j = 0, len(nums) - 1
        while i < j:
            s = nums[i] + nums[j]
            if s == target: return [i + 1, j + 1]
            if s > target:
                j -= 1
                continue
            if s < target:
                i += 1
                continue

        return []


# print(Solution().twoSum([2, 7, 11, 15], 9))
