class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.res=[]
        candidates.sort()
        self.solve(candidates, target, 0, [])
        print self.res
        return self.res

    def solve(self, candidates, target, start, paths):
        length=len(candidates)
        if target==0:
            return self.res.append(paths)
        for i in range(start, length):
            if target < candidates[i]:
                return
            self.solve(candidates, target-candidates[i], i, paths + [candidates[i]])