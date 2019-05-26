from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums: return
        l = len(nums)
        i0, i1, i2 = -1, 0, l
        while i1 < i2:
            if nums[i1]==1:
                i1+=1
            elif nums[i1]==2:
                i2 -= 1
                nums[i2], nums[i1] = nums[i1], nums[i2]
            elif nums[i1]==0:
                i0 += 1
                nums[i0], nums[i1] = nums[i0], nums[i1]
                i1 += 1


        return nums


print(Solution().sortColors([0]))
print(Solution().sortColors([2, 0, 2, 1, 1, 0]))
