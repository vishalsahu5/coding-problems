"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

def dfs(head, result):
    if head == None:
        return
    result.append(head.val)
    
    if head.child:
        dfs(head.child, result)
    dfs(head.next, result)

class Solution:
    def flatten(self, head: 'Node') -> 'Node':
        if head == None:
            return None
        result = []
        dfs(head,result)
        newHead = Node(result[0])
        dummy = Node(-1)
        dummy.next = newHead
        
        for i in range(1, len(result)):
            newHead.next = Node(result[i])
            back = newHead
            newHead = newHead.next
            newHead.prev = back
        return dummy.next
            
            