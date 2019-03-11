package leetcode.isValidSudoku;

import com.google.gson.Gson;

/**
 * Created by fuxiao(��Ц) on 2019/3/4.
 */
public class isValidSudoku {

    public static void main(String[] args) {

//        System.out.println(new Solution().isValidSudoku(
//            new Gson().fromJson(
//                ("[\n" +
//                    "  [\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\n" +
//                    "  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\n" +
//                    "  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\n" +
//                    "  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\n" +
//                    "  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\n" +
//                    "  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\n" +
//                    "  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\n" +
//                    "  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\n" +
//                    "  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\n" +
//                    "]")
//                    .replaceAll("\\.", "0"),
//                char[][].class)
//        ));


        System.out.println(new Solution().isValidSudoku(
            new Gson().fromJson(
                ("[\n" +
                    "  [\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\n" +
                    "  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\n" +
                    "  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\n" +
                    "  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\n" +
                    "  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\n" +
                    "  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\n" +
                    "  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\n" +
                    "  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\n" +
                    "  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\n" +
                    "]")
                ,
                char[][].class)
        ));

        System.out.println(new Solution().isValidSudoku(
            new Gson().fromJson(
                ("[" +
                    "[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]," +
                    "[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]," +
                    "[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]," +
                    "[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]," +
                    "[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]," +
                    "[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]," +
                    "[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]," +
                    "[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]," +
                    "[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]" +
                    "]")
                ,
                char[][].class)
        ));
    }


}

@SuppressWarnings("Duplicates")
class Solution {
    public boolean isValidSudoku(char[][] board) {

        int[][] rows = new int[9][10]; // rows mapping  i: [0,0,58...]
        int[][] cols = new int[9][10]; // cols mapping  i: [1,0,3 ...]

        int subBox[];           // 3cells box

        for (int i = 0; i < 9; i++) {
            subBox = new int[10];
            int row = i / 3 * 3;
            int col = i % 3 * 3;
            for (int row0 = row; row0 < row + 3; row0++) {
                for (int col0 = col; col0 < col + 3; col0++) {
                    board[row0][col0] = board[row0][col0] == '.' ? '0' : board[row0][col0];
                    int num = board[row0][col0] - '0';
                    if (rows[row0][num] > 0) {
                        return false;
                    }
                    rows[row0][num] = num;

                    if (subBox[num] > 0) {
                        return false;
                    }
                    subBox[num] = num;
                }
            }

            for (int col0 = col; col0 < col + 3; col0++) {
                for (int row0 = row; row0 < row + 3; row0++) {
                    int num = board[row0][col0] - '0';
                    if (cols[col0][num] > 0) {
                        return false;
                    }
                    cols[col0][num] = num;
                }
            }
        }

        return true;
    }
}