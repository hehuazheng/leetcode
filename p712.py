class Solution(object):
    def minimumDeleteSum(self, s1, s2):
        '''
        :type s1: str
        :type s2: str
        :rtype: int
        '''
        print 'len1: %s' % len(s1)
        for i in range(len(s1)):
            for j in range(len(s2)):
                pass

if __name__ == '__main__':
    s=Solution()
    print s.minimumDeleteSum('delete','leet')