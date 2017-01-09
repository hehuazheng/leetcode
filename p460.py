class LFUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity=capacity
        self.cache={}
        self.freq={}
        self.times={}

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.cache:
            occurency=self.freq[key]
            self.times[occurency].remove(key)
            self.times[occurency].append(key)
            return self.cache[key]
        else:
            return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if key in self.cache:
            self.cache[key]=value
            occurency=self.freq[key]
            self.freq[key]=occurency+1
            self.times[occurency].remove(key)
            if not occurency+1 in self.times:
                self.times[occurency+1] = [key]
            else:
                self.times[occurency+1].append(key)
            return
        if len(self.cache)>=self.capacity:
        	self.removeOneKey()
        self.cache[key]=value
        self.freq[key] = 1
        if 1 in self.times:
            self.times[1].append(key)
        else:
            self.times[1] = [key]
        
    def removeOneKey(self):
        import pdb
        #pdb.set_trace()
        items=self.times.items()
        key=items[0][1][0]
        del self.cache[key]
        del self.freq[key]
        self.times[items[0][0]].remove(key)

# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
        
if __name__ == '__main__':
    c=LFUCache(2)
    c.put(1,1)
    c.put(2,2)
    print c.get(1)
    c.put(3,3)
    print c.get(2)
    print c.get(3)
    c.put(4,4)
    print c.get(1)
    print c.get(3)
    print c.get(4)
    #print s.isScramble("great","rgtae")
    #print s.isScramble("great","rgeat")
    #print s.isScramble("abc","deb")