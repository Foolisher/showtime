class Solution:
    def reverseWords(self, s: str) -> str:
        i, j, n = 0, len(s) - 1, len(s)

        s1 = s.split('')

        while i < j:
            t = s[i]
            s[i] = s[j]
            s[j] = t
            i += 1
            j -= 1

        i, j = 0, 0
        while i < len(s):
            while j + 1 < n and s[j + 1] != ' ':
                j += 1

            j1 = j
            while i < j:
                t = s[i]
                s[i] = s[j]
                s[j] = t
                i += 1
                j -= 1

            while j1 + 1 < n and s[j1 + 1] == ' ':
                j1 += 1
            i, j = j1, j1


print(Solution().reverseWords("the sky is blue"))
