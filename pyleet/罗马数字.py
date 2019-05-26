class Solution:
    def romanToInt(self, s: str) -> int:
        if not s: return 0
        ch_map = [1000, 900, 500, 400,  100, 90,   50,  40,   10,  9,    5,   4,    1]
        nm_map = ['M', 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I']
        v = 0
        i, l = 0, len(s)
        while i<=l-1:
            if i<l-1 and s[i]+s[i+1] in nm_map:
                v += ch_map[nm_map.index(s[i]+s[i+1])]
                i+=2
            else:
                v += ch_map[nm_map.index(s[i])]
                i+=1

        return v


print(Solution().romanToInt('III'))
print(Solution().romanToInt('MCMXCIV'))
print(Solution().romanToInt('IV'))
print(Solution().romanToInt('LVIII'))
