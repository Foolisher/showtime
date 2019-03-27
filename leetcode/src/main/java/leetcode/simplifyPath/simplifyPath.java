package leetcode.simplifyPath;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by fuxiao(¸¶Ð¦) on 2019/3/24.
 */
public class simplifyPath {
    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new Solution().simplifyPath("/home/foo/.ssh2/authorized_keys/"));
        System.out.println(new Solution().simplifyPath("/home/foo/.ssh/authorized_keys/"));
        System.out.println(new Solution().simplifyPath("/home/foo"));
        System.out.println(new Solution().simplifyPath("/...hidden"));
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Solution().simplifyPath("/home//foo/"));
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("/../"));
        System.out.println(new Solution().simplifyPath("/a//b////c/d//././/.."));
        System.out.println(new Solution().simplifyPath("/..."));
    }
}


class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                if (stack.size() > 0 && stack.peek().equals("/")) {
                    continue;
                } else {
                    stack.push("/");
                }
            } else {
                StringBuilder w = new StringBuilder();
                while (i < path.length() && path.charAt(i) != '/') {
                    w.append(path.charAt(i));
                    ++i;
                }
                if (w.length() > 0) {
                    i--;
                }
                String wd = w.toString();
                if (wd.equals("..")) {
                    if (stack.size() >= 2) {
                        stack.pop();
                    }
                    if (stack.size() >= 2) {
                        stack.pop();
                    }
                } else if (!wd.equals(".")) {
                    stack.push(wd);
                }
            }

        }

        if (stack.size() > 1 && stack.peek().equals("/")) {
            stack.pop();
        }

        StringBuilder rst = new StringBuilder();
        while (stack.size() > 0) {
            rst.append(stack.removeLast());
        }

        return rst.toString();
    }
}
