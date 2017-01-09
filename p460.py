import time

class LFUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity=capacity
        self.cache={}
        self.freq={}
        self.visitTime={}

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        return self.cache[key]

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if len(self.cache)>=self.capacity: self.removeOneKey()
        self.cache[key]=value
        if key in self.freq: self.freq[key] = self.freq[key]+1
        else: self.freq[key] = 1
        self.visitTime[key] = time.time()
        
    def removeOneKey(self):
        import pdb
        pdb.set_trace()
        items=self.cache.items()
        items.sort(self.ccmp)
        del self.cache[items[0]]
        del self.freq[items[0]]
        del self.visitTime[items[0]]
        print items
        print self.cache
        
    def ccmp(self, o1, o2):
        k1,v1=o1
        k2,v2=o2
        if self.freq[k1] < self.freq[k2]: return 1
        elif self.freq[k1] > self.freq[k2]: return -1
        if self.visitTime[k1] < self.visitTime[k2]: return 1
        elif self.visitTime[k1] > self.visitTime[k2]: return -1
        return 0

# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
        
if __name__ == '__main__':
    c=LFUCache(5)
    c.put(7,7)
    time.sleep(1)
    [c.put(i,i) for i in range(10)]
    for i in range(10):
        print c.get(i)
    #print s.isScramble("great","rgtae")
    #print s.isScramble("great","rgeat")
    #print s.isScramble("abc","deb")