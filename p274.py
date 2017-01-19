class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        citations.sort(reverse=True)
        res = len(citations)
        while res>0:
            if(citations[res-1]>=res): return res
            res-=1
        return 0
        
if __name__ == '__main__':
    import pdb
    #pdb.set_trace()
    s=Solution()
    print s.hIndex([3, 0, 6, 1, 5])
    print s.hIndex([10,8,5,4,3])
    print s.hIndex([25,8,5,3,3])