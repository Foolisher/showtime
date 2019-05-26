package leetcode.minSteps;

/**
 * <pre>
 *  ��ѧ˼�룺���ηֶΣ�ֱ�������ٷ�δ֪��ÿ�ηֶζ�������С���ִ����������Ϳ��Եõ���Сcopy������ֱ�����ֵ��������Ͳ��ܻ����ˣ��ú�
 *  ���ֶεı���+��С��λ�Ĳ����������͵õ���С���ֲ�����
 * </pre>
 * Created by fuxiao(��Ц) on 2019/3/29.
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
        // ��2��ʼ�з֣�����޷��з֣�˵������������������С�����������Լ���copy N*1 ����������
        for (int i = 2; i < n0 / 2; ) {

            int t = n0 % i;
            // �ҵ��зֶ���
            if (t == 0) {
                n0 = n0 / i;
                N += i; // ��������copy���������������ۼ�����
                i = 2;  // �зַ����ٴλ��˵�2��ʼ
                if (n0 <= 10) { // ����Ѿ��зֵ���С���ȣ�������С���ȵĲ�����ֱ�ӷ���
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
