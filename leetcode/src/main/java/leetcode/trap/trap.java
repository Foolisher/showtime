package leetcode.trap;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/4/20.
 */
public class trap {

    public static void main(String[] args) {
        System.out.println(new Solution().trap(
            new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
        ));
    }
}

class Solution {
    public int trap(int[] height) {
        int N = 0, mid = 0;
        if (height.length == 0) return 0;

        for (int i = 0; i < height.length; i++) {
            mid = height[i] > height[mid] ? i : mid;
        }

        int leftStart = height[0];
        for (int i = 1; i <= mid; i++) {
            if (height[i] > leftStart) {
                leftStart = height[i];
            } else {
                N += leftStart - height[i];
            }
        }

        int rightStart = height[height.length - 1];
        for (int i = height.length - 1; i >= mid; i--) {
            if (height[i] > rightStart) {
                rightStart = height[i];
            } else {
                N += rightStart - height[i];
            }
        }

        return N;
    }
}
