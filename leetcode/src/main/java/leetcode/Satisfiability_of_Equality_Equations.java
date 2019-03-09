package leetcode;

public class Satisfiability_of_Equality_Equations {

    public static void main(String[] args) {
        System.out.println(new Solution().equationsPossible(new String[]{"c==c","f!=a","f==b","b==c"}));
    }

}


class Solution {
    public boolean equationsPossible(String[] equations) {
        int v[] = new int[128];
        int flag = 1;
        String exp0 = equations[0];
        if (exp0.charAt(1) == '=') {
            v[exp0.charAt(0)] = flag;
            v[exp0.charAt(3)] = flag;
        } else {
            v[exp0.charAt(0)] = flag;
            v[exp0.charAt(3)] = ++flag;
        }

        boolean eqAll = false;
        for (int i = 1; i < equations.length; i++) {
            String exp = equations[i];
            char a = exp.charAt(0);
            char b = exp.charAt(3);
            char comp = exp.charAt(1);
            if (comp == '=') {
                if (v[a] == 0 && v[b] == 0) {
                    v[a] = flag;
                    v[b] = flag++;
                } else if (v[a] != 0 && v[b] != 0 && v[a] != v[b]) {
                    return false;
                } else if (v[a] != 0 && v[b] == 0) {
                    v[b] = flag;
                } else if (v[b] != 0 && v[a] == 0) {
                    v[a] = flag;
                }
                eqAll = v[a] == v[b];
            } else {
                if (v[a] == 0 && v[b] == 0) {
                    v[a] = ++flag;
                    v[b] = ++flag;
                } else if (v[a] != 0 && v[b] != 0 && v[a] == v[b]) {
                    return false;
                } else if (v[a] != 0 && v[b] == 0) {
                    v[b] = ++flag;
                } else if (v[b] != 0 && v[a] == 0) {
                    v[a] = ++flag;
                }
                eqAll = v[a] != v[b];
            }
            if (!eqAll) {
                return eqAll;
            }
        }
        return eqAll;
    }
}
