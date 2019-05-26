package leetcode.maximalSquare;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/4/22.
 */
public class maximalSquare {
    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(
            new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
            }
        ));
    }
}


class Solution {

    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        if (matrix.length == 0) {
            return 0;
        }
        int dp[][] = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] - '0';
            maxLen = Math.max(dp[0][i], maxLen);
        }
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxLen = Math.max(dp[i][0], maxLen);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen * maxLen;
    }
}