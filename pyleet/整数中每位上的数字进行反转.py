class Solution:
    def reverse(self, x: int) -> int:
        rst = []
        if not x: return 0
        s = [i for i in str(x)]
        n = len(s)
        i, j = 0, n - 1
        if s[0] == '-':
            rst.append('-')
            i = 1

        while i < j:
            s[i], s[j] = s[j], s[i]
            i += 1
            j -= 1

        v = 0
        if s[0] == '-':
            v = -int(''.join(s[1:n]))
        else:
            v = int(''.join(s[:n]))
        if v >= -2 ** 31 and v <= (2 ** 31 - 1):
            return v
        else:
            return 0


print(Solution().reverse(120))
print(Solution().reverse(-120000))
