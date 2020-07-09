# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import deque


class Solution:
    def widthOfBinaryTree(self, root: TreeNode) -> int:
        if root == None:
            return 0
        q = deque()
        currMax = 1
        q.append(root)
        hd = {}
        hd[root] = 0
        while len(q) > 0:
            size = len(q)
            firstIndex = hd[q[0]]
            for i in range(size):
                node = q.popleft()
                if node.left:
                    q.append(node.left)
                    hd[node.left] = 2 * hd[node]
                if node.right:
                    q.append(node.right)
                    hd[node.right] = 2 * hd[node] + 1

                currMax = max(currMax, hd[node] - firstIndex + 1)
        return currMax
