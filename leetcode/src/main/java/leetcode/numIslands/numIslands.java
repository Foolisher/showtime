package leetcode.numIslands;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/3/11.
 */
public class numIslands {
    public static void main(String[] args) {

        String[] lines = (
            "11000\n" +
                "11000\n" +
                "00100\n" +
                "00011"
        ).split("\n");

        char[][] grid = new char[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }

        System.out.println(new Solution().numIslands(
            grid
        ));

    }
}


class Solution {
    int visited = 0;

    public int numIslands(char[][] grid) {
//        long start = System.currentTimeMillis();
        int n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    visit(grid, i, j);
                    n++;
                }
            }
        }
//        System.out.println("time: " + (System.currentTimeMillis() - start));
        return n;
    }

    public void visit(char[][] grid, int i, int j) {
        visited++;
        grid[i][j] = grid[i][j] == '1' ? '2' : grid[i][j];
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            visit(grid, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            visit(grid, i, j - 1);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            visit(grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            visit(grid, i - 1, j);
        }
    }

}