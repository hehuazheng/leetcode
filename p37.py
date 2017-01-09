class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]] ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        def next_pos(position):
            i,j=position
            j+=1
            if j>=9:
                j-=9
                i+=1
            return (i,j)
            
        def valid_nums(board, position):
            i,j=position
            s=[str(x) for x in range(1,10)]
            for x in range(9):
                if board[i][x]!='.' and board[i][x] in s:
                    s.remove(board[i][x])
                if board[x][j]!='.' and board[x][j] in s:
                    s.remove(board[x][j])
            r=(i/3)*3
            c=(j/3)*3
            for x in range(r,r+3):
                for y in range(c,c+3):
                    if board[x][y]!='.' and board[x][y] in s:
                        s.remove(board[x][y])
            return s
            
        def solveSudoku2(board,position):
            i,j=position
            if i==9:
                return True
            if board[i][j]=='.':
                nums=valid_nums(board, position)
                for n in nums:
                    board[i][j]=n
                    if solveSudoku2(board, next_pos(position)):
                        return True
                    board[i][j]='.'
            else:
                return solveSudoku2(board, next_pos(position))
        blist=[list(x) for x in board]
        solveSudoku2(blist, (0,0))
        return blist