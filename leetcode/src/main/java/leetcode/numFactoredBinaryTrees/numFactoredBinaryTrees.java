package leetcode.numFactoredBinaryTrees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/4/7.
 */
public class numFactoredBinaryTrees {

    public static void main(String[] args) {
        System.out.println(new Solution().numFactoredBinaryTrees(
//            new int[]{2, 4}
//            new int[]{2, 3, 4, 6, 12}
            new int[]{18, 3, 6, 2}
        ));
    }

}


class Solution {

    Map<Double, Integer> valueIndex = new HashMap<>();
    int                  N          = 0;

    public int numFactoredBinaryTrees(int[] A) {

        Arrays.sort(A);

        for (int i = A.length - 1; i >= 0; i--) {
            valueIndex.put(A[i] * 1.0, i);
        }

        for (int i = A.length - 1; i >= 0; i--) {
            N += getNum(A, i);
        }

        return N;
    }


    int getNum(int[] A, int s) {
        int n = 0;
        for (int i = s; i >= 0; i--) {
            double l = A[i];
            double r = A[s] / l;
            if (i == s) {
                n = 1;
                continue;
            }
            if (l < r) {
                break;
            }
            Integer rIndex = valueIndex.get(r);
            if (rIndex != null) {
                if (l > r) {
                    return n + getNum(A, i) + getNum(A, rIndex);
                } else if (l == r) {
                    return n + getNum(A, i);
                }
            }
        }
        return n;
    }

}