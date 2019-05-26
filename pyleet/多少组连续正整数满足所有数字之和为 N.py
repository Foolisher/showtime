class Solution:
    def consecutiveNumbersSum(self, N: int) -> int:
        rst = 0

        for n in range(1, int(N / 2 + 2)):
            if N < (n * (n - 1)) / 2:
                break
            t = N - (n * (n - 1) / 2)
            if t % n != 0:
                continue
            if t / n > 0:
                rst += 1

        return rst


print(Solution().consecutiveNumbersSum(5))
print(Solution().consecutiveNumbersSum(9))
print(Solution().consecutiveNumbersSum(15))

print(4 * 2 + (4 * (4 - 1)) / 2)
