class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: Set[str]
        :rtype: int
        """
        def find_candidates(word, wordlist):
            candidates=[]
            len1=len(word)
            if len1>0:
                for w in wordlist:
                    if len1==len(w):
                        diffcnt=0
                        for i in range(len1):
                            if word[i]!=w[i]:
                                diffcnt+=1
                                if diffcnt>1:
                                    break
                        else:
                            if diffcnt==1: candidates.append(w)
            return candidates
            
        def recursive(end, stack, pos, wordList, depth):
            if pos>100000: return -1
            candidates=find_candidates(stack[pos], wordList)
            if end in candidates:
                return depth+1
            for i in candidates:
                if i in self.oneMoreStep:
                    return depth+2
            stack += candidates
            return recursive(end, stack, pos+1, wordList, depth+1)
            
        stack=[beginWord]
        self.oneMoreStep=find_candidates(endWord,wordList)
        return recursive(endWord, stack, 0, wordList, 1)
        
if __name__ == '__main__':
    s=Solution()
    print s.ladderLength("hit","cog",["hot","dot","dog","lot","log"])
    s=Solution()
    print s.ladderLength("hit","dit",["mit"])
