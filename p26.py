class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(nums):
            i=0
            previous = nums[i]
            for j in range(1, len(nums)):
                if nums[j] != previous:
                    previous = nums[j]
                    nums[i+1]=nums[j]
                    i+=1
            return len(nums)
