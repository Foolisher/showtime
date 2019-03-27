package leetcode.lenLongestFibSubseq;

import java.util.HashMap;

/**
 * Created by fuxiao(付笑) on 2019/3/14.
 */
public class lenLongestFibSubseq {
    public static void main(String[] args) {
        System.out.println(new Solution().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
//        System.out.println(new Solution().lenLongestFibSubseq(new int[]{1, 3, 4, 7, 10, 11, 12, 18, 23, 35}));
//        System.out.println(new Solution().lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
//        System.out.println(new Solution().lenLongestFibSubseq(new int[]{2, 4, 5, 6, 7, 8, 11, 13, 14, 15, 21, 22, 34}));
    }
}


/**
 * 1. 如何快速定位当前两个数之和
 * 2. 利用hash或数组下标直接索引到下一跳
 */
class Solution {
    //    3 <= A.length <= 1000
    //    1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9

    int MAX_N = 0;

    HashMap<Integer, Integer> valueIndex = new HashMap<>();

    public int lenLongestFibSubseq(int[] A) {
        long start = System.nanoTime();

        for (int i = 0; i < A.length; i++) {
            valueIndex.put(A[i], i);
        }

        for (int a = A.length - 3; a >= 0; a--) {
            for (int b = a + 1; b <= A.length - 2; b++) {
                if (valueIndex.get(A[a] + A[b]) != null) {
                    int N = searchFib(A, a, b);
                    MAX_N = Math.max(N, MAX_N);
                }
            }
        }

        System.out.println("time:" + (System.nanoTime() - start) + "  ");

        return MAX_N;
    }

    public int searchFib(int[] A, int a, int b) {

        int n = 0;
        int a0 = a, b0 = b;
        Integer c0;

        while ((c0 = valueIndex.get(A[a0] + A[b0])) != null && c0 > 0) {
            if (n == 0) {
                n = 3;
            } else {
                n++;
            }
            a0 = b0;
            b0 = c0;
        }

        return n;
    }

}
