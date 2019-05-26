class Solution:
    def convertToTitle(self, n: int) -> str:
        rst = ""
        u = 0
        while n > 0:
            rst = chr(ord('A') + (n - 1) % 26) + rst
            n = int((n-1) / 26)

        return rst


print(Solution().convertToTitle(28))
print(Solution().convertToTitle(701))
