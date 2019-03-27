package leetcode.combinationSum3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuxiao(��Ц) on 2019/3/22.
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

        // �Ż�: ��ʵ���ݲ����ܴ���ƽ����-k������һ�룬n����ƽ������Χk����
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
            // �Ż�: �ڵ����ڶ���ʱ�Ϳ���ֱ�Ӽ������һ���ڵ��Ƿ����
            // �����ڣ���ӽ�ȥ�����أ��������ھ�ֱ�ӷ��أ��ϲ��ջ
            if (sum - i > i && sum - i <= 9) {
                coll.add(sum - i);
                rst.add((List<Integer>) ((ArrayList<Integer>) coll).clone());
                coll.remove(coll.size() - 1);
            }
            return;
        }

        for (int j = i + 1; j <= 9; j++) {
            // ̽�⵽�Ѿ�û�����ݿ��Լӽ����� ���ⲻ��Ҫ�ݹ�
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