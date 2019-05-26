package leetcode.数组中的第K个最大元素;

import com.sun.tools.internal.xjc.generator.bean.BeanGenerator;

/**
 * Created by fuxiao(付笑) on 2019/5/11.
 */
public class 数组中的第K个最大元素 {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(
//            new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4
            new int[]{3, 2, 1, 5, 6, 4}, 4
        ));
    }
}


class Solution {
    public int findKthLargest(int[] nums, int k) {

        int a = 0;
        int b = nums.length - 1;
        k = nums.length - k;
        while (a < b) {
            int pos = quickSelect(nums, a, b);
            if (pos == k) {
                return nums[pos];
            }
            if (pos < k) {
                a = pos + 1;
            } else {
                b = pos - 1;
            }
        }
        return nums[b];
    }

    public int quickSelect(int[] A, int a, int b) {
        int p = A[b];
        int i = a;
        while (i < b) {
            if (A[i] < p) {
                swap(A, a, i);
                a++;
            }
            i++;
        }
        swap(A, a, b);
        return a;
    }


    public void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}