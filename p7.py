import sys

class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        a=0
        b=x if x > 0 else -x
        while b:
        	a,b = a*10 + b%10, b/10
        if a > 2147483647:
        	return 0
        return a if x > 0 else -a