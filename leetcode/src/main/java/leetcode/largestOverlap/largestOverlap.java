package leetcode.largestOverlap;

import com.google.gson.Gson;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/3/24.
 */
public class largestOverlap {

    public static void main(String[] args) {
        System.out.println(
            new Solution().largestOverlap(
                new Gson().fromJson(
                    "[ [1,1,0], \n" +
                        "   [0,1,0], \n" +
                        "   [0,1,0]]",
                    int[][].class
                ),
                new Gson().fromJson(
                    "[[0,0,0],\n" +
                        "   [0,1,1],\n" +
                        "   [0,0,1]]",
                    int[][].class
                )
            )

        );

        System.out.println(
            new Solution().largestOverlap(
                new Gson().fromJson(
                    "[ [1,0], \n" +
                        "   [0,0]]",
                    int[][].class
                ),
                new Gson().fromJson(
                    "[[0,1],\n" +
                        "  [1,0]]",
                    int[][].class
                )
            )

        );


    }
}


class Solution {

    public int largestOverlap(int[][] A, int[][] B) {
        int N = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int n = 0;
                for (int k = 0; k < B.length - i; k++) {
                    for (int l = 0; l < B[0].length - j; l++) {
                        n += B[k][l] & A[i + k][j + l];
                    }
                }
                N = Math.max(n, N);
            }
        }

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                int n = 0;
                for (int k = 0; k < A.length - i; k++) {
                    for (int l = 0; l < A[0].length - j; l++) {
                        n += A[k][l] & B[i + k][j + l];
                    }
                }
                N = Math.max(n, N);
            }
        }

        return N;
    }
}

