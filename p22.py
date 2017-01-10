class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        tb={0:[],1:["()"],2:["(())","()()"]}
        def bb(n):
            if n in tb: return tb[n]
            res=[]
            for i in range(1,n):
                for e1 in bb(i):
                    for e2 in bb(n-i):
                        res.append(e1+e2)
            for i in bb(n-1):
                res.append("("+i+")")
            tb[n]=res
            return res
        res=bb(n)
        res=list(set(res))
        res.sort()
        return res
        
if __name__ == '__main__':
    s=Solution()
    print s.generateParenthesis(4)
    #print s.isScramble("great","rgtae")
    #print s.isScramble("great","rgeat")
    #print s.isScramble("abc","deb")