package leetcode.orderOfLargestPlusSign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.google.gson.Gson;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/4/4.
 */
public class orderOfLargestPlusSign {

    public static void main(String[] args) {
        System.out.println(new Solution().orderOfLargestPlusSign(5,
            new Gson().fromJson("[[1,0],[1,4],[2,4],[3,2],[4,0],[4,3]]", int[][].class)
//            new Gson().fromJson("[[4,3]]", int[][].class)
//            new Gson().fromJson("[[3,0],[3,3]]", int[][].class)
        ));
    }

}

class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (N <= 0) {
            return 0;
        }

        int[][] grid = new int[N][N];
        for (int[] row : grid) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        for (int i = 0; i < N; i++) {

            int d = 0, u = 0, r = 0, l = 0;
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    grid[i][j] = Math.min(grid[i][j], ++r);
                } else {
                    r = 0;
                }
                if (grid[i][N - 1 - j] != 0) {
                    grid[i][N - 1 - j] = Math.min(grid[i][N - 1 - j], ++l);
                } else {
                    l = 0;
                }
                if (grid[j][i] != 0) {
                    grid[j][i] = Math.min(grid[j][i], ++d);
                } else {
                    d = 0;
                }
                if (grid[N-1-j][i] != 0) {
                    grid[N-1-j][i] = Math.min(grid[N-1-j][i], ++u);
                } else {
                    u = 0;
                }

            }

        }

        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                max = Math.max(max, grid[i][j]);
            }
        }

        return max;
    }
}