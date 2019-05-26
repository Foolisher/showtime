package leetcode.无重复字符的最长子串;

import java.util.Arrays;

/**
 * Created by fuxiao(付笑) on 2019/5/11.
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
//        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
//        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(new Solution().lengthOfLongestSubstring("tmmzuxt"));
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] m = new int[128];
        int M = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            start = Math.max(m[s.charAt(i)], start);
            M = Math.max(M, i - start + 1);
            m[s.charAt(i)] = i + 1;
        }
        return M;
    }
}
