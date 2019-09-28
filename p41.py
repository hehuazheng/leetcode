class Solution(object):
    def longestValidParentheses(self, s):
        '''
        :type s: str
        :rtype: int
        '''
        s1=list(s)
        len1=len(s1)
        stack=[]
        [stack.append(i) for i in range(len1) if s[i]=='(']
        import pdb
        #pdb.set_trace()
        while len(stack)>0:
            top=stack.pop()
            if top+1<len1:
                if s1[top+1]==')':
                    s1[top]='o'
                    s1[top+1]='o'
                elif s1[top+1]!='o':
                    continue
                else:
                    tmp=top
                    while True:
                        if tmp+1<len1 and s1[tmp+1]=='o':
                            tmp+=1
                        else:
                            break
                    if tmp+1<len1 and s1[tmp+1]==')':
                        s1[tmp+1]='o'
                        s1[top]='o'
        maxlen=0
        len2=0
        for i in s1:
            if i=='o':
                len2+=1
                if len2>maxlen: maxlen=len2
            else:
                len2=0
        return maxlen
        
if __name__ == '__main__':
    s=Solution()
    print s.longestValidParentheses(')()())')
    print s.longestValidParentheses('()()')
    print s.longestValidParentheses('(')