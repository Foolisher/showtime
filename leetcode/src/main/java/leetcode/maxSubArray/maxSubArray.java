package leetcode.maxSubArray;

/**
 * Created by fuxiao(付笑) on 2019/4/22.
 */
public class maxSubArray {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(
            new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}
        ));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int M = nums[0];
        int M1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 思路和原理：
            // 如果 preMax >0 ，说明前面一直在递增，可以加上前面的值
            if (M1 > 0) {
                M1 += nums[i];
            } else {  // 反之，说明前面的值没有增加（或者在减少），那么舍去前面的累计
                M1 = nums[i];
            }
            M = Math.max(M, M1);
        }
        return M;
    }
}
