package leetcode.findLengthOfLCIS;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/4/20.
 */
public class findLengthOfLCIS {
    public static void main(String[] args) {
        System.out.println(new Solution().findLengthOfLCIS(
//            new int[]{2, 2, 2, 2, 2}
            new int[]{1, 3, 5, 7}
//            new int[]{1, 3, 5, 4, 7}
        ));
    }
}


class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int N = 1;
        int nt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                nt++;
            } else {
                N = nt > N ? nt : N;
                nt = 1;
            }
        }
        N = nt > N ? nt : N;
        return N;
    }
}