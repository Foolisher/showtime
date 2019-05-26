from typing import List


# class Solution:
#     def removeDuplicates(self, nums: List[int]) -> int:
#         if not nums: return 0
#         l = len(nums)
#         if l <= 3:
#             return l
#         index = 2
#         for i in range(2, l):
#             if nums[i] != nums[index - 2]:
#                 nums[index] = nums[i]
#                 index += 1
#
#         if index == l - 1:
#             return l - 1
#         else:
#             return index - 1


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        l = len(nums)
        if l <= 2:
            return l
        


print(Solution().removeDuplicates([1, 1, 1, 2, 2, 3]))
