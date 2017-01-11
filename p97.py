class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        if s1==None: return s3==s2
        if s2==None: return s3==s1
        if s1!=None or s2!=None:
            if s3==None: return False
            
        len1=len(s1)
        len2=len(s2)
        if len1+len2!=len(s3): return False
        def recursive(s1,s2,s3,i,j,k,tb):
            if (i,j,k) in tb: return tb[(i,j,k)]
            if i==len1 and j==len2: return True
            if i>=len1: return s2[j:]==s3[k:]
            if j>=len2: return s1[i:]==s3[k:]
            if s1[i]!=s3[k] and s2[j]!=s3[k]:
                tb[(i,j,k)]=False
                return False
            if s1[i]==s3[k]: 
                tb[(i,j,k)]=recursive(s1, s2, s3, i+1, j, k+1, tb)
                if tb[(i,j,k)]: return True
            if s2[j]==s3[k]: 
                tb[(i,j,k)]=recursive(s1, s2, s3, i, j+1, k+1, tb)
                if tb[(i,j,k)]: return True
            return False
            
        return recursive(s1, s2, s3, 0,0,0,{})
        
        
if __name__ == '__main__':
    s=Solution()
    print s.isInterleave("ef","gh","ehgf")
    print s.isInterleave("aabc","abad","aabadabc")
    print s.isInterleave("bbaabcc","bdbbca","bbbaadbbcbcac")
    print s.isInterleave("aabcc","dbbca","aadbbbaccc")
    print s.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa","babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab","babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab")