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
        def recursive(s1,s2,s3,i,j,k):
            cnt=move(s1, s2, i,j)
            if i==len1 and j==len2: return True
            if i>=len1: return s2[j:]==s3[k:]
            if j>=len2: return s1[i:]==s3[k:]
            if cnt>0:
                sc=s1[i]
                dc=None
                flag=0
                if i+cnt<len1 and s1[i+cnt]!=sc: dc=s1[i+cnt]
                elif j+cnt<len2 and s2[j+cnt]!=sc: (flag,dc)=(1,s2[j+cnt])
                ti,tj=i,j
                for x in range(2*cnt):
                    if s3[k+x]==sc:
                        continue
                    elif s3[k+x]==dc:
                        if x<cnt: return False
                        else:
                            if flag==0:
                                ti+=cnt
                                tj+=x-cnt
                            else:
                                tj+=cnt
                                ti+=x-cnt
                            k+=x
                        break
                    else:
                        return False
                if ti==i and tj==j:
                    ti,tj,k=ti+cnt,tj+cnt,k+2*cnt
                return recursive(s1, s2, s3, ti, tj, k)
            else:
                if s1[i]==s3[k]: return recursive(s1, s2, s3, i+1, j, k+1)
                elif s2[j]==s3[k]: return recursive(s1, s2, s3, i, j+1, k+1)
                else: return False
            
        def move(s1, s2, i, j):
            cnt=0
            c=None
            if i<len1: c=s1[i]
            while True:
                if i>=len1 or j>=len2: return cnt
                if s1[i]!=c or s2[j]!=c: return cnt
                i,j,cnt=i+1,j+1,cnt+1
        return recursive(s1, s2, s3, 0,0,0)
        
        
if __name__ == '__main__':
    s=Solution()
    print s.isInterleave("ef","gh","ehgf")
    print s.isInterleave("aabc","abad","aabadabc")
    #print s.isInterleave("bbaabcc","bdbbca","bbbaadbbcbcac")
    #print s.isInterleave("aabcc","dbbca","aadbbbaccc")
    #print s.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa","babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab","babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab")