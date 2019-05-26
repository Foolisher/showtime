from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return
        l = len(nums)
        i1 = -1
        i = 0
        while i < l:
            if nums[i] != 0:
                i1 += 1
                nums[i1], nums[i] = nums[i], nums[i1]
            i += 1

        return nums


print(Solution().moveZeroes([0, 1, 0, 3, 12]))
