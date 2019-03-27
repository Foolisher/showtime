package leetcode.findDuplicate;

import com.google.gson.Gson;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/3/14.
 */
public class findDuplicate {
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new Gson().fromJson(
            "[1,3,4,2,2]",
            int[].class
        )));
    }
}


class Solution {
    public int findDuplicate(int[] nums) {
        int map[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]]++;
            if (map[nums[i]] >= 2) {
                return nums[i];
            }
        }
        return 0;
    }
}