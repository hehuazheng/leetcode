class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n<=0: return 0
        tb={}
        import math
        maxsquare=int(math.sqrt(n))+1
        for i in range(1, maxsquare): tb[i*i]=1
        if n in tb: return 1
        def permute(s):
            if s in tb: return tb[s]
            min = s
            for i in range(1, maxsquare):
                if i*i > s: break
                val = permute(s-i*i) +1
                if val==1:
                    min=1
                    break
                elif min >= val:
                    min=val
            tb[s]=min
            return min
        return permute(n)
        
if __name__ == '__main__':
    import pdb
    pdb.set_trace()
    s=Solution()
    print s.numSquares(4)
    print s.numSquares(12)
    print s.numSquares(13)