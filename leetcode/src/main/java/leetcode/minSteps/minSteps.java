package leetcode.minSteps;

/**
 * <pre>
 *  数学思想：依次分段，直到不能再分未知；每次分段都力求最小划分次数，这样就可以得到最小copy次数，直到划分到质数，就不能划分了，让后
 *  将分段的倍数+最小单位的步数加起来就得到最小划分步数；
 * </pre>
 * Created by fuxiao(付笑) on 2019/3/29.
 */
public class minSteps {
    public static void main(String[] args) {
        System.out.println(new Solution().minSteps(52));
    }
}


class Solution {

    public int minSteps(int n) {

        int ns[] = new int[]{0, 0, 2, 3, 4, 5, 5, 7, 6, 6, 7};
        int N = 0;

        if (n <= 10) {
            return ns[n];
        }

        int n0 = n;
        // 从2开始切分，如果无法切分，说明是质数，质数的最小步数就是它自己，copy N*1 次填满质数
        for (int i = 2; i < n0 / 2; ) {

            int t = n0 % i;
            // 找到切分段数
            if (t == 0) {
                n0 = n0 / i;
                N += i; // 段数就是copy次数（步数），累加起来
                i = 2;  // 切分方法再次回退到2开始
                if (n0 <= 10) { // 如果已经切分到最小粒度，加上最小粒度的步数，直接返回
                    return N += ns[n0];
                }
                continue;
            }
            i++;
        }
        if (n0 <= 10) {
            return N += ns[n0];
        } else {
            return N += n0;
        }

    }

}
