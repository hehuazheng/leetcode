class Solution(object):
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if not any(board): return
        rows,cols=len(board), len(board[0])
        seeds=[]
        for j in range(cols):
            if board[0][j]=='O': seeds.append((0,j))
            if board[rows-1][j]=='O': seeds.append((rows-1,j))
        for i in range(rows):
            if board[i][0]=='O': seeds.append((i,0))
            if board[i][cols-1]=='O': seeds.append((i,cols-1))
        while len(seeds)>0:
            (x,y)=seeds.pop()
            if 0<=x<rows and 0<=y<cols and board[x][y]=='O': 
                board[x][y]='S'
                seeds += (x+1,y),(x-1,y),(x,y+1),(x,y-1)
                
        board[:]=[['XO'[c=='S'] for c in row] for row in board]
        
if __name__ == '__main__':
    s=Solution()
    import pdb
    #pdb.set_trace()
    board=[['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]
    s.solve(board)
    print board
