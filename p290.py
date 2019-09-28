class Solution(object):
    def wordPattern(self, pattern, str):
        '''
        :type pattern: str
        :type str: str
        :rtype: bool
        '''
        if pattern==None or str==None: return False
        
        plist = list(pattern)
        slist=str.split(' ')
        if len(plist) != len(slist): return False
        tb={}
        rset = set()
        for i in range(0, len(plist)):
            if plist[i] in tb:
                if tb[plist[i]] != slist[i]: return False
            else:
                if slist[i] in rset: return False
                tb[plist[i]] = slist[i]
                rset.add(slist[i])
        return True
        
if __name__ == '__main__':
    import pdb
    #pdb.set_trace()
    s=Solution()
    print s.wordPattern('abba','dog cat cat dog')
    print s.wordPattern('abba','dog cat cat fish')
    print s.wordPattern('aaaa','dog cat cat dog')
    print s.wordPattern('abba','dog dog dog dog')