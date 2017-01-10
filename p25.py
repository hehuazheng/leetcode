# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        previous=nHead=ListNode(0)
        node=nHead.next=head
        stack=[]
        while node:
            stack.append(node)
            node=node.next
            if len(stack)==k:
                while len(stack)>0:
                    pnode=stack.pop()
                    previous.next=pnode
                    previous=pnode
        else:
            if len(stack)>0:
                previous.next=stack[0]
            else:
                previous.next=None
        return nHead.next
        
if __name__ == '__main__':
    s=Solution()
    l1=ListNode(1)
    l2=ListNode(2)
    l1.next=l2
    l2.next=None
    res = s.reverseKGroup(l1,2)
    while res:
        print res.val
        res=res.next