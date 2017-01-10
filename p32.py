class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        self.stack=[]
        def findmaxlength(s):
            fl=findright(s, len(s))
            if fl>=0:
                if fl+1<len(s) and s[fl+1]=')':
                    self.stack.put((fl,fl+1))
                else:
                    for x,y in self.stack:
                        
            
        def findright(s, end):
            start=0
            for i in range(len(s[:end])):
                if s[i]=='(':
                    start=i
            return start
            
        valid=0
        len1=len(s)
        l,r=0,len1
        while True:
            if l>=r: break
            
        for i in s[len1::-1]:
            if s[i]=='(':
                a+=1
            elif a==0:
                continue
            else:
                a-=1
                if a==0 and (i+1>len1 or s[i+1]==')':
                    if i-start>res:
                        res=i-start
                    start=i+1
        
if __name__ == '__main__':
    s=Solution()
    res = s.longestValidParentheses(l1,2)
    while res:
        print res.val
        res=res.next