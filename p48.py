class Solution(object):
    def rotate(self, matrix):
        '''
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        '''
        n=len(matrix)
        b=[]
        for i in range(n):
            b.append([])
            for j in range(n):
                b[i].append([])

        for i in range(n):
            for j in range(n):
                b[i][j]=matrix[n-j-1][i]
        
        for i in range(n):
            for j in range(n):
                matrix[i][j]=b[i][j]
        
if __name__ == '__main__':
    s=Solution()
    s.rotate([[1]])
    s.rotate([[1,2],[3,4]])