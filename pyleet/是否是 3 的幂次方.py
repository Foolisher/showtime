from math import log


class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0: return False
        while n >= 3:
            n /= 3
        return n == 1


print(Solution().isPowerOfThree(27))
print(Solution().isPowerOfThree(28))

print(log(28, 3))
