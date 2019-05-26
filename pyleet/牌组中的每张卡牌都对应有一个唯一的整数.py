import collections
from typing import List


class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        if not deck: return []
        rst = []
        deck = sorted(deck, key=None, reverse=True)
        q = collections.deque(range(len(deck)))
        deck.pop(0)
        for v in deck:

            q.insert(0, q.pop())
            q.insert(0, v)

        return q


a = Solution().deckRevealedIncreasing([17, 13, 11, 2, 3, 5, 7])
print(a)
