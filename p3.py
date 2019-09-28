class Solution(object):
    def lengthOfLongestSubstring(self, s):
        '''
        :type s: str
        :rtype: int
        '''
        maxlength=0
    	reserve=[]
    	start=0
        for i in range(len(s)):
        	if s[i] in reserve:
        		submaxlength=i-start
        		if submaxlength > maxlength:
        			maxlength=submaxlength
        		characterStart=reserve.index(s[i])
        		reserve[0:characterStart+1]=[]
        		reserve.append(s[i])
        		start+=characterStart+1
        	elif i==len(s)-1:
        		submaxlength=i-start+1
        		if submaxlength > maxlength:
        			maxlength=submaxlength
        	else:
        		reserve.append(s[i])
        return maxlength