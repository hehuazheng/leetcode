class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        def expand(s, l, r, len1):
            if l-1>=0 and r+1<len1:
                if s[l-1]=='(' and s[r+1]==')':
                    l=l-1
                    r=r+1
                elif:
            pass
        stack=[]
        len1=len(s)
        [stack.append(i) for i in range(len1) if s[i]=='(']
        l,r=None,None
        k=len(stack)
        maxlength=0
        while True:
            if k==0:
                break
            pos=stack[k]
            k-=1
            if pos+1>=len1:
                continue
            if s[pos+1]=')':
                if l==None: l=pos
                if r==None: r=pos+1
                maxlength=r-
                continue
            
        print stack
        
if __name__ == '__main__':
    s=Solution()
    s.longestValidParentheses(")()())")