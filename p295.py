class MedianFinder:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data={}
        self.cnt=0

    def addNum(self, num):
        """
        Adds a num into the data structure.
        :type num: int
        :rtype: void
        """
        self.cnt+=1
        self.data[num]=self.data.get(num, 0)+1

    def findMedian(self):
        """
        Returns the median of current data stream
        :rtype: float
        """
        even=cnt%2==0
        passnum = cnt/2
        cur = 0
        for k in self.data:
            endpos=cur+self.data[k]
            if endpos >= passnum:
                
        return self.sum*1.0/self.cnt

# Your MedianFinder object will be instantiated and called as such:

        
if __name__ == '__main__':
    mf = MedianFinder()
    mf.addNum(6)
    print mf.findMedian()
    mf.addNum(10)
    print mf.findMedian()
    mf.addNum(2)
    print mf.findMedian()
    mf.addNum(6)
    print mf.findMedian()
    mf.addNum(5)
    print mf.findMedian()
    mf.addNum(0)
    print mf.findMedian()
    mf.addNum(6)
    print mf.findMedian()
    mf.addNum(3)
    print mf.findMedian()
    mf.addNum(1)
    print mf.findMedian()
    mf.addNum(0)
    print mf.findMedian()
    mf.addNum(0)
    print mf.findMedian()