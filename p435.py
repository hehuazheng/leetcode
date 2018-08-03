class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        for i in intervals:
            print i.start,i.end
        
if __name__ == '__main__':
    s=Solution()
    #print s.smallestGoodBase("13")
    #print s.smallestGoodBase("4681")
    import pdb
    #pdb.set_trace()
    print s.eraseOverlapIntervals([Interval(1,2), Interval(1,2), Interval(1,2)])
    #print s.isScramble("great","rgtae")
    #print s.isScramble("great","rgeat")
    #print s.isScramble("abc","deb")