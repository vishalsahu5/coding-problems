# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        if head == None:
            return head

        dummy = ListNode(-1)
        dummy.next = head

        prev = dummy
        temp = head
        while temp != None:
            if temp.val == val:
                temp = temp.next
                prev.next = temp
            else:
                prev = prev.next
                temp = temp.next
        return dummy.next
