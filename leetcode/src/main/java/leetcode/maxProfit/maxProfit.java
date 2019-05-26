package leetcode.maxProfit;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/4/22.
 */
public class maxProfit {
    public static void main(String[] args) {
        System.out.println(
            new Solution().maxProfit(new int[]{
                    7, 1, 5, 3, 6, 4
                }
            )
        );
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int A[] = new int[prices.length];
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            A[i] = prices[i] - prices[i - 1];
            sum += A[i] > 0 ? A[i] : 0;
        }
        return sum;
    }

    int maxSubArray(int A[], int l, int r) {
        if (l >= r) {
            return Math.max(A[l], 0);
        }

        int m = (r - l) / 2 + l;
        int leftSum = 0, maxLeft = 0;
        for (int i = m; i >= l; leftSum += A[i--], maxLeft = Math.max(leftSum, maxLeft)) {
        }
        int rightSum = 0, maxRight = 0;
        for (int i = m + 1; i <= r; rightSum += A[i++], maxRight = Math.max(rightSum, maxRight)) {
        }

        return Math.max(Math.max(maxLeft + maxRight, Math.max(maxSubArray(A, l, m), maxSubArray(A, m + 1, r))), 0);
    }

}
