package leetcode.combinationSum3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuxiao(付笑) on 2019/3/22.
 */
public class combinationSum3 {

    public static void main(String[] args) {
        System.out.println(
            new Solution().combinationSum3(3, 15)
        );
    }

}


class Solution {


    List<List<Integer>> rst = new ArrayList<>();
    int                 K, S;

    public List<List<Integer>> combinationSum3(int k, int n) {
        K = k;
        S = n;

        // 优化: 其实数据不可能大于平均数-k个数的一半，n等于平均数周围k个数
        for (int i = 1; i <= n / k - k / 2 + 1; i++) {
            ArrayList<Integer> coll = new ArrayList<>(n);
            coll.add(i);
            trace(i, K, S, coll);
            if (coll.size() == K) {
                System.out.println(coll);
            }
        }

        return rst;
    }

    public void trace(int i, int n, int sum, List<Integer> coll) {
        if (n == 2) {
            // 优化: 在倒数第二个时就可以直接计算最后一个节点是否存在
            // 若存在，添加进去并返回，若不存在就直接返回，上层出栈
            if (sum - i > i && sum - i <= 9) {
                coll.add(sum - i);
                rst.add((List<Integer>) ((ArrayList<Integer>) coll).clone());
                coll.remove(coll.size() - 1);
            }
            return;
        }

        for (int j = i + 1; j <= 9; j++) {
            // 探测到已经没有数据可以加进来， 避免不必要递归
            if (n <= 2 && sum - i > 9) {
                continue;
            }
            int remain = sum - i;
            if (remain > j) {
                coll.add(j);
                trace(j, n - 1, sum - i, coll);
                coll.remove(coll.size() - 1);
            }
        }

    }

}