class Solution(object):
    def myPow(self, x, n):
        '''
        :type x: float
        :type n: int
        :rtype: float
        '''
        if x==0:
            return 0
        if x==1:
            return 1
        if x==-1:
            return 1 if n%2==0 else -1
        if n==0:
            return 1
        val=1
        if n > 0:
            for i in xrange(n):
                if val > 0 and val < 1e-6:
                    return 0
                val *= x
            return val
        else:
            for i in xrange(-n):
                if val > 10000000:
                    return 0
                val *= x
            return 1.0/val
            
if __name__ == '__main__':
    s=Solution()
    print s.myPow(0.00001,2147483647)
    print s.myPow(34.00515,-3)
    print s.myPow(-13.62608,3)