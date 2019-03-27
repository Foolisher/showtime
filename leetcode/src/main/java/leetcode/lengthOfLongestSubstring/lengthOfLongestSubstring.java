package leetcode.lengthOfLongestSubstring;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/3/20.
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("aaaaa"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("eeabcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("abbbbbbbbc"));
        System.out.println(new Solution().lengthOfLongestSubstring("abbbbbbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("aa"));
        System.out.println(new Solution().lengthOfLongestSubstring("cdd"));
        System.out.println(new Solution().lengthOfLongestSubstring("au"));
        System.out.println(new Solution().lengthOfLongestSubstring("tmmzuxt"));
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int N = 1;
        int map[] = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int n = 0;
        int start = 0;
        l1:
        for (int i = 0; i < s.length() && start < s.length(); ) {

            while (i <= s.length() - 1 && i >= start && (i == 0 || map[s.charAt(i)] == -1 || map[s.charAt(i)] < start)) {
                map[s.charAt(i)] = i;
                n++;
                i++;
                N = Math.max(N, n);
            }
            if (i >= s.length() - 1) {
                return N;
            }
            start = map[s.charAt(i)] + 1;
            n = i - start + 1;
            map[s.charAt(i)] = i;

            i++;
        }

        return N;
    }
}