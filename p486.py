class Solution(object):
    def PredictTheWinner(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if nums == None:
            return False
        score1,score2,left,right=0,0,0,len(nums)-1
        turn=True
        while left < right:
            if turn:
   				if nums[left] > nums[right]:
	                score1 +=   
        
