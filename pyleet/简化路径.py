class Solution:
    def simplifyPath(self, path: str) -> str:
        rst = []
        path = path.split("/")
        for i, v in enumerate(path):
            if v not in ['.', '', '..']:
                rst.append(v)
            if v == '..' and rst:
                rst.pop()

        if not rst:
            return "/"
        return '/' + '/'.join(rst)


print(Solution().simplifyPath("/a/./b/../../c/"))
print(Solution().simplifyPath("/a/../../b/../c//.//"))
print(Solution().simplifyPath("/a//b////c/d//././/.."))
print(Solution().simplifyPath("/a//b////c/d//././/.."))
print(Solution().simplifyPath("/a/./b/../../c/"))
