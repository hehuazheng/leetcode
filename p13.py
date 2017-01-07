class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result=[]
        count0=nums.count(0)
        if count0>=3:
            result.append([0,0,0])
        neg = [x for x in nums if x < 0]
        pos = [x for x in nums if x > 0]
        neg.sort()
        pos.sort()
        if count0>0:
            added = []
            for x in neg:
                if -x in pos and not x in added:
                    result.append([x,0,-x])
                    added.append(x)
        for k in range(len(neg)):
            x=neg[k]
            if k>0 and x==neg[k-1]:
                continue
            p=[]
            for i in range(len(pos)-1):
                sum=x+pos[i]
                if sum>=0:
                    break
                for j in range(i+1, len(pos)):
                    if pos[j]==-sum and [pos[i],pos[j]] != p:
                        p=[pos[i],pos[j]]
                        result.append([x,pos[i],pos[j]])
                        break
                    if pos[j]>-sum:
                        break
        for k in range(len(pos)):
            x=pos[k]
            if k>0 and x==pos[k-1]:
                continue
            p=[]
            for i in range(len(neg)-1):
                sum=x+neg[i]
                for j in range(i+1, len(neg)):
                    if neg[j]==-sum and [neg[i],neg[j]]!=p:
                        p=[neg[i],neg[j]]
                        result.append([neg[i],neg[j],x])
                        break
        return result