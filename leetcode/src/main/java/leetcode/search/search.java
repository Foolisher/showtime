package leetcode.search;

/**
 * Created by fuxiao(¸¶Ğ¦) on 2019/3/26.
 */
public class search {
    public static void main(String[] args) {
        System.out.println(new Solution().search(
//            new int[]{4, 5, 6, 7, 0, 1, 2}, 0
//            new int[]{0, 1, 2, 4, 5, 6, 7}, -1
            new int[]{5, 1, 3}, 1
        ));
    }
}


class Solution {
    public int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        if (nums[0] > nums[nums.length - 1]) {

            if (target < nums[0] && target > nums[nums.length - 1]) {
                return -1;
            }

            if (nums[0] == target) {
                return 0;
            }
            if (nums[nums.length - 1] == target) {
                return nums.length - 1;
            }

            int i = 0, j = nums.length - 1;
            int t = -1;
            while (i < j && i + 1 < nums.length && j > 0) {
                if (nums[i] > nums[i + 1]) {
                    t = i;
                    break;
                }
                if (nums[j] < nums[j - 1]) {
                    t = j - 1;
                    break;
                }
                i++;
                j--;
            }

            if (t >= 0) {
                int i1 = bSearch(nums, 0, t, target);
                if (i1 >= 0) {
                    return i1;
                } else {
                    return bSearch(nums, t + 1, nums.length - 1, target);
                }
            }


        } else {
            return bSearch(nums, 0, nums.length - 1, target);
        }
        return -1;
    }

    private int bSearch(int[] nums, int i, int j, int target) {
        int k = (i + j) / 2;
        if (nums[i] == target) {
            return i;
        }
        if (nums[j] == target) {
            return j;
        }
        if (target < nums[i]) {
            return -1;
        }
        if (target > nums[j]) {
            return -1;
        }

        if (target <= nums[k]) {
            return bSearch(nums, i, k, target);
        } else {
            return bSearch(nums, k + 1, j, target);
        }

    }
}