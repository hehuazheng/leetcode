class Solution(object):
    
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max=lambda x,y: x if x>y else y
        min=lambda x,y: x if x<y else y
        if len(nums)==1: return nums[0]
        pmax,lmax,lmin=nums[0],nums[0],nums[0]
        len1=len(nums)
        for i in range(1, len1):
            tmp=lmax
            lmax=max(max(tmp*nums[i],lmin*nums[i]),nums[i])
            lmin=min(min(tmp*nums[i],lmin*nums[i]),nums[i])
            if lmax>pmax: pmax=lmax
        return pmax
        
if __name__ == '__main__':
    s=Solution()
    import pdb
    pdb.set_trace()
    #print s.maxProduct([2, 3, -2, 4])
    print s.maxProduct([-4,-3,-2])
