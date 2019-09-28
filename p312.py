class Solution(object):
    def maxCoins(self, nums):
        '''
        :type nums: List[int]
        :rtype: int
        '''
        vnums=[1]+[i for i in nums if i>0] +[1]
        n = len(vnums)
        dp = [[0]*n for _ in xrange(n)]
        for k in xrange(2,n):
            for l in xrange(0, n-k):
                r = l + k
                for i in xrange(l+1, r):
                    dp[l][r] = max(dp[l][r], vnums[l]*vnums[i]*vnums[r] + dp[l][i] + dp[i][r])
        return dp[0][n-1]
        
if __name__ == '__main__':
    import pdb
    #pdb.set_trace()
    s = Solution()
    print s.maxCoins([3, 1, 5, 8])
