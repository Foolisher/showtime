package leetcode.maxSubArray;

/**
 * Created by fuxiao(��Ц) on 2019/4/22.
 */
public class maxSubArray {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(
            new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}
        ));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int M = nums[0];
        int M1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // ˼·��ԭ��
            // ��� preMax >0 ��˵��ǰ��һֱ�ڵ��������Լ���ǰ���ֵ
            if (M1 > 0) {
                M1 += nums[i];
            } else {  // ��֮��˵��ǰ���ֵû�����ӣ������ڼ��٣�����ô��ȥǰ����ۼ�
                M1 = nums[i];
            }
            M = Math.max(M, M1);
        }
        return M;
    }
}
