package leetcode;

import java.util.ArrayList;

public class regionsBySlashes {

    public static void main(String[] args) {

        System.out.println(new Solution().regionsBySlashes(new String[]{
            "/ /",
            " / ",
        }));

    }

    static class Solution {
        int     N;
        int[][] graph    = new int[N][N];
        int[]   accessed = new int[N];

        public int regionsBySlashes(String[] input) {

            N = input.length * input.length;
            graph = new int[N][N];
            accessed = new int[N];

            for (int i = 0; i < N - 1; i++) {
                graph[i][i + 1] = 1;
                graph[N * i + (N - 1)][N * (i + 1) + (N - 1)] = 1;
                graph[N * i][N * (i + 1)] = 1;
                graph[N * (i - 1) + i][N * (i - 1) + i + 1] = 1;
            }


            return 0;
        }


    }

}

