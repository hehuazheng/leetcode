class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        def recursive(s, wordDict, tb):
            if s in tb: return tb[s]
            if s in wordDict:
                tb[s]=True
                return True
            len1=len(s)
            for i in range(1, len1):
                ts = s[0:i]
                if ts in wordDict:
                    if recursive(s[i:], wordDict, tb): return True
            tb[s]=False
            return False
        return recursive(s, wordDict, {})
        
if __name__ == '__main__':
    s=Solution()
    #print s.wordBreak("leetcode",["leet", "code"])
    import pdb
    pdb.set_trace()
    print s.wordBreak("ab",["a", "b"])
