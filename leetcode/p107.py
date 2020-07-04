# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return []
        result = []
        q = deque()
        q.append(root)
        while len(q) > 0:
            size = len(q)
            temp = []
            for i in range(size):
                x = q.popleft()
                if x.left != None:
                    q.append(x.left)

                if x.right != None:
                    q.append(x.right)

                temp.append(x.val)
            result.append(temp)
        return reversed(result)
