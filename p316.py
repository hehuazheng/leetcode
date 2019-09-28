class Solution(object):
    def removeDuplicateLetters(self, s):
        '''
        :type s: str
        :rtype: str
        '''
        if len(s)==0: return ''
        cmap={}
        for x in s:
            if x in cmap: cmap[x]=cmap[x]+1
            else: cmap[x]=1
        res=s
        while True:
            i=0
            while True:
                if (i<len(res) and cmap[res[i]]==0) or (i+1<len(res) and res[i]<res[i+1] and cmap[res[i]]>=1):
                    cmap[res[i]]=0
                    i+=1
                else: break
            if i<len(res):
                c=res[i]
                if cmap[c]==1:
                    cmap[c]=cmap[c]-1
                    continue
                elif cmap[c]==0:
                    res = res[0:i] + res[i+1:]
                    continue
                else:
                    if i+1<len(res):
                        if c>=res[i+1]:
                            res = res[0:i] + res[i+1:]
                            cmap[c]=cmap[c]-1
        if cmap[res[-1]]>1: res = res[:-1]
        return res
        
if __name__ == '__main__':
    s=Solution()

    #print s.maxProduct([2, 3, -2, 4])
    #print s.removeDuplicateLetters('bcabc')
    #print s.removeDuplicateLetters('cbacdcbc')
    print s.removeDuplicateLetters('ccacbaba')
