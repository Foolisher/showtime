class Solution:
    def maximumSwap(self, num: int) -> int:
        s = str(num)
        s = [i for i in s]
        n = len(s)
        ss = sorted(s)

        for i, v in enumerate(s):
            if s[i] != ss[n - 1 - i]:
                t, s[i] = s[i], ss[n - i - 1]
                for i1 in (range(i + 1, n + 1)):
                    if s[i1] == ss[n-i-1]:
                        s[i1] = t
                        break
                break

        return int(''.join(s))


print(Solution().maximumSwap(2736))
print(Solution().maximumSwap(9973))
print(Solution().maximumSwap(11000012))
print(Solution().maximumSwap(123))
print(Solution().maximumSwap(98368))
