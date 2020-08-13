# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


def dfs(root, target):
    if (root == None):
        return 0

    result = root.val

    if (target < root.val and root.left is not None):
        left = dfs(root.left, target)
        if abs(target-left) < abs(target-result):
            return left
    elif (target > root.val and root.right is not None):
        right = dfs(root.right, target)
        if abs(target-right) < abs(target-result):
            return right
    return root.val


class Solution:
    def closestValue(self, root: TreeNode, target: float) -> int:
        return dfs(root, target)
