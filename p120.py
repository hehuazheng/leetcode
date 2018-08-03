class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        rows=len(triangle)
        tb=[0 for i in range(0,rows * (rows+1)/2)];
        tb[0] = triangle[0][0]
        for i in range(1,rows):
            columns = len(triangle[i])
            tb[i][0]=tb[i-1][0]+triangle[i][0]
            for j in range(1,columns):
                if tb[i-1][j-1] < tb[i-1][j]:
                    tb[i][j]=tb[i-1][j-1]+triangle[i][j]
                else:
                    tb[i][j]=tb[i-1][j]+triangle[i][j]
        print tb
        
if __name__ == '__main__':
    s=Solution()
    s.minimumTotal([
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ])
