package leetcode.getPermutation;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class getPermutation {
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4, 9));
    }
}


class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder rst = new StringBuilder();
        int factorial[] = new int[n + 1];
        factorial[0] = 1;
        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            link.addLast(i);
        }

        int i;
        k--;
        for (i = n - 1; i >= 1; i--) {
            int index = k / factorial[i];
            rst.append(link.remove(index));
            k = k % factorial[i];
        }
        if (!link.isEmpty()) {
            rst.append(link.getFirst());
        }

        return rst.toString();
    }

}

