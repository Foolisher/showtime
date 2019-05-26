package leetcode.backpackage;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/4/23.
 */
public class backpackage {
    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(
            new int[]{5, 4, 7, 2, 6},
            new int[]{12, 3, 10, 3, 6},
            15
        ));
    }
}

class Solution {

    int maxValue(int W[], int V[], int C) {
        int dp[][] = new int[W.length][C + 1];
        for (int i = 0; i < W.length; i++) {
            for (int j = 1; j <= C; j++) {

                if (i == 0 && j >= W[i]) {
                    dp[i][j] = V[0];
                } else {

                    if (j > W[i]) {
                        int newV = dp[i - 1][j - W[i]] + V[i];
                        int lastV = dp[i - 1][j];
                        dp[i][j] = Math.max(newV, lastV);
                    }

                }

            }
        }
        return dp[W.length - 1][C];
    }

}