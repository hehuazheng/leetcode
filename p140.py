class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        def recursive(s, wordDict, tb):
            if s in tb: return tb[s]
            result=[]
            if s in wordDict: result.append(s)
            len1=len(s)
            for i in range(1, len1):
                suffix=s[i:]
                if suffix in wordDict:
                    ts = s[0:i]
                    tmp=recursive(ts, wordDict, tb)
                    if tmp!= None:
                        for x in tmp: result.append(x +" "+suffix)
            tb[s]=result
            return result
        tb={}
        return recursive(s, wordDict, tb)
        
if __name__ == '__main__':
    s=Solution()
    print s.wordBreak("leetcode",["leet", "code"])
    import pdb
    #pdb.set_trace()
    print s.wordBreak("ab",["a", "b"])
    print s.wordBreak("aaaaaaa",["aaaa","aa","a"])
