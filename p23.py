class Solution(object):
    def mergeKLists(self, lists):
        '''
        :type lists: List[ListNode]
        :rtype: ListNode
        '''
        if len(lists)==1:
            return lists[0]
        result=lists[0]
        for i in range(1, len(lists)):
            result=self.merge(result,lists[i])
        return result

    def merge(self,list1, list2):
    	if list1==None:
    		return list2
    	if list2==None:
    		return list1
        e=None
        start=None
        while True:
            if list1==None:
                e.next=list2
                break
            if list2==None:
                e.next=list1
                break
            if list1.val<list2.val:
            	if start==None:
            		start=list1
                if e==None:
                    e=list1
                else:
                    e.next=list1
                list1=list1.next
            else:
                if start==None:
                    start=list1
                if e==None:
                    e=list2
                else:
                    e.next=list2
                list2=list2.next
        return start

s=Solution()
s.mergeKLists([[1,2,4],[1,1,2]])