class Solution:
    def myPow(self, x: float, n: int) -> float:
        if x == 0: return 0
        if not n: return 1
        if n < 0:
            x = 1 / x
            n = -n
        P = 1
        while n > 0:
            if n % 2 == 1:
                P *= x
            P *= P
            n >>= 1

        return round(P, 5)


print(Solution().myPow(2.0, 10))
print(Solution().myPow(2.1, 3))
print(Solution().myPow(2, -2))
