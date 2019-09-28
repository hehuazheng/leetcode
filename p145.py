# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        '''
        :type root: TreeNode
        :rtype: List[int]
        '''
        stack=[]
        p=root
        res=[]
        while len(stack)>0 or p != None:
            if p != None:
                res.append(p.val)
                stack.append(p)
                p = p.right
            else:
                p = stack.pop().left
        res.reverse()
        return res
        
if __name__ == '__main__':
    n1=TreeNode(1)
    n2=TreeNode(4)
    n3=TreeNode(3)
    n4=TreeNode(2)
    n1.left=n2
    n1.right=n3
    n2.left=n4
    s=Solution()
    import pdb
    pdb.set_trace()
    print s.postorderTraversal(n1)
