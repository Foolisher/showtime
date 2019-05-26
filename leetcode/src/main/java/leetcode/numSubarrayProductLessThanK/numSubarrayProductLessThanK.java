package leetcode.numSubarrayProductLessThanK;

import java.util.Arrays;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/4/19.
 */
public class numSubarrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayProductLessThanK(
            new int[]{10, 5, 2, 6}, 100
        ));
    }
}

/**
 * 2, 5, 6, 10;  100
 */

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int prod = 1;
        int N = 0;
        for (int i = 0; i < nums.length; i++) {
            prod = 1;
            int j = i;
            prod *= nums[i];
        }
        return N;
    }
}
