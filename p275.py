class Solution(object):
    def hIndex(self, citations):
        '''
        :type citations: List[int]
        :rtype: int
        '''
        len1 = len(citations)
        for i in range(0,len1):
            if(citations[i]>=len1-i): return len1-i
        return 0
        
if __name__ == '__main__':
    import pdb
    #pdb.set_trace()
    s=Solution()
    print s.hIndex([0, 1, 3, 5, 6])
    print s.hIndex([3,4,5,8,10])
    print s.hIndex([3,3,5,8,25])