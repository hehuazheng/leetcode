class Solution(object):
    def smallestGoodBase(self, n):
        '''
        :type n: str
        :rtype: str
        '''
        val=long(n)
        k=2
        while k<val:
            tmp = val
            while True:
                if (tmp-1)%k != 0: break
                tmp=(tmp-1)/k
                if tmp==1: return k
            k+=1

if __name__ == '__main__':
    s=Solution()
    #print s.smallestGoodBase('13')
    #print s.smallestGoodBase('4681')
    import pdb
    pdb.set_trace()
    print s.smallestGoodBase('1000000000000000000')
    #print s.isScramble('great','rgtae')
    #print s.isScramble('great','rgeat')
    #print s.isScramble('abc','deb')