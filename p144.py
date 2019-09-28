# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        '''
        :type root: TreeNode
        :rtype: List[int]
        '''
        if root==None: return []
        stack=[root]
        res=[]
        while len(stack)>0:
            top=stack.pop()
            res.append(top.val)
            if top.right != None: stack.append(top.right)
            if top.left != None: stack.append(top.left)
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
    print s.preorderTraversal(n1)
