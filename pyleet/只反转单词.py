class Solution:
    def reverseWords(self, s: str) -> str:
        if not s: return ""
        i, j = 0, 0
        s = [c for c in s]
        while i <= len(s) - 1:
            if s[i] == ' ':
                i += 1
                continue
            for j in range(i, len(s)):
                if s[j] == ' ' or j == len(s) - 1:
                    if s[j] == ' ':
                        j -= 1
                    i1, j1 = i, j

                    while i1 < j1:
                        t = s[i1]
                        s[i1] = s[j1]
                        s[j1] = t
                        i1 += 1
                        j1 -= 1
                    i = j + 1
                    break

        return ''.join(s)


print(Solution().reverseWords("Let's take LeetCode contest"))
