class Solution(object):
    def numDecodings(self, s):
        '''
        :type s: str
        :rtype: int
        '''
        s1=list(s)
        i=0
        while True:
            if i>=len(s1): break
            if int(s1[i])==0:
                if i-1<0 or s1[i-1]=='x': return 0
                prefix = int(s1[i-1])
                if prefix>=3 or prefix==0: return 0
                s1[i-1]=s1[i]='x'
            i+=1
        len1=len(s1)
        def recursive(s, start, tb):
            if start>=len1-1: return 1
            if start in tb: return tb[start]
            current=s[start]
            if current=='x':
                tb[start]=recursive(s,start+1,tb)
                return tb[start]
            next=s[start+1]
            if next=='x':
                tb[start]=recursive(s, start+2, tb)
                return tb[start]
            elif  int(current)==1 or (int(current)==2 and int(next)<7):
                tb[start]=recursive(s, start+1, tb)+recursive(s, start+2, tb)
                return tb[start]
            else:
                tb[start]=recursive(s, start+1, tb)
                return tb[start]
        return recursive(s1,0,{})

if __name__ == '__main__':
    s=Solution()
    '''
    print s.numDecodings('1000')
    print s.numDecodings('1010')
    print s.numDecodings('1203')
    print s.numDecodings('12')
    print s.numDecodings('123')
    print s.numDecodings('1234')
            '''
    print s.numDecodings('17')
