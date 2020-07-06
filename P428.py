"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
from collections import deque


class Codec:
    def serialize(self, root: 'Node') -> str:
        """Encodes a tree to a single string.

        :type root: Node
        :rtype: str
        """
        if root is None:
            return ""

        result = ""
        q = deque([root, None])
        while len(q) > 0:
            size = len(q)
            for i in range(size):
                node = q.popleft()
                if node == None:
                    result += "null,"
                else:
                    result += str(node.val) + ","
                    for child in node.children:
                        q.append(child)
                    q.append(None)
        result = result.rstrip(',null')
        return result

    def deserialize(self, data: str) -> 'Node':
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: Node
        """
        if data is "":
            return None
        nodes = data.strip().split(',')
        for i in range(len(nodes)):
            if nodes[i] == 'null':
                nodes[i] = None
            else:
                nodes[i] = int(nodes[i])
        if len(nodes) == 0:
            return None

        q = deque()
        root = Node(int(nodes[0]))
        j = 2
        q.append(root)

        while len(q) > 0:
            size = len(q)
            for i in range(size):
                node = q.popleft()
                children = []
                while j < len(nodes) and nodes[j] != None:
                    x = Node(int(nodes[j]))
                    children.append(x)
                    q.append(x)
                    j += 1
                j += 1
                node.children = children
        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
