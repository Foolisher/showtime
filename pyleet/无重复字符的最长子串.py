class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None: return 0

        l = 0
        dp = {}
        N = 0
        for i in range(len(s)):
            l = max(l, dp.setdefault(s[i], 0))
            N = max(N, i - l + 1)
            dp[s[i]] = i + 1

        return N


print(Solution().lengthOfLongestSubstring("bbbb"))
