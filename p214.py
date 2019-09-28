class Solution(object):
    def shortestPalindrome(self, s):
        '''
        :type s: str
        :rtype: str
        '''
        if len(s)<=1: return s
        len1=len(s)
        start=len1/2
        if len1%2!=0:
            i=1
            while start-i>=0:#symmetric by one point
                if s[start-i]!=s[start+i]: break
                i+=1
            if start-i<0: return s[start+1:][::-1]+s[start:]
        same,fc=0,s[0]
        while s[same]==fc: same+=1
        
        start-=1
        while start>0:
            i=1
            while start-i>=0:#symmetric by one point
                if s[start-i]!=s[start+i]: break
                i+=1
            if start-i<0:
                print 'single'
                print start,i
                if same>start: start=same
                return s[start+1:][::-1]+s[start:]
            i=1
            if s[start]==s[start+1]:#symmetric by a pair
                while start-i>=0:
                    if s[start-i]!=s[start+1+i]: break
                    i+=1
            if start-i<0:
                if same>start: start=same
                return s[start+2:][::-1]+s[start:]        
            start-=1
        return s[same:][::-1] + s
        
if __name__ == '__main__':
    s=Solution()
    print s.shortestPalindrome('abcd')
    print s.shortestPalindrome('aacecaaa')
    print s.shortestPalindrome('ba')
    print s.shortestPalindrome('abb')
    print s.shortestPalindrome('aabba')
    import pdb
    pdb.set_trace()
    print s.shortestPalindrome('aaaabbaa')
