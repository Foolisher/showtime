END = "#"


class Solution():

    def findWords(self, board, words):

        self.rst = set()
        if not board or not board[0]: return []
        if not words: return []

        root = {}
        for str in words:
            next = root
            for c in str:
                next = next.setdefault(c, {})
            next[END] = END

        self.m, self.n = len(board), len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] in root:
                    self._dfs(board, i, j, "", root)

        return self.rst

    def _dfs(self, board, i, j, buf, node):
        if self.m - 1 < i < 0 or self.n < j < 0 \
                or board[i][j] not in node or board[i][j] == '@': return
        buf += board[i][j]
        node = node[board[i][j]]
        if END in node:
            self.rst.add(buf)
        tmp, board[i][j] = board[i][j], '@'
        self._dfs(board, i - 1, j, buf, node)
        self._dfs(board, i + 1, j, buf, node)
        self._dfs(board, i, j - 1, buf, node)
        self._dfs(board, i, j + 1, buf, node)
        board[i][j] = tmp


rst = Solution().findWords(
    [['o', 'a', 'a', 'n'],
     ['e', 't', 'a', 'e'],
     ['i', 'h', 'k', 'r'],
     ['i', 'f', 'l', 'v']
     ],
    ["oath", "pea"]
)
print(rst)
