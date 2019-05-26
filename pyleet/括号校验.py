class Solution:
    def isValid(self, s: str) -> bool:
        l = {
            '(': ')',
            '[': ']',
            '{': '}'
        }
        if not s: return True
        s = [c for c in s]
        stack = []
        for i in range(len(s)):
           if s[i] in l.keys():
               stack.append(s[i])
           else:
               if not stack:
                   return False
               c = stack.pop()
               if s[i] != l[c]:
                   return False

        return not stack


print(Solution().isValid('([)]'))
print(Solution().isValid('[)'))
print(Solution().isValid(']'))
print(Solution().isValid('()'))