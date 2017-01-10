# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1==None: return l2
        if l2==None: return l1
        if l1==None and l2==None: return []
        head = ListNode(0)
        res = head
        while True:
            if l1==None and l2==None: break
            if l1==None:
                res.next=l2
                break
            if l2==None:
                res.next=l1
                break
            val1,val2=l1.val,l2.val
            if val1<=val2:
                res.next=l1
                res=res.next
                l1=l1.next
            else:
                res.next=l2
                res=res.next
                l2=l2.next
        return head.next
        
if __name__ == '__main__':
    s=Solution()
    print s.mergeTwoLists([],[])
    print s.mergeTwoLists([1],[])
    print s.mergeTwoLists([],[1])
    print s.mergeTwoLists([1],[2])
    print s.mergeTwoLists([1],[2,3])
    print s.mergeTwoLists([1,3],[2])
    #print s.isScramble("great","rgtae")
    #print s.isScramble("great","rgeat")
    #print s.isScramble("abc","deb")