from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        if not nums: return []
        rst = []
        n = len(nums)
        nums.sort()
        l, i, j, r = 0, 1, n - 2, n - 1
        while r - l + 1 >= 4:
            i, j = l + 1, r - 1
            while i < j:
                sum = nums[l] + nums[i] + nums[j] + nums[r]
                if sum == target:
                    rst.append([nums[l], nums[i], nums[j], nums[r]])
                if sum < target:
                    i += 1
                else:
                    j -= 1

            if nums[l] + nums[r] > 0:
                r -= 1
            elif nums[l] + nums[r] < 0:
                l += 1
            else:
                r -= 1
                l += 1
        return rst


print(Solution().fourSum(
    [1, 0, -1, 0, -2, 2], 0
))
# -2 -1 0 0 1 2
